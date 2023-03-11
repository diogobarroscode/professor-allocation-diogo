package professor.allocation.diogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import professor.allocation.diogo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
