package professor.allocation.diogo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.diogo.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.preperties")
public class CourseRepositoryTest {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void findAll() {
		
		List<Course> courses = courseRepository.findAll();
		
		courses.forEach(System.out::println);
	}
	
	@Test
	public void findById() {
		
		Long id = 1L;
		
		Course course = courseRepository.findById(id).orElse(null);
		
		System.out.println(course);
	}
	
	@Test
	public void findByNameContainingIgnoreCase() {
		
		String name = "Course";
		
		List<Course> courses = courseRepository.findByNameContainingIgnoreCase(name);
		
		courses.forEach(System.out::println);
	}
	
}


















