package com.desafio.servicio_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.desafio.servicio_backend.models.*;

@Repository
public interface TestRepository extends CrudRepository<TestModel, Long> {

}