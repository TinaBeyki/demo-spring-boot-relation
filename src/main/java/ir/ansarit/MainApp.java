package ir.ansarit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    //insert into ps (name, surname, id) values (?, ?, ?)
   /*
   Hibernate: select person0_.id as id1_0_, person0_.name as name2_0_, person0_.surname as surname3_0_ from ps person0_
   Hibernate: select person0_.id as id1_0_, person0_.name as name2_0_, person0_.surname as surname3_0_ from ps person0_

     Hibernate: delete from person where id=?

    */
}
