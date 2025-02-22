package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern(regexp = "^\\S+\\s+\\S+.*$", message = "O nome deve conter pelo menos duas palavras.")
	private String nome;
	
	@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF no formato XXX.XXX.XXX-XX.")
	private String cpf;
	
	
	private String telefone;
	
	@ManyToOne
    @JoinColumn(name = "turma_id")
	@JsonIgnore 
	private Turma turma;
	
	private boolean cadastroCompleto;
}
