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
	
	
}
