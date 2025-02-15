package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern(regexp = "^\\S+\\s+\\S+.*$", message = "O nome deve conter pelo menos duas palavras.")
	private String nome;
	
	@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF no formato XXX.XXX.XXX-XX.")
	private String cpf;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email no formato algumacoisa@algumacoisa.algumacoisa.")
	private String email;
	
	@NotBlank(message = "Se informado, especialidade não pode estar vazia.")
	@Pattern(regexp = "^\\S+\\s+\\S+.*$", message = "A especialidade deve conter pelo menos duas palavras.")
	private String especialidade;
	
	 @ManyToMany(mappedBy = "professores")
	 private List<Turma> turmas;
	
}
