package ie.granades.gaelgo.controller;
import ie.granades.gaelgo.dto.SubscriberRequest;
import ie.granades.gaelgo.model.Subscriber;
import ie.granades.gaelgo.service.SubscriberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscribers")
public class SubscriberController
{

    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService)
    {
        this.subscriberService = subscriberService;
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subscriber create(@RequestBody SubscriberRequest request)
    {
        return subscriberService.subscribe(
                request.getEmail(),
                request.getPackageId()
        );
    }

    //Delete
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unsubscribe(@RequestParam String email,
                            @RequestParam Long packageId) {
        subscriberService.unsubscribe(email, packageId);
    }
    //Read byPackage
    @GetMapping("/package/{packageId}")
    public List<Subscriber> getByPackage(@PathVariable Long packageId) {
        return subscriberService.getSubscribersByPackage(packageId);
    }

}