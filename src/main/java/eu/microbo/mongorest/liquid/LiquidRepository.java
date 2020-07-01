package eu.microbo.mongorest.liquid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "liquid", path = "liquid")
public interface LiquidRepository extends MongoRepository<Liquid, String> {

    Collection<Liquid> findByName(String name);

}
