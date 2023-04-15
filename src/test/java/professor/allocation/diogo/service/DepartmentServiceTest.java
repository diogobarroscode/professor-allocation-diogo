package professor.allocation.diogo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.diogo.entity.Department;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void findAll() {
		List<Department> departments = departmentService.findAll(null);
		
		departments.forEach(System.out::println);
	}
	
	@Test
	public void findAllByName() {
		String name = "department";
		
		List<Department> departments = departmentService.findAll(name);
		
		departments.forEach(System.out::println);
	}
	
	@Test
	public void findById() {
		Long id = 1L;
		
		Department department = departmentService.findById(id);
		
		System.out.println(department);
	}
	
	@Test
	public void save() {
		Department department = new Department();
		department.setId(null);
		department.setName("Department 1");
		
		department = departmentService.save(department);
		
		System.out.println(department);
	}
	
	@Test
	public void update() {
		Department department = new Department();
		department.setId(1L);
		department.setName("Department 2");
		
		department = departmentService.update(department);
		
		System.out.println(department);
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		
		departmentService.deleteById(id);
	}
	
	@Test
	public void deleteAll() {
		departmentService.deleteAll();
	}
	
}