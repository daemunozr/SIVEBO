package com.example.ms_sucursales.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ms_sucursales.model.Sucursal;
import com.example.ms_sucursales.repository.SucursalRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitalizer implements CommandLineRunner{

    private final SucursalRepository repository;

    @Override
    public void run(String... args){

        if (repository.count() > 0) {
            log.info(">>> ms_sucursales: BD ya tiene datos, se omite la carga inicial.");
            return;
        }

        repository.save(new Sucursal(
            null,
            "Vicuña Mackenna", 
            1L,
            "Av. Vicuña Mackenna 886",
            123456789
        ));

        repository.save(new Sucursal(
            null,
            "Providencia",
            2L,
            "Av. Providencia 2000",
            987654321
        ));

        log.info("ms_sucursales: {} sucursales insertadas.", repository.count());
    }
}
