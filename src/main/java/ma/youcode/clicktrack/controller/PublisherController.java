package ma.youcode.clicktrack.controller;

import java.util.List;
import ma.youcode.clicktrack.model.Publisher;
import ma.youcode.clicktrack.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/publishers")
public class PublisherController extends BaseController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    @GetMapping
    @ResponseBody
    public List<Publisher> publishers() {
        return publisherService.findAll();
    }
}