package professor.allocation.diogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import professor.allocation.diogo.entity.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {

}
