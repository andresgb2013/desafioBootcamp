package com.desafio.servicio_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.desafio.servicio_backend.models.affiliatesModel;

@Repository
public interface affiliatesReposity extends CrudRepository<affiliatesModel, Long> {

}