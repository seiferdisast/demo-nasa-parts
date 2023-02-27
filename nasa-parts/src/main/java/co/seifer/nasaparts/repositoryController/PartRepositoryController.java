package co.seifer.nasaparts.repositoryController;

import co.seifer.nasaparts.model.Part;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GET /part-repository-controller - Recupera todos las partes
 * GET /part-repository-controller/{id} - Recupera una parte por su ID
 * POST /part-repository-controller - Crea una nueva parte
 * PUT /part-repository-controller/{id} - Actualiza una aprte existente
 * DELETE /part-repository-controller/{id} - Elimina una parte existente
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "parts", path = "part-repository-controller")
public interface PartRepositoryController extends CrudRepository<Part,Long> {
    List<Part> findByName(@Param("name") String name);
}