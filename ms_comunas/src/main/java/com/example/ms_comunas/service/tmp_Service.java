package com.example.ms_sucursales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_sucursales.model.Comuna;
import com.example.ms_sucursales.repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {
        
        @Autowired
        private ComunaRepository repository;

        public List<Comuna> findAll() {
                return repository.findAll();
        }

        public Optional<Comuna> findById(Long id) {
                return repository.findById(id);
        }


        public Comuna save(Comuna comuna) {
                return repository.save(comuna);
        }

        public void deleteById(Long id) {
                repository.deleteById(id);
        }
}
