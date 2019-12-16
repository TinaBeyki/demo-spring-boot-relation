package ir.ansarit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Person implements Serializable {

    @Id
    //@SequenceGenerator(name = "ps", sequenceName = "PERSON_SEQ", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "ps")
    private int id;
    private String name;
    private String surname;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "person", fetch = FetchType.EAGER)
    private List<Laptop> laptops;

   @OneToOne(optional = true, cascade = CascadeType.ALL)
   private Address address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
