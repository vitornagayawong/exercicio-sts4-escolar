package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@NotNull
	private String nome;
	
	private String semestre;
	private String ano;
	private String turno;
	
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos;
	
	 @ManyToMany
	 @JoinTable(
	     name = "turma_professor"	      
	 )
	 private List<Professor> professores;
	 
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "curso_id", nullable = false)
	 private Curso curso;
}
