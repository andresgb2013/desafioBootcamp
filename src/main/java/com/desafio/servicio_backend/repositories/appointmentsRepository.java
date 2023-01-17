package com.desafio.servicio_backend.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import com.desafio.servicio_backend.models.appointmentsModel;

@Repository
public interface appointmentsRepository extends CrudRepository<appointmentsModel, Long> {
    @Query(value = "SELECT  u.id_affiliate, u.hour ,a.name FROM  appointments u INNER JOIN affiliates a ON a.id = u.id_affiliate WHERE u.date LIKE :date GROUP BY u.id_affiliate, u.hour, a.name order by u.id_affiliate asc", nativeQuery = true)
    List<String> findBydate( LocalDate  date);

    @Query(value = "SELECT  u.hour, u.date,a.name FROM  appointments u INNER JOIN affiliates a ON a.id = u.id_affiliate WHERE u.id_affiliate LIKE :id_affiliate GROUP BY u.id_affiliate, u.hour,u.date, a.name order by u.id_affiliate asc", nativeQuery = true)
    List<String> findByAffiliate( Long  id_affiliate);
}
//@Param("date")
//"SELECT  u.hour, a.name, a.age, a.mail  FROM affiliates a JOIN appointments u ON a.id = u.id_affiliate WHERE u.date LIKE '2022-12-12' ;