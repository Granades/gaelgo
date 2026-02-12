package ie.granades.gaelgo.service;

import ie.granades.gaelgo.model.Package;
import ie.granades.gaelgo.model.Subscriber;
import ie.granades.gaelgo.repository.PackageRepository;
import ie.granades.gaelgo.repository.SubscriberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService{

    private final SubscriberRepository subscriberRepository;
    private  final PackageRepository packageRepository;


    public SubscriberServiceImpl(SubscriberRepository subscriberRepository, PackageRepository packageRepository) {
        this.subscriberRepository = subscriberRepository;
        this.packageRepository = packageRepository;
    }


    @Override
    @Transactional
    public Subscriber subscribe(String email, Long packageId)
    {
        if(email == null || email.isBlank())
        {
            throw new IllegalArgumentException("Email is required");
        }
        if(packageId == null || packageId <= 0)
        {
            throw new IllegalArgumentException("Package is required");
        }
        String normalizedEmail = email.trim().toLowerCase();
        Package travelPackage = packageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found " + packageId));

        return subscriberRepository
                .findByEmailAndTravelPackage_PackageId(normalizedEmail, packageId)
                .orElseGet(() -> {
                    Subscriber s = new Subscriber();
                    s.setEmail(normalizedEmail);
                    s.setTravelPackage(travelPackage);
                    s.setActive(true);
                    return subscriberRepository.save(s);
                });
    }

    @Override
    @Transactional
    public void unsubscribe(String email, Long packageId)
    {
        if(email == null || email.isBlank())
        {
            throw new IllegalArgumentException("Email is required");
        }
        if(packageId == null || packageId <= 0)
        {
            throw new IllegalArgumentException("Package is required");
        }
        String normalizedEmail = email.trim().toLowerCase();
        Subscriber s = subscriberRepository
                .findByEmailAndTravelPackage_PackageId(normalizedEmail, packageId)
                .orElseThrow(() -> new RuntimeException("Subscriber not found " + packageId));

        s.setActive(false);
        subscriberRepository.save(s);
    }

    @Override
    public List<Subscriber> getSubscribersByPackage(Long packageId)
    {
        if(packageId == null || packageId <= 0)
        {
            throw new IllegalArgumentException("PackageId is required");
        }
        return subscriberRepository.findByTravelPackage_PackageId(packageId);
    }

    //Admin
    @Override
    @Transactional
    public Subscriber setActive(Long subscriberId, boolean active)
    {
        if(subscriberId == null || subscriberId <= 0)
        {
            throw new IllegalArgumentException("SubscriberId is wrong");
        }
        Subscriber s = subscriberRepository.findById(subscriberId)
                .orElseThrow(() -> new RuntimeException("Subscriber not found : " + subscriberId));
        s.setActive(active);

        return subscriberRepository.save(s);
    }

}