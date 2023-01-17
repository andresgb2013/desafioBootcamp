package com.desafio.servicio_backend.models;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


@Entity
@Table(name = "appointments")
public class appointmentsModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id",unique = true, nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern ="dd-MM-yyyy",timezone = "GMT-5")
    private LocalDate  date;

    @Column(name = "hour",nullable = false)
    @DateTimeFormat(pattern = "HH:mm", fallbackPatterns = "hh:mm")
    @JsonFormat(pattern ="HH:mm",timezone = "GMT-5" )
    private LocalTime  hour;

    
    @Column(name = "id_test", nullable = false)
    private Long id_test;
    @Column(name = "id_affiliate", nullable = false)
    private Long id_affiliate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getHour() {
        return hour;
    }
    public void setHour(LocalTime hour) {
        this.hour = hour;
    }
    public Long getId_test() {
        return id_test;
    }
    public void setId_test(Long id_test) {
        this.id_test = id_test;
    }
    public Long getId_affiliate() {
        return id_affiliate;
    }
    public void setId_affiliate(Long id_affiliate) {
        this.id_affiliate = id_affiliate;
    }
    
    

   
    
}
