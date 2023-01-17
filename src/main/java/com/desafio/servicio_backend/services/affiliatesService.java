package com.desafio.servicio_backend.services;

import org.springframework.stereotype.Service;

import com.desafio.servicio_backend.models.affiliatesModel;
import com.desafio.servicio_backend.repositories.affiliatesReposity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class affiliatesService {
    @Autowired
    affiliatesReposity Repository;

    public List<affiliatesModel> getList(){
        return (List<affiliatesModel>) Repository.findAll();
    }

    public affiliatesModel getById(Long id){
        try{
            affiliatesModel consulta = Repository.findById(id).orElse(null);
            return consulta;
        }catch (Exception err){
            return null;
        }
    }

    public boolean saveList(affiliatesModel tests){
        try{
            Repository.save(tests);
            return true;
        }
        catch(Exception err){
            return false;
        }
    }

    public boolean UpdateList(affiliatesModel tests){
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
}
