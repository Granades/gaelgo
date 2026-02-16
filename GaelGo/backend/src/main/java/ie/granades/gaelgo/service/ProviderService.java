package ie.granades.gaelgo.service;

import ie.granades.gaelgo.model.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getAllProviders();
    Provider getProviderById(Long id);
    Provider create(Provider provider);
    Provider update(Long id, Provider updated);
    void delete(Long id);
}
