package LITS.jpproj.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(value = "pet")
public class Pet {

    @Id
    private String id;

    private String name;

    private String owner;

    @DBRef
    private List<Pet> pets = new ArrayList<>();

}
