package ie.granades.gaelgo.repository;

import ie.granades.gaelgo.model.PackagePriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackagePriceHistoryRepository extends JpaRepository<PackagePriceHistory, Long> {
    List<PackagePriceHistory> findByTravelPackage_PackageId(Long packageId);

    List<PackagePriceHistory> findByProvider_ProviderId(Long providerId);
}
