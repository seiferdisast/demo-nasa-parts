package co.seifer.nasaparts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarElemento(@PathVariable Long id) {
        // Código para eliminar el elemento con el id especificado
        partRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putResource(@RequestBody Part part, @PathVariable("id") Long id) {
            partRepository.save(part);
            return ResponseEntity.ok("resource saved");
        }
    /*
     * public String name() {
     * return "eliminado";
     * }
     */

}
