package com.backend.api.source;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/source")
public class SourceController {

    @GetMapping
    public RedirectView source() {
        return new RedirectView("https://github.com/luizpenz/back-front");
    }
}
