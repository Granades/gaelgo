package ie.granades.gaelgo.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter

public class PackageRequest {
    //@NotBlank //@NotNull later on and @Valid in Controller
    @NotBlank
    private String title;
    @NotBlank
    private String destination;
    @NotNull @DecimalMin("0.01")
    private BigDecimal price;
    @NotBlank @Size(min=3,  max = 3)
    private String currency;
    @NotNull
    private LocalDate departureDate;
    @Min(1)
    private int nights;
    @NotBlank
    private String departure;
    @NotBlank
    private String airline;
    private String hotel;
    private String description;
    private String includes;
    private String image;

}