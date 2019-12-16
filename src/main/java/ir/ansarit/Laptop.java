package ir.ansarit;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Laptop {

    @Id
    //@SequenceGenerator(name = "ls", sequenceName = "LAPTOP_SEQ", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "ls")
    private int lid;
    private String lname;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;


    public void setLid(int lid){
        this.lid = lid;
    }

    public int getLid(){
        return lid;
    }

    public void setLname(String lname){
        this.lname = lname;
    }

    public String getLname(){
        return lname;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public Person getPerson(){
        return person;
    }

}
