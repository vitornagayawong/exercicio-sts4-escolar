package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	public List<Aluno> findByNomeStartingWith(String nome);
	
	public List<Aluno> findByTelefoneContaining(String telefone);
	
	@Query("SELECT a FROM Aluno a WHERE a.turma.nome = :nomeTurma")
    List<Aluno> findByTurmaNome(@Param("nomeTurma") String nomeTurma);
	
	//Não permitir a INSERÇÃO de um aluno com CPF já cadastrado. Caso aconteça, lançar throw new RuntimeException("CPF já cadastrado!"). 
	public List<Aluno> findByCpf(String cpf);  
	
}
