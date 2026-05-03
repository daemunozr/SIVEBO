package com.example.ms_sucursales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_sucursales.model.Sucursal;
import com.example.ms_sucursales.service.SucursalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {

        @Autowired
        private SucursalService service;

        @GetMapping
        public ResponseEntity<List<Sucursal>> findAll() {
                List<Sucursal> sucursales = service.findAll();
                if(sucursales.isEmpty()) {
                        return ResponseEntity.noContent().build();
                }
                return ResponseEntity.ok(sucursales);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Sucursal> findById(@PathVariable Long id) {
                return service.findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Sucursal> save(@Valid @RequestBody Sucursal sucursal) {
            return ResponseEntity.status(201).body(service.save(sucursal));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Sucursal> update(@PathVariable Long id, @Valid @RequestBody Sucursal sucursal) {
            return service.findById(id)
                    .map(existingSucursal -> {
                        sucursal.setId(existingSucursal.getId());
                        return ResponseEntity.ok(service.save(sucursal));
                    })
                    .orElse(ResponseEntity.notFound().build());
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable Long id) {
                if (service.findById(id).isPresent())
                        return ResponseEntity.notFound().build();
                service.deleteById(id);
                return ResponseEntity.noContent().build();
        }
        
        @GetMapping("/buscar")
        public ResponseEntity<Sucursal> findByNombre(@RequestParam String nombre) {
            return ResponseEntity.ok(service.findByNombre(nombre));
        }

        @GetMapping("/comuna/{id}")
        public ResponseEntity<List<Sucursal>> findByComunaId(@PathVariable Long id) {
            return ResponseEntity.ok(service.findByComunaId(id));
        }
        
        
        
        
}
