package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public String save(Turma turma) {
		this.turmaRepository.save(turma);
		return "Turma cadastrada com sucesso!";
	}

	public Optional<Turma> findById(long id) {
		Optional<Turma> turma = this.turmaRepository.findById(id);
		return turma;
	}

	public String delete(long id) {
		this.turmaRepository.deleteById(id);
		return "Turma deletada com sucesso!";
	}

	public String update(Turma turma) {
		this.turmaRepository.save(turma);
		return "Turma atualizada com sucesso!";
	}

	public List<Turma> findAll() {
		return this.turmaRepository.findAll();
	}

	public List<Turma> findByAnoBetween(String anoInicio, String anoFim) {
		return this.turmaRepository.findByAnoBetween(anoInicio, anoFim);
	}

	public List<Turma> findBySemestreAndAno(String semestre, String ano) {
		return this.turmaRepository.findBySemestreAndAno(semestre, ano);
	}
	
	public List<Turma> findByNomeAndTurno(String nome, String turno) {
        return this.turmaRepository.findByNomeAndTurno(nome, turno);
    }
	
	public List<Turma> findByCursoNome(String nomeCurso) {
        return this.turmaRepository.findByCursoNome(nomeCurso);
    }

}
