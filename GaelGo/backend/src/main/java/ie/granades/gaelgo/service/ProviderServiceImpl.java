package ie.granades.gaelgo.service;

import ie.granades.gaelgo.model.Provider;
import ie.granades.gaelgo.repository.ProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderById(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found: " + id));
    }

    @Override
    @Transactional
    public Provider create(Provider provider) {
        validateProvider(provider);
        return providerRepository.save(provider);
    }

    @Override
    @Transactional
    public Provider update(Long id, Provider updated) {
        Provider existing = getProviderById(id);
        existing.setName(updated.getName());
        existing.setBaseUrl(updated.getBaseUrl());
        existing.setImage(updated.getImage());
        validateProvider(existing);
        return providerRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!providerRepository.existsById(id)) {
            throw new RuntimeException("Provider not found: " + id);
        }
        providerRepository.deleteById(id);
    }

    private void validateProvider(Provider p) {
        if (p.getName() == null || p.getName().isBlank()) {
            throw new IllegalArgumentException("Provider name is required");
        }
        if (p.getBaseUrl() == null || p.getBaseUrl().isBlank()) {
            throw new IllegalArgumentException("Provider baseUrl is required");
        }
        if (p.getImage() == null || p.getImage().isBlank()) {
            throw new IllegalArgumentException("Provider image is required");
        }
    }
}
