package ie.granades.gaelgo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
public class ProviderRequest {

    @NotBlank
    private String name;
    @NotBlank @URL
    private String baseUrl;
    @NotBlank
    private String image;

}
