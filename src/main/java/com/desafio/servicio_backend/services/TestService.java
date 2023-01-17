package com.desafio.servicio_backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.desafio.servicio_backend.models.*;
import com.desafio.servicio_backend.repositories.TestRepository;

@Service
public class TestService {
    @Autowired
    TestRepository Repository;

    public List<TestModel> getList(){
        return (List<TestModel>) Repository.findAll();
    }
    
    public TestModel getById(Long id){
        try{
            TestModel consulta = Repository.findById(id).orElse(null);
            return consulta;
        }catch (Exception err){
            return null;
        }
    }

    public boolean saveList(TestModel tests){
        try{
            Repository.save(tests);
            return true;
        }
        catch(Exception err){
            return false;
        }
    }

    public boolean UpdateList(TestModel tests){
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