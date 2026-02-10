package ie.granades.gaelgo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "packages")
@Getter
@Setter
@NoArgsConstructor

public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(length = 3, nullable = false)
    private String currency;

    @Column(nullable = false)
    private LocalDate departureDate;

    @Column(nullable = false)
    private int nights;

    @Column(nullable = false)
    private String departure;

    @Column(nullable = false)
    private String airline;

    @Column(nullable = true)
    private String hotel;

    @Column(nullable = false)
    private String description;

    @Lob //+255 characteres for JSON later
    @Column(nullable = false)
    private String includes;

    @Column(nullable = false)
    private String image;

    //subscriber one to many
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscriber> subscribers = new ArrayList<>();
    //PackageProviderLink
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PackageProviderLink> providerLinks = new ArrayList<>();
    //PackagePriceHistory
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PackagePriceHistory> priceHistory = new ArrayList<>();


    public Package(
            String title,
            String destination,
            BigDecimal price,
            String currency,
            LocalDate departureDate,
            int nights,
            String departure,
            String airline,
            String hotel,
            String description,
            String includes,
            String image) {

        this.title = title;
        this.destination = destination;
        this.price = price;
        this.currency = currency;
        this.departureDate = departureDate;
        this.nights = nights;
        this.departure = departure;
        this.airline = airline;
        this.hotel = hotel;
        this.description = description;
        this.includes = includes;
        this.image = image;
    }

}