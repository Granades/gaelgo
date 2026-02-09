package ie.granades.gaelgo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "subscribers")
@Setter
@Getter
@NoArgsConstructor
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long subscriberId;

    //Many to one
    @JsonIgnore // Avoid infinite loop //Remplace later for DTO
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "packageId", nullable = false) //FK
    private Package travelPackage;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private boolean active;

    //Constructor

    public Subscriber(Package travelPackage, String email, boolean active)
    {
        this.travelPackage = travelPackage;
        this.email = email;
        this.active = active;
    }

}
