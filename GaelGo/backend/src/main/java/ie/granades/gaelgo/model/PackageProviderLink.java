package ie.granades.gaelgo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "package_provider_links",
uniqueConstraints = @UniqueConstraint(columnNames = {"package_id", "provider_id"}))
@Setter
@Getter
@NoArgsConstructor
public class PackageProviderLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long packageProviderLinkId;

    //One package to many price history
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    @JsonIgnore // Avoid infinite loop //Remplace later for DTO
    private Package travelPackage;

    //One provider to many
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnore // Avoid infinite loop //Remplace later for DTO
    private Provider provider;


    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private LocalDateTime lastChecked = LocalDateTime.now();
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    public PackageProviderLink(Package travelPackage, Provider provider, String url, BigDecimal price)
    {
        this.travelPackage = travelPackage;
        this.provider = provider;
        this.url = url;
        this.price = price;
    }

}
