package professor.allocation.diogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import professor.allocation.diogo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	List<Department> findByNameContainingIgnoreCase(String name);
}
