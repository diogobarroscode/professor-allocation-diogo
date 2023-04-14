package professor.allocation.diogo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import professor.allocation.diogo.entity.Allocation;
import professor.allocation.diogo.entity.Department;
import professor.allocation.diogo.entity.Professor;
import professor.allocation.diogo.repository.AllocationRepository;
import professor.allocation.diogo.repository.ProfessorRepository;



@Service
public class ProfessorService {

	private final DepartmentService departmentService;
	private final ProfessorRepository professorRepository;
	private final AllocationRepository allocationRepository;
	
	public ProfessorService(DepartmentService departmentService, ProfessorRepository professorRepository, AllocationRepository allocationRepository) {
		super();
		this.departmentService = departmentService;
		this.professorRepository = professorRepository;
		this.allocationRepository = allocationRepository;
	}
	
	public List<Professor> findAll(String name){
		if(name == null) {
			return professorRepository.findAll();
		} else {
			return professorRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
	
	public List<Professor> findByDepartment(Long departmentId){
		return professorRepository.findByDepartmentId(departmentId);
	}
	
	public Professor save(Professor professor) {
		professor.setId(null);
		return saveInternal(professor);
	}
	
	public Professor update(Professor professor) {
		Long id = professor.getId();
		
		if(id != null && professorRepository.existsById(id)) {
			return saveInternal(professor);
		} else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		if(id != null && professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}
	}
	
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}
	
	
	private Professor saveInternal(Professor professor) {
		professor = professorRepository.save(professor);
		
		Department department = departmentService.findById(professor.getDepartmentId());
		professor.setDepartment(department);
		
		List<Allocation> allocations = allocationRepository.findByProfessorId(professor.getId());
		professor.setAllocations(allocations);
		
		return professor;
	}
	
}
