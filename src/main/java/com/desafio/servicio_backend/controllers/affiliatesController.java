package com.desafio.servicio_backend.controllers;

import java.util.List;

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

import com.desafio.servicio_backend.models.affiliatesModel;
import com.desafio.servicio_backend.services.affiliatesService;

@RestController
@RequestMapping("api/controller/affiliates")
public class affiliatesController {
    @Autowired
    private affiliatesService Service;

	@GetMapping()
	public ResponseEntity<List<affiliatesModel>> getList() {
		List<affiliatesModel> consulta = Service.getList();
		if (consulta.size() != 0) {
		} else {
			return new ResponseEntity<List<affiliatesModel>>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<List<affiliatesModel>>(consulta, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<affiliatesModel> getById(@PathVariable("id") Long id) {
		affiliatesModel consulta = Service.getById(id);
		if (consulta != null) {
		} else {
			return new ResponseEntity<affiliatesModel>(HttpStatus.NOT_FOUND);
		}			
        return new ResponseEntity<affiliatesModel>(consulta, HttpStatus.OK);
	}

    @PostMapping()
    public ResponseEntity<affiliatesModel> saveInfo(@RequestBody @Validated affiliatesModel tests) {
        affiliatesModel consulta = Service.getById(tests.getId());
        if (consulta == null){
            this.Service.saveList(tests);
        }else{
            return new ResponseEntity<affiliatesModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<affiliatesModel>(tests,HttpStatus.CREATED);
	}

    @PutMapping()
    public ResponseEntity<affiliatesModel> PutInfo(@RequestBody affiliatesModel tests) {
		affiliatesModel consulta = Service.getById(tests.getId()) ;
        System.out.println(consulta);
        if (consulta!=null){
            this.Service.UpdateList(tests);
        }else{
            return new ResponseEntity<affiliatesModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<affiliatesModel>(tests,HttpStatus.CREATED);
	}

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        affiliatesModel consulta = Service.getById(id) ;
        if (consulta!=null){
            this.Service.deleteById(id); 
        }else{
            return new ResponseEntity<String>("Usuario con id: "+ id+" no ha sido eliminado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("Usuario con id: "+ id+" ha sido eliminado",HttpStatus.OK);
    }
}