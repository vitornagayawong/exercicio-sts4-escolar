package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	public String save(Curso curso) {
		this.cursoRepository.save(curso);
		return "Curso cadastrado com sucesso!";
	}
	public Optional<Curso> findById(long id) {
		Optional<Curso> aluno = this.cursoRepository.findById(id);
		return aluno;
	}
	public String delete(long id) {
		this.cursoRepository.deleteById(id);
		return "Curso deletado com sucesso!";
	}
	public String update(Curso curso) {
		this.cursoRepository.save(curso);
		return "Curso atualizado com sucesso!";
	}
	public List<Curso> findAll() {
		return this.cursoRepository.findAll();
	}		
	
	public List<Curso> findByNomeIgnoreCase(String nome) {
        return this.cursoRepository.findByNomeIgnoreCase(nome);
    }
}
