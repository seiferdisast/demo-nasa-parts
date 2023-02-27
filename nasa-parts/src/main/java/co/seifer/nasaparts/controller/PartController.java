package co.seifer.nasaparts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
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
//        implementación simple
        part.setId(id);
        partRepository.save(part);
        return ResponseEntity.ok(part);
    }

    @PutMapping("/{id}/completa")
    public ResponseEntity<?> putCompleta(@RequestBody Part part, @PathVariable("id") Long id) {
    //  implementación más compleja que nos lleva al mismo lugar

        Optional<Part> optionalPartFromDB = partRepository.findById(id);
        System.out.println(optionalPartFromDB);

        if(!optionalPartFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Part partFromDB = optionalPartFromDB.get();
        part.setId(id);
        partFromDB.setName(part.getName());
        partFromDB.setCuantity(part.getCuantity());
        partFromDB.setProvider(part.getProvider());
        partFromDB.setLast_date_updated(part.getLast_date_updated());

        final Part updatedUser = partRepository.save(partFromDB);
        partRepository.save(partFromDB);
        return ResponseEntity.ok(updatedUser);

    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> patchResource(@RequestBody Part part, @PathVariable("id") Long id) {

        Optional<Part> optionalPartFromDB = partRepository.findById(id);

        if(!optionalPartFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Part partFromDB = optionalPartFromDB.get();
        if(part.getName() != null){
            partFromDB.setName(part.getName());
        }
        if(part.getCuantity() != null){
            partFromDB.setCuantity(part.getCuantity());
        }
        if(part.getProvider() != null){
            partFromDB.setProvider(part.getProvider());
        }

        if(part.getLast_date_updated() != null){
            partFromDB.setLast_date_updated(part.getLast_date_updated());
        }

        final Part updatedUser = partRepository.save(partFromDB);
        return ResponseEntity.ok(updatedUser);
    }
    /*
     * public String name() {
     * return "eliminado";
     * }
     */

}
