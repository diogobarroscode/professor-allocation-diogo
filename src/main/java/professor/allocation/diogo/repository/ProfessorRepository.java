package professor.allocation.diogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import professor.allocation.diogo.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
