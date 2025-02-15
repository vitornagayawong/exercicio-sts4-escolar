package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		this.professorRepository.save(professor);
		return "Aluno cadastrado com sucesso!";
	}
	public Optional<Professor> findById(long id) {
		Optional<Professor> professor = this.professorRepository.findById(id);
		return professor;
	}
	public String delete(long id) {
		this.professorRepository.deleteById(id);
		return "Professor deletado com sucesso!";
	}
	public String update(Professor professor) {
		this.professorRepository.save(professor);
		return "Professor atualizado com sucesso!";
	}
	public List<Professor> findAll() {
		return this.professorRepository.findAll();
	}		
}
