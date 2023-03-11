package professor.allocation.diogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import professor.allocation.diogo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	List<Department> findByNameContainingIgnoreCase(String name);
}
