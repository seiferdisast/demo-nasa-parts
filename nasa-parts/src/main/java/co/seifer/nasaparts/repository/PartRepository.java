package co.seifer.nasaparts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.seifer.nasaparts.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
