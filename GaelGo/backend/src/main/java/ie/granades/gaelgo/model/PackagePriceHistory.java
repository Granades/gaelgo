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
    @JoinColumn(name = "package_id", nullable = false)
    @JsonIgnore // Avoid infinite loop //Remplace later for DTO
    private Package travelPackage;

    //Many Package price history to one provider (optional for manual updates)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    @JsonIgnore // Avoid infinite loop //Remplace later for DTO
    private Provider provider;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal oldPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal newPrice;

    @Column(length = 255)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    public PackagePriceHistory(Package travelPackage, Provider provider, BigDecimal oldPrice, BigDecimal newPrice, String reason)
    {
        this.travelPackage = travelPackage;
        this.provider = provider;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.reason = reason;
    }

}
