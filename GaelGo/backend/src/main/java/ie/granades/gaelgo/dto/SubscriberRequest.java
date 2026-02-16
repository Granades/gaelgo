package ie.granades.gaelgo.dto;


public class SubscriberRequest {
    private String email;
    private Long packageId;

    public SubscriberRequest() {}

    public SubscriberRequest(String email, Long packageId) {
        this.email = email;
        this.packageId = packageId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getPackageId() {
        return packageId;
    }
    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }
}