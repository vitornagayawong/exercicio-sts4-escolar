package app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.entity.Turma;
import app.service.TurmaService;

@Controller
@RequestMapping("api/class")
@CrossOrigin("*")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Turma turma) {
		try {
			String msg = this.turmaService.save(turma);
			return new ResponseEntity<>(msg, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Turma> findById(@PathVariable long id) {
		try {
			Optional<Turma> t = this.turmaService.findById(id);
			return new ResponseEntity<>(t.get(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String msg = this.turmaService.delete(id);
			return new ResponseEntity<>(msg, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Turma turma) {
		try {
			String msg = this.turmaService.update(turma);
			return new ResponseEntity<>(msg, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Turma>> findAll() {
		try {
			List<Turma> listaTurmas = this.turmaService.findAll();
			return new ResponseEntity<>(listaTurmas, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByAnoBetween")
	public ResponseEntity<List<Turma>> findByAnoBetween(@RequestParam String anoInicio, @RequestParam String anoFim) {
		try {
			List<Turma> turmas = this.turmaService.findByAnoBetween(anoInicio, anoFim);
			return new ResponseEntity<>(turmas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findBySemestreAndAno")
	public ResponseEntity<List<Turma>> findBySemestreAndAno(@RequestParam String semestre, @RequestParam String ano) {
		try {
			List<Turma> turmas = this.turmaService.findBySemestreAndAno(semestre, ano);
			return new ResponseEntity<>(turmas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByNomeAndTurno")
	public ResponseEntity<List<Turma>> findByNomeAndTurno(@RequestParam String nome, @RequestParam String turno) {
		try {
			List<Turma> turmas = this.turmaService.findByNomeAndTurno(nome, turno);
			return new ResponseEntity<>(turmas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByCursoNome")
	public ResponseEntity<List<Turma>> findByCursoNome(@RequestParam String nomeCurso) {
		try {
			List<Turma> turmas = this.turmaService.findByCursoNome(nomeCurso);
			return new ResponseEntity<>(turmas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
