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

import app.entity.Curso;
import app.service.CursoService;

@Controller
@RequestMapping("api/course")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Curso curso) {
		try {
			String msg = this.cursoService.save(curso);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Curso> findById(@PathVariable long id) {
		try {
			Optional<Curso> c = this.cursoService.findById(id);
			return new ResponseEntity<>(c.get(), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String msg = this.cursoService.delete(id);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Curso curso) {
		try {
			String msg = this.cursoService.update(curso);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Curso>> findAll() {
		try {
			List<Curso> listaCursos = this.cursoService.findAll();
			return new ResponseEntity<>(listaCursos, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
