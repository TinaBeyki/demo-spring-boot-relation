package ir.ansarit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;
import java.lang.annotation.Native;
import java.util.List;


@Transactional
public interface PersonRepo extends JpaRepository<Person, Integer> {

    @Query("select c from Person c")
    public Iterable<Person> find();

    /*@Modifying
    @Query("UPDATE Person c SET c.name = ?1 WHERE c.id = 1")
    public void update(String name);
*/
    @Modifying
    @Query("delete  from Person c where c.id = ?1")
    public void delete(int id);

    @Query("select c from Person c where c.id = ?1")
    public Person findById1(int id);

    public Person findById(int id);

    public void deleteById(int id);


    Iterable<Person> findByName(String name);
    Iterable<Person> findBySurname(String surname);
    Iterable<Person> findByNameAndSurname(String name, String surname);

}
