package ie.granades.gaelgo.service;

import ie.granades.gaelgo.model.Package;
import ie.granades.gaelgo.repository.PackageRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PackageService {

    //Link
    public List<PackageProviderLink> getProviderLinks(Long packageId);
    //CRUD
    List<Package> getAllPackages();
    Package getPackageById(Long id);
    Package create(Package travelPackage);
    Package update(Long id,Package updated);
    void delete(Long id); //JUST ADMIN

    //Search
    List<Package> searchByDestination(String destination);
    List<Package> searchByMaxPrice(BigDecimal maxPrice);
    List<Package> searchByMinPrice(BigDecimal minPrice);
    List<Package> searchByDepartureDate(LocalDate date);
    List<Package> searchByDepartureAfter(LocalDate date);
    List<Package> searchByDestinationAndMaxPrice(String destination, BigDecimal maxPrice);

    //Business Actions
    Package updatePrice(Long packageId, BigDecimal newPrice, String reason);
}
