package ie.granades.gaelgo.service;

import ie.granades.gaelgo.model.Package;
import ie.granades.gaelgo.model.Provider;
import ie.granades.gaelgo.repository.PackageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import ie.granades.gaelgo.model.PackagePriceHistory;
import ie.granades.gaelgo.model.PackageProviderLink;
import ie.granades.gaelgo.repository.PackagePriceHistoryRepository;
import ie.granades.gaelgo.repository.PackageProviderLinkRepository;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    // Link && History Prices tables
    private final PackageProviderLinkRepository linkRepository;
    private final PackagePriceHistoryRepository priceHistoryRepository;

    // private final PackagePriceHistoryRepository priceHistoryRepository;

    public PackageServiceImpl(
            PackageRepository packageRepository,
            PackageProviderLinkRepository linkRepository,
            PackagePriceHistoryRepository priceHistoryRepository
    ) {
        this.packageRepository = packageRepository;
        this.linkRepository = linkRepository;
        this.priceHistoryRepository = priceHistoryRepository;
    }

    // ----------------- ProviderLink ---------- //
    @Override
    public List<PackageProviderLink> getProviderLinks(Long packageId) {
        getPackageById(packageId);
        return linkRepository.findByTravelPackage_PackageId(packageId);
    }


    // ---------------- CRUD ----------------

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public Package getPackageById(Long id) {
        return packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found: " + id));
    }

    @Override
    @Transactional
    public Package create(Package travelPackage) {
        validatePackage(travelPackage);

        travelPackage.setCurrency(travelPackage.getCurrency().toUpperCase());
        return packageRepository.save(travelPackage);
    }

    @Override
    @Transactional
    public Package update(Long id, Package updated) {
        Package existing = getPackageById(id);


        existing.setTitle(updated.getTitle());
        existing.setDestination(updated.getDestination());
        existing.setPrice(updated.getPrice());
        existing.setCurrency(updated.getCurrency());
        existing.setDepartureDate(updated.getDepartureDate());
        existing.setNights(updated.getNights());
        existing.setDeparture(updated.getDeparture());
        existing.setAirline(updated.getAirline());
        existing.setHotel(updated.getHotel());
        existing.setDescription(updated.getDescription());
        existing.setIncludes(updated.getIncludes());
        existing.setImage(updated.getImage());

        validatePackage(existing);
        existing.setCurrency(existing.getCurrency().toUpperCase());

        return packageRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!packageRepository.existsById(id)) {
            throw new RuntimeException("Package not found: " + id);
        }
        packageRepository.deleteById(id);
    }

    // ---------------- SEARCH ---------------- TODO: sustitute after mvp for one method

    @Override
    public List<Package> searchByDestination(String destination) {
        return packageRepository.findByDestinationContainingIgnoreCase(destination);
    }

    @Override
    public List<Package> searchByMaxPrice(BigDecimal maxPrice) {
        return packageRepository.findByPriceLessThanEqual(maxPrice);
    }

    @Override
    public List<Package> searchByMinPrice(BigDecimal minPrice) {
        return packageRepository.findByPriceGreaterThanEqual(minPrice);
    }

    @Override
    public List<Package> searchByDepartureDate(LocalDate date) {
        return packageRepository.findByDepartureDate(date);
    }

    @Override
    public List<Package> searchByDepartureAfter(LocalDate date) {
        return packageRepository.findByDepartureDateAfter(date);
    }

    @Override
    public List<Package> searchByDestinationAndMaxPrice(String destination, BigDecimal maxPrice) {
        return packageRepository.findByDestinationContainingIgnoreCaseAndPriceLessThanEqual(destination, maxPrice);
    }

    // ---------------- BUSINESS ACTIONS ----------------

    @Override
    @Transactional
    public Package updatePrice(Long packageId, BigDecimal newPrice, String reason) {
        Package travelPackage = getPackageById(packageId);

        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("New price must be > 0");
        }

        BigDecimal oldPrice = travelPackage.getPrice();
        if (oldPrice != null && oldPrice.compareTo(newPrice) == 0) {
            return travelPackage; // no cambia nada
        }

        travelPackage.setPrice(newPrice);
        Package saved = packageRepository.save(travelPackage);

        // Save history (provider optional in manual updates)
        PackagePriceHistory entry = new PackagePriceHistory(travelPackage, null, oldPrice, newPrice, reason);
        priceHistoryRepository.save(entry);

        return saved;
    }

    // ---------------- VALIDATION ----------------

    private void validatePackage(Package p) {
        if (p.getTitle() == null || p.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (p.getDestination() == null || p.getDestination().isBlank()) {
            throw new IllegalArgumentException("Destination is required");
        }
        if (p.getPrice() == null || p.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        if (p.getCurrency() == null || p.getCurrency().length() != 3) {
            throw new IllegalArgumentException("Currency must be 3 letters (e.g., EUR)");
        }
        if (p.getDepartureDate() == null) {
            throw new IllegalArgumentException("Departure date is required");
        }
        // Regla típica: no permitir paquetes con salida en el pasado
        if (p.getDepartureDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Departure date cannot be in the past");
        }
        if (p.getNights() <= 0) {
            throw new IllegalArgumentException("Nights must be > 0");
        }
        if (p.getDeparture() == null || p.getDeparture().isBlank()) {
            throw new IllegalArgumentException("Departure (airport/city) is required");
        }
        if (p.getAirline() == null || p.getAirline().isBlank()) {
            throw new IllegalArgumentException("Airline is required");
        }
        if (p.getDescription() == null || p.getDescription().isBlank()) {
            throw new IllegalArgumentException("Description is required");
        }
        if (p.getIncludes() == null || p.getIncludes().isBlank()) {
            throw new IllegalArgumentException("Includes is required");
        }
        if (p.getImage() == null || p.getImage().isBlank()) {
            throw new IllegalArgumentException("Image is required");
        }
    }
}
