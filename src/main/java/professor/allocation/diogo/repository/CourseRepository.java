package professor.allocation.diogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import professor.allocation.diogo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	List<Course> findByNameContainingIgnoreCase(String name);
}
