package ie.granades.gaelgo.controller;

import ie.granades.gaelgo.dto.ProviderRequest;
import ie.granades.gaelgo.model.Provider;
import ie.granades.gaelgo.service.ProviderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/provider")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Provider create(@Valid @RequestBody ProviderRequest request) {
        Provider provider = new Provider(
                request.getName(),
                request.getBaseUrl(),
                request.getImage()
        );
        return providerService.create(provider);
    }

    // Read - all
    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    // Read - by id
    @GetMapping("/{id}")
    public Provider getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Provider update(@PathVariable Long id, @Valid @RequestBody ProviderRequest request) {
        Provider provider = new Provider(
                request.getName(),
                request.getBaseUrl(),
                request.getImage()
        );
        return providerService.update(id, provider);
    }

    // Delete
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long providerId) {
        providerService.delete(providerId);
    }
}
