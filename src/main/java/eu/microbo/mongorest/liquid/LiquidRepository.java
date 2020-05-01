package eu.microbo.mongorest.liquid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "liquid", path = "liquid")
public interface LiquidRepository extends MongoRepository<Liquid, String> {

    List<Liquid> findByName(String name);

}
