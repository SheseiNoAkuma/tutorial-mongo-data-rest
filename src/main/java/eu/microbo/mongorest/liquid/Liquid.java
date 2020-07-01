package eu.microbo.mongorest.liquid;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Document(collection = "liquid")
public class Liquid {

    @Id
    private String id;
    @NotNull
    private String name;
    private String description;

}
