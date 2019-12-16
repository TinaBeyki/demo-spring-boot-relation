package ir.ansarit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

    @Modifying
    @Query("delete  from Laptop c where c.lid = ?1")
    public void delete(int lid);
}
