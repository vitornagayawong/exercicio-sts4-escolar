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
		
		//Não permitir a INSERÇÃO de um aluno com CPF já cadastrado. Caso aconteça, lançar throw new RuntimeException("CPF já cadastrado!").
		List<Aluno> alunoExistente = alunoRepository.findByCpf(aluno.getCpf());
		
        if (alunoExistente.size() != 0) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        
        //Antes de INSERIR ou ATUALIZAR um aluno, caso o telefone esteja nulo, o atributo cadastroCompleto deve ser setado como false. Se estiver preenchido, setar como true.
       if(aluno.getTelefone() == null) {
    	   aluno.setCadastroCompleto(false);
       } else {
    	   aluno.setCadastroCompleto(true);    	   
       }
		
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
	
	public List<Aluno> findByNomeStartingWith(String nome) {
		return this.alunoRepository.findByNomeStartingWith(nome);
	}
	
	public List<Aluno> findByTelefoneContaining(String telefone) {
	    return this.alunoRepository.findByTelefoneContaining(telefone);
	}
	
	public List<Aluno> findByTurmaNome(String nomeTurma) {
	    return this.alunoRepository.findByTurmaNome(nomeTurma);
	}
}
