package ie.granades.gaelgo.controller;

import ie.granades.gaelgo.model.Package;
import ie.granades.gaelgo.dto.PackageRequest;
import ie.granades.gaelgo.model.PackageProviderLink;
import ie.granades.gaelgo.service.PackageService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/package")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService)
    {
        this.packageService = packageService;
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Package create(@Valid @RequestBody PackageRequest request)
    {

        Package p = new Package(
                request.getTitle(),
                request.getDestination(),
                request.getPrice(),
                request.getCurrency(),
                request.getDepartureDate(),
                request.getNights(),
                request.getDeparture(),
                request.getAirline(),
                request.getHotel(),
                request.getDescription(),
                request.getIncludes(),
                request.getImage()
                );

        return packageService.create(p);
    }
    //Delete
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long packageId)
    {
        packageService.delete(packageId);
    }
    //Read by package
    //*
    // @GetMapping -> List<Package>
    // @GetMapping("/{id}") -> get by id
    // @PutMapping("/{id}") -> update
    // *//

    //Get all packages
    @GetMapping
    public List<Package> getAllPackages()
    {
        return packageService.getAllPackages();
    }
    //Get by id
    @GetMapping("/{id}")
    Package getPackageById(@PathVariable Long id)
    {
        return packageService.getPackageById(id);
    }
    //Update
    @PutMapping("/{id}")
    public Package update(@PathVariable Long id, @RequestBody PackageRequest request)
    {
        Package p = new Package(
                request.getTitle(),
                request.getDestination(),
                request.getPrice(),
                request.getCurrency(),
                request.getDepartureDate(),
                request.getNights(),
                request.getDeparture(),
                request.getAirline(),
                request.getHotel(),
                request.getDescription(),
                request.getIncludes(),
                request.getImage()
        );

        return packageService.update(id, p);
    }

    /// END OF CRUD
    /// lINK
    @GetMapping("/{id}/provider")
    public List<PackageProviderLink> getProviderLinks(@PathVariable Long id)
    {
        return packageService.getProviderLinks(id);
    }
    ///Search ---
    ///

    @GetMapping("/search")
    public List<Package> search (
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required=false) LocalDate departureAfter
    )
    {

        if (destination != null && maxPrice != null) {
            return packageService.searchByDestinationAndMaxPrice(destination, maxPrice);
        }
        if (destination != null) {
            return packageService.searchByDestination(destination);
        }
        if (maxPrice != null) {return packageService.searchByMaxPrice(maxPrice);
        }
        if (minPrice != null) {
            return packageService.searchByMinPrice(minPrice);
        }
        if (date != null) {
            return packageService.searchByDepartureDate(date);
        }
        if (departureAfter != null)
        {
            return packageService.searchByDepartureAfter(departureAfter);
        }
        return packageService.getAllPackages();
    }

    //Update Price
    @PatchMapping("/{id}/price")
    public Package updatePrice(@PathVariable Long id, @RequestParam BigDecimal newPrice, @RequestParam(required = false) String reason)
    {
        return packageService.updatePrice(id, newPrice, reason);
    }





}