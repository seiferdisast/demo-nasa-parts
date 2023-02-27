package co.seifer.nasaparts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.seifer.nasaparts.model.Part;
import co.seifer.nasaparts.repository.PartRepository;


@RestController
@RequestMapping("/part")
public class PartController {
    @Autowired
    private PartRepository partRepository;

    @PostMapping
    public Part createPart(@RequestBody Part part) {
        return partRepository.save(part);
    }
    @GetMapping
    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

}
