package ma.xproce.inventoryservice.dao.repositories;

import ma.xproce.inventoryservice.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatorRepository extends JpaRepository<Creator,Long> {
    Creator findByName(String name);
    List<Creator> findAll();
    public void deleteCreatorByName(String name);
    public Creator saveCreator(Creator creator);
}
