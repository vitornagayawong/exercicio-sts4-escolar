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

import app.entity.Aluno;
import app.service.AlunoService;

@Controller
@RequestMapping("api/student")
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Aluno aluno) {
		try {
			String msg = this.alunoService.save(aluno);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable long id) {
		try {
			Optional<Aluno> a = this.alunoService.findById(id);
			return new ResponseEntity<>(a.get(), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String msg = this.alunoService.delete(id);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Aluno aluno) {
		try {
			String msg = this.alunoService.update(aluno);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Aluno>> findAll() {
		try {
			List<Aluno> listaAlunos = this.alunoService.findAll();
			return new ResponseEntity<>(listaAlunos, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNomeStartingWith")
	public ResponseEntity<List<Aluno>> findByNomeStartingWith(@RequestParam String nome) {
		try {
			List<Aluno> alunos = this.alunoService.findByNomeStartingWith(nome);
			return new ResponseEntity<>(alunos, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByTelefoneContaining")
	public ResponseEntity<List<Aluno>> findByTelefoneContaining(@RequestParam String telefone) {
		try {
			List<Aluno> alunos = this.alunoService.findByTelefoneContaining(telefone);
			return new ResponseEntity<>(alunos, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@GetMapping("/findByTurmaNome")
	public ResponseEntity<List<Aluno>> findByTurmaNome(@RequestParam String nomeTurma) {
		try {
			List<Aluno> alunos = this.alunoService.findByTurmaNome(nomeTurma);
		    return new ResponseEntity<>(alunos, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
