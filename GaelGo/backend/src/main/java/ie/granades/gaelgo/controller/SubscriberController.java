package ie.granades.gaelgo.controller;

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
    public void unsubscribe(@RequestBody SubscriberRequest request) {
        subscriberService.unsubscribe(
                request.getEmail(),
                request.getPackageId()
        );
    }
    //Read byPackage
    @GetMapping("/package/{packageId}")
    public List<Subscriber> getByPackage(@PathVariable Long packageId) {
        return subscriberService.getSubscribersByPackage(packageId);
    }

}