package com.example.ms_sucursales.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ms_sucursales.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

    Optional<Sucursal> findByNombreContainingIgnoreCase(String nombre) throws Exception;

    List<Sucursal> findByComunaId(Long comunaId);
}
