package com.desafio.servicio_backend.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.servicio_backend.models.appointmentsModel;
import com.desafio.servicio_backend.services.appointmentsService;

@RestController
@RequestMapping("api/controller/appointments")
public class appointmentsController {
    
    @Autowired
    private appointmentsService Service;

	@GetMapping()
	public ResponseEntity<List<appointmentsModel>> getList() {
		List<appointmentsModel> consulta = Service.getList();
		if (consulta.size() != 0) {
		} else {
			return new ResponseEntity<List<appointmentsModel>>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<List<appointmentsModel>>(consulta, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<appointmentsModel> getById(@PathVariable("id") Long id) {
		appointmentsModel consulta = Service.getById(id);
		if (consulta != null) {
		} else {
			return new ResponseEntity<appointmentsModel>(HttpStatus.NOT_FOUND);
		}			
        return new ResponseEntity<appointmentsModel>(consulta, HttpStatus.OK);
	}

    @PostMapping()
    public ResponseEntity<appointmentsModel> saveInfo(@RequestBody @Validated appointmentsModel tests) {
        appointmentsModel consulta = Service.getById(tests.getId());
        if (consulta == null ){
            this.Service.saveList(tests);
        }else{
            return new ResponseEntity<appointmentsModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<appointmentsModel>(tests,HttpStatus.CREATED);
	}

    @PutMapping()
    public ResponseEntity<appointmentsModel> PutInfo(@RequestBody appointmentsModel tests) {
		appointmentsModel consulta = Service.getById(tests.getId()) ;
        if (consulta!=null){
            this.Service.UpdateList(tests);
        }else{
            return new ResponseEntity<appointmentsModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<appointmentsModel>(tests,HttpStatus.CREATED);
	}

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        appointmentsModel consulta = Service.getById(id) ;
        if (consulta!=null){
            this.Service.deleteById(id); 
        }else{
            return new ResponseEntity<String>("Usuario con id: "+ id+" no ha sido eliminado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("Usuario con id: "+ id+" ha sido eliminado",HttpStatus.OK);
    }


    @GetMapping("/date")
    public ResponseEntity<List<String>> findDate(@RequestParam("date") String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate local = LocalDate.parse(date, formatter);
        List<String> formato = Service.findDate(local);
        if(formato.size() != 0 ){
        }else{
            return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<String>>(formato, HttpStatus.OK);
    }    

    @GetMapping("/affiliate")
    public ResponseEntity<List<String>> findAffiliate(@RequestParam("id_affiliate") String id_affiliate) {
        Long local = Long.parseLong(id_affiliate);
        List<String> formato = Service.findAffiliate(local);
        if(formato.size() != 0 ){
        }else{
            return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<String>>(formato, HttpStatus.OK);
    }    
}


