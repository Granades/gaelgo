package ie.granades.gaelgo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriberRequest {
    private String email;
    private Long packageId;

    public SubscriberRequest() {}

    public SubscriberRequest(String email, Long packageId) {
        this.email = email;
        this.packageId = packageId;
    }

}