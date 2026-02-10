package ie.granades.gaelgo.repository;

import ie.granades.gaelgo.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Optional<Provider> findByNameIgnoreCase(String name);

}
