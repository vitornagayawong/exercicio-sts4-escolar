package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	public List<Professor> findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade);
	
	List<Professor> findByEmailNotLike(String email);
	
	List<Professor> findByEmail(String email);
	
	//select from professor where nome like "%?" or especialidade like "%?"
	
	//select from professor where email not like "?"
	
	//select from professor where email = ?
}
