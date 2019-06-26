package LITS.jpproj.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@EqualsAndHashCode(of = {"username","age","faculty","course","city"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private Integer age;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "course")
    private Integer course;

    @Column(name = "city")
    private String city;



}
