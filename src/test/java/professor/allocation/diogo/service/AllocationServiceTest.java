package professor.allocation.diogo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.diogo.entity.Allocation;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	
	@Autowired
	AllocationService allocationService;
	
	@Test
	public void findAll() {
		
		List<Allocation> allocations = allocationService.findAll();
		
		allocations.forEach(System.out::println);
		
	}
	
	@Test
	public void findByProfessor() {
		Long id = 1L;
		
		List<Allocation> allocations = allocationService.findByProfessor(id);
		
		allocations.forEach(System.out::println);
	}
	
	@Test
	public void findByCourse() {
		Long id = 1L;
		
		List<Allocation> allocations = allocationService.findByCourse(id);
		
		allocations.forEach(System.out::println);
	}
	
	@Test
	public void findById() {
		Long id = 1L;
		
		Allocation allocation = allocationService.findById(id);
		
		System.out.println(allocation);
	}
	
	@Test
	public void save() throws ParseException{
		
		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDayOfWeek(DayOfWeek.WEDNESDAY);
		allocation.setStartHour(sdf.parse("19:00-0300"));
		allocation.setEndHour(sdf.parse("20:00-0300"));
		allocation.setProfessorId(2L);
		allocation.setCourseId(1L);
		
		allocation = allocationService.save(allocation);
		
		System.out.println(allocation);
	}
	
	@Test
	public void update() throws ParseException{
		Allocation allocation = new Allocation();
		allocation.setId(1L);
		allocation.setDayOfWeek(DayOfWeek.MONDAY);
		allocation.setStartHour(sdf.parse("19:00-0300"));
		allocation.setEndHour(sdf.parse("20:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);
		
		allocation = allocationService.update(allocation);
		
		System.out.println(allocation);
		
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		
		allocationService.deleteById(id);
	}
	
	@Test
	public void deleteAll() {
		allocationService.deleteAll();
	}
	
	
}
