package app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.Turma;
import app.service.TurmaService;

@Controller
@RequestMapping("api/class")
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
}
