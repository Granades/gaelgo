package ie.granades.gaelgo.service;

import ie.granades.gaelgo.model.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberService {

    Subscriber subscribe(String email, Long packageId);
    void unsubscribe(String email, Long packageId);
    List<Subscriber> getSubscribersByPackage(Long packageId);



    //Admin
    Subscriber setActive(Long subscriberId, boolean active);
}