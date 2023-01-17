package com.desafio.servicio_backend.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import com.desafio.servicio_backend.models.appointmentsModel;
import com.desafio.servicio_backend.repositories.appointmentsRepository;

@Service
public class appointmentsService {
    @Autowired
    appointmentsRepository Repository;

    public List<appointmentsModel> getList(){
        return (List<appointmentsModel>) Repository.findAll();
    }
    
    public appointmentsModel getById(Long id){
        try{
            appointmentsModel consulta = Repository.findById(id).orElse(null);
            return consulta;
        }catch (Exception err){
            return null;
        }
    }

    public boolean saveList(appointmentsModel tests){
        try{
            Repository.save(tests);
            return true;
        }
        catch(Exception err){
            return false;
        }
    }

    public boolean UpdateList(appointmentsModel tests){
        try{
            Repository.save(tests);
            return true;
        }
        catch(Exception err){
            return false;
        }
    }
    
    public boolean deleteById(Long id) {
        try{
            Repository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public List<String>  findDate(LocalDate  date) {
        List<String> a = Repository.findBydate(date);
        return Repository.findBydate(date);
    }

    public List<String>  findAffiliate(Long  id_affiliate) {
        List<String> a = Repository.findByAffiliate(id_affiliate);
        return Repository.findByAffiliate(id_affiliate);
    }
}