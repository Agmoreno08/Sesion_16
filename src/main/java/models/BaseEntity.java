package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid" , strategy = "uuid")
    @Id
    private String id;

}
