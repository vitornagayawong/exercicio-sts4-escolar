package app.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		
		//System.out.println(professor.getEmail());
		//Não permitir a INSERÇÃO de um professor com email que contenha “@outlook.com”. Caso aconteça a tentativa, lançar throw new RuntimeException(“Domínio de e-mail não permitido”).
		if (professor.getEmail().toLowerCase().contains("@outlook.com")) {
	        throw new RuntimeException("Domínio de e-mail não permitido!");
	    }
		
		//Não permitir a INSERÇÃO de um professor com email já cadastrado. Caso aconteça, lançar throw new RuntimeException("Email já cadastrado!"). 
		List<Professor> professores = this.professorRepository.findByEmail(professor.getEmail());		
		
		
		if (!professores.isEmpty()) {
	        throw new RuntimeException("Email já cadastrado!");
	    }
		
		this.professorRepository.save(professor);
		return "Professor cadastrado com sucesso!";
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
	
	public List<Professor> findByNomeOrEspecialidade(String nome, String especialidade) {
        return this.professorRepository.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
    }
	
	public List<Professor> findProfessoresSemGmail() {
        return this.professorRepository.findByEmailNotLike("%@gmail.com");
    }
	
	public List<Professor> findByEmail(String email) {
        return this.professorRepository.findByEmail(email);
    }
}
