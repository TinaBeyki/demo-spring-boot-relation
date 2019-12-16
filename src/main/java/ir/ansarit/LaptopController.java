package ir.ansarit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("ir.ansarit")
public class LaptopController {

    @Autowired
    private LaptopRepo repo;

    @PostMapping("laptop")
    public Laptop create(Laptop laptop){
        return repo.save(laptop);
    }

    @DeleteMapping("/laptop/{lid}")
    public void delete(@PathVariable("lid") int lid){
        //if(repo.findById(id).isPresent()){
        repo.delete(lid);
        //repo.deleteById(id);
        // }else
        //  return;
    }
}
