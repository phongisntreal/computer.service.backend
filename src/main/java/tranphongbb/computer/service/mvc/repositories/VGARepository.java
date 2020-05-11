package tranphongbb.computer.service.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tranphongbb.computer.service.mvc.entity.pc.VGA;

import java.util.List;

public interface VGARepository extends JpaRepository<VGA, Integer> {

    @Query(" FROM VGA t1 where t1.name like %:name%")
    List<VGA> findByName(@Param("name") String name);
}
