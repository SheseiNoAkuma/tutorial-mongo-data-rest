package eu.microbo.mongorest.liquid;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@DisplayName("Test of liquid repository with embedded mongodb")
class LiquidRepositoryTest {

    @Autowired
    private LiquidRepository sut;

    @Test
    @DisplayName("Test che ho trovato online")
    public void test(@Autowired MongoTemplate mongoTemplate) {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key", "value")
                .get();

        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key")
                .containsOnly("value");
    }

    @Test
    @DisplayName("Test con il vero repository")
    public void testTwo(@Autowired MongoTemplate mongoTemplate) {
        // given
        Liquid actual = Liquid.builder()
                .description("some description")
                .name("name")
                .build();
        mongoTemplate.save(actual);

        // when
        Collection<Liquid> names = sut.findByName("name");

        // then
        assertThat(names).extracting("name")
                .containsOnly("name");
    }
}
