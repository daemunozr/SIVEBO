package com.example.ms_sucursales.controller;

import java.util.List;

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

import com.example.ms_sucursales.dto.SucursalRequestDTO;
import com.example.ms_sucursales.dto.SucursalResponseDTO;
import com.example.ms_sucursales.service.SucursalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/sucursales")
@RequiredArgsConstructor
public class SucursalController {

        private final SucursalService service;

        @GetMapping
        public ResponseEntity<List<SucursalResponseDTO>> findAll() {
                return ResponseEntity.ok(service.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<SucursalResponseDTO> findById(@PathVariable Long id) {
                return service.findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/comuna/{id}")
        public ResponseEntity<List<SucursalResponseDTO>> findByComunaId(@PathVariable Long id) {
            return ResponseEntity.ok(service.findByComunaId(id));
        }

        @GetMapping("/buscar")
        public ResponseEntity<SucursalResponseDTO> findByNombre(@RequestParam String nombre) {
            return service.findByNombre(nombre)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<SucursalResponseDTO> save(@Valid @RequestBody SucursalRequestDTO dto) {
            return ResponseEntity.status(201).body(service.save(dto));
        }

        @PutMapping("/{id}")
        public ResponseEntity<SucursalResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SucursalRequestDTO dto) {
            return service.update(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
                if (service.findById(id).isEmpty())
                        return ResponseEntity.notFound().build();
                service.deleteById(id);
                return ResponseEntity.noContent().build();
        }
        
}
