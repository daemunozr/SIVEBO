package com.example.ms_sucursales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_sucursales.model.Comuna;

@Repository
public interface  ComunaRepository extends JpaRepository<Comuna, Long> {
    /*
    TODO Queries
    */
        
}
