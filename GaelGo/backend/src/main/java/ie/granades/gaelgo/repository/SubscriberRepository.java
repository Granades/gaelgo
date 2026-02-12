package ie.granades.gaelgo.repository;

import ie.granades.gaelgo.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    Optional<Subscriber> findByEmail(String email);

    List<Subscriber> findByTravelPackage_PackageId(Long packageId);

    boolean existsByEmailAndTravelPackage_PackageId(String email, Long packageId);

}
