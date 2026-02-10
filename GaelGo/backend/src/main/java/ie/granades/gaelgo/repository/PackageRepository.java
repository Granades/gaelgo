package ie.granades.gaelgo.repository;

import ie.granades.gaelgo.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PackageRepository extends JpaRepository <Package, Long>{

    List<Package> findByDestinationContainingIgnoreCase(String destination);

    List<Package> findByPriceLessThanEqual(BigDecimal price);

    List<Package> findByDepartureDate(LocalDate date);

    List<Package> findByDepartureDateAfter(LocalDate date);

    List<Package> findByDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            String destination, BigDecimal price);


}
