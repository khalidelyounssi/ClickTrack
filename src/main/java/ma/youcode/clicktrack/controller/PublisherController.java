package ma.youcode.clicktrack.controller;

import java.util.List;
import ma.youcode.clicktrack.dto.*;
import ma.youcode.clicktrack.model.*;
import ma.youcode.clicktrack.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/publishers")
public class PublisherController extends BaseController {
    private final PublisherService publisherService;
    private final LienService lienService;

    public PublisherController(PublisherService publisherService,
                               LienService lienService) {
        this.publisherService = publisherService;
        this.lienService = lienService;
    }
    @GetMapping
    @ResponseBody
    public List<Publisher> publishers() {
        return publisherService.findAll();
    }
    @PostMapping(value = "/{id}/liens", consumes = "application/json")
    public ResponseEntity<Lien> create(@PathVariable("id") long id, @RequestBody CreateLienRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lienService.create(id, request));
    }
     @GetMapping("/{id}/liens")
        @ResponseBody
        public List<Lien> liens(@PathVariable("id") long id) {
            return lienService.findByPublisherId(id);
        }
            @GetMapping("/{id}/offres")
        @ResponseBody
        public List<OffreResponse> offres(
                @PathVariable("id") long id
        ) {
            return lienService.findOffres(id);
        }
}