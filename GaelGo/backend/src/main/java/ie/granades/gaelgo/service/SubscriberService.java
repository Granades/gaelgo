package ie.granades.gaelgo.service;

import ie.granades.gaelgo.model.Subscriber;

import java.util.List;

public interface SubscriberService {

    Subscriber subscribe(String email, Long packageId);
    void unsubscribe(String email, Long packageId);
    List<Subscriber> getSubscribersByPackage(Long packageId);

    Optional<Subscriber> findByEmailAndTravelPackage_PackageId(String email, Long packageId);

    //Admin
    Subscriber setActive(Long subscriberId, boolean active);
}