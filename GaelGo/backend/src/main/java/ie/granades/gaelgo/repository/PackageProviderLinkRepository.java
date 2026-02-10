package ie.granades.gaelgo.repository;

import ie.granades.gaelgo.model.PackageProviderLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageProviderLinkRepository extends JpaRepository<PackageProviderLink, Long> {

    List<PackageProviderLink> findByTravelPackage_PackageId(Long packageId);
    List<PackageProviderLink> findByProvider_ProviderId(Long providerId);
}
