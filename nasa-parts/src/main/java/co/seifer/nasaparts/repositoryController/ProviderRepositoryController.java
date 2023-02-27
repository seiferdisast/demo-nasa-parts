package co.seifer.nasaparts.repositoryController;

import co.seifer.nasaparts.model.Part;
import co.seifer.nasaparts.model.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * GET /provider-repository-controller - Recupera todos las provider
 * GET /provider-repository-controller/{id} - Recupera una parte por su ID
 * POST /provider-repository-controller - Crea una nueva provider
 * PUT /provider-repository-controller/{id} - Actualiza una provider existente
 * DELETE /provider-repository-controller/{id} - Elimina una provider existente
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "providers", path = "provider-repository-controller")
public interface ProviderRepositoryController extends CrudRepository<Provider, Long> {
}