package professor.allocation.diogo.repository;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.diogo.entity.Allocation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	
	@Autowired
	AllocationRepository allocationRepository;
	
	@Test
	public void findAll() {
		
		List<Allocation> allocations = allocationRepository.findAll();
		
		allocations.forEach(System.out::println);
	}
	
	@Test
	public void findById() {
		
		Long id = 1L;
		
		Allocation allocation = allocationRepository.findById(id).orElse(null);
		
		System.out.println(allocation);
	}
	
	@Test
	public void findByProfessorId() {
		
		Long professorId = 1L;
		
		List<Allocation> allocations = allocationRepository.findByProfessorId(professorId);
		
		allocations.forEach(System.out::println);
	}
	
	@Test
	public void findByCourseId() {
		
		Long courseId = 1L;
		
		List<Allocation> allocations = allocationRepository.findByCourseId(courseId);
		
		allocations.forEach(System.out::println);
	}

}


















