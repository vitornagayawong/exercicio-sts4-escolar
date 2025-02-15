package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		this.alunoRepository.save(aluno);
		return "Aluno cadastrado com sucesso!";
	}
	public Optional<Aluno> findById(long id) {
		Optional<Aluno> aluno = this.alunoRepository.findById(id);
		return aluno;
	}
	public String delete(long id) {
		this.alunoRepository.deleteById(id);
		return "Aluno deletado com sucesso!";
	}
	public String update(Aluno aluno) {
		this.alunoRepository.save(aluno);
		return "Aluno atualizado com sucesso!";
	}
	public List<Aluno> findAll() {
		return this.alunoRepository.findAll();
	}		
}
