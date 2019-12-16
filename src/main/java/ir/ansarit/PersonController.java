package ir.ansarit;

import ir.ansarit.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@EnableJpaRepositories
@ComponentScan("ir.ansarit")
public class PersonController {

    @Autowired
    private PersonRepo repo;

    @PostMapping("/person")
    public ResponseEntity create(@RequestBody Person person) throws ValidationException {
            return new ResponseEntity(repo.save(person), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity exceptionHandling(ValidationException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

  /*  @PutMapping("/person")
    public ResponseEntity update(@RequestBody Person person){
        if(repo.findById(person.getId()).isPresent()){
            return new ResponseEntity(repo.save(person), HttpStatus.OK);
        }else {
            return new ResponseEntity("person not found", HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping("/person")
    public Iterable read(){
        return repo.find();
    }

    @GetMapping("/person2")
    public Iterable read2(){
        return repo.findAll();
    }

    @GetMapping("/person1/{id}")
    public Person findPerson(@PathVariable int id){
        return repo.findById1(id);
    }

    @GetMapping("/person2/{id}")
    public Person findByPerson2(@PathVariable int id){
        return repo.findById(id);
    }


    @PutMapping("update")
    public void update2(@RequestBody Person person){
         //repo.update(person.getName());
        repo.save(person);
    }

    @GetMapping("/search")
    public Iterable search(@RequestBody Person person){
        if(person.getName().equals(null)){
            return repo.findBySurname(person.getSurname());
        }else if(person.getSurname().equals(null)){
            return repo.findByName(person.getName());
        }else if(person.getName().equals(null) && person.getSurname().equals(null)){
            return repo.findAll();
        }else {
            return repo.findByNameAndSurname(person.getName(), person.getSurname());
        }
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable int id){
        //if(repo.findById(id).isPresent()){
            repo.delete(id);
            //repo.deleteById(id);
       // }else
          //  return;
    }

}
