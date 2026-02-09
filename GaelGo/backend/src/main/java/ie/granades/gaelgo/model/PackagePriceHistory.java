package ie.granades.gaelgo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "package_price_history")
@Setter
@Getter
@NoArgsConstructor
public class PackagePriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packagePriceHistoryId;

    //Many ProviderLink price to one package
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "packageId", nullable = false)
    @JsonIgnore // Avoid infinite loop //Remplace later for DTO
    private Package travelPackage;

    //Many Package price history to one provider
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "providerId", nullable = false)
    @JsonIgnore // Avoid infinite loop //Remplace later for DTO
    private Provider provider;


    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private LocalDateTime timeStamp = LocalDateTime.now();


    public PackagePriceHistory(Package travelPackage, Provider provider, BigDecimal price)
    {
        this.travelPackage = travelPackage;
        this.provider = provider;
        this.price = price;
    }

}
