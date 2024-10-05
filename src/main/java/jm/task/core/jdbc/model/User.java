
package jm.task.core.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(
        name = "users"
)
@Entity
public class User {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "firstname"
    )
    private String name;
    @Column(
            name = "lastname"
    )
    private String lastName;
    @Column(
            name = "age"
    )
    private Byte age;

    public User() {
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return this.age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String toString() {
        return "User{id=" + this.id + ", name='" + this.name + "', lastName='" + this.lastName + "', age=" + this.age + "}";
    }
}
