package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@NamedQueries(
        value = {
                @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
        }
)
public class Student {
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true)
    private String email;


}
