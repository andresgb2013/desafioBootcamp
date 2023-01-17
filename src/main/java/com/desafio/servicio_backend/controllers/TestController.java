package com.desafio.servicio_backend.controllers;

import java.util.List;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.servicio_backend.models.TestModel;
import com.desafio.servicio_backend.services.TestService;

@RestController
@RequestMapping("api/controller/test")
public class TestController {
    @Autowired
    private TestService testService;

	@GetMapping()
	public ResponseEntity<List<TestModel>> getList() {
		List<TestModel> consulta = testService.getList();
		if (consulta.size() != 0) {
		} else {
			return new ResponseEntity<List<TestModel>>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<List<TestModel>>(consulta, HttpStatus.OK);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<TestModel> getById(@PathVariable("id") Long id) {
		TestModel consulta = testService.getById(id);
		if (consulta != null) {
		} else {
			return new ResponseEntity<TestModel>(HttpStatus.NOT_FOUND);
		}			
        return new ResponseEntity<TestModel>(consulta, HttpStatus.OK);
	}

    @PostMapping()
    public ResponseEntity<TestModel> saveInfo(@RequestBody @Validated TestModel tests) {
        TestModel consulta = testService.getById(tests.getId());
        if (consulta == null ){
            this.testService.saveList(tests);
        }else{
            return new ResponseEntity<TestModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TestModel>(tests,HttpStatus.CREATED);
	}

    @PutMapping()
    public ResponseEntity<TestModel> PutInfo(@RequestBody TestModel tests) {
		TestModel consulta = testService.getById(tests.getId()) ;
        if (consulta!=null){
            this.testService.UpdateList(tests);
        }else{
            return new ResponseEntity<TestModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TestModel>(tests,HttpStatus.CREATED);
	}

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        TestModel consulta = testService.getById(id) ;
        if (consulta!=null){
            this.testService.deleteById(id); 
        }else{
            return new ResponseEntity<String>("Usuario con id: "+ id+" no ha sido eliminado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("Usuario con id: "+ id+" ha sido eliminado",HttpStatus.OK);
    }

}