package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.dto.TrackingResponse;
import ma.youcode.clicktrack.service.LienService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/t")
public class TrackingController extends BaseController {
    private final LienService lienService;

    public TrackingController(LienService lienService) {
        this.lienService = lienService;
    }
    @GetMapping("/{id}")
    @ResponseBody
    public TrackingResponse track(@PathVariable("id") long id) {
        return lienService.track(id);
    }
}