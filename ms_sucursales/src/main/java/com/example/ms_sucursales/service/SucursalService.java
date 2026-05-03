package com.example.ms_sucursales.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_sucursales.dto.SucursalResponseDTO;
import com.example.ms_sucursales.dto.SucursalRequestDTO;
import com.example.ms_sucursales.model.Sucursal;
import com.example.ms_sucursales.repository.SucursalRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SucursalService {

        @Autowired
        private SucursalRepository repository;

        // DTO mapping method
        private SucursalResponseDTO mapToDTO(Sucursal sucursal) {
                return new SucursalResponseDTO(
                        sucursal.getId(),
                        sucursal.getNombre(),
                        sucursal.getComunaId(),
                        sucursal.getDireccionFisica(),
                        sucursal.getTelefonoContacto()
                );
        }

        //CRUD methods
        public List<SucursalResponseDTO> findAll() {
                return repository.findAll().stream()
                        .map(this::mapToDTO).collect(Collectors.toList());
        }

        public Optional<SucursalResponseDTO> findById(Long id) {
                return repository.findById(id).map(this::mapToDTO);
        }

        public List<SucursalResponseDTO> findByComunaId(Long comunaId) {
                return repository.findByComunaId(comunaId).stream()
                        .map(this::mapToDTO).collect(Collectors.toList());
        }

        public Optional<SucursalResponseDTO> findByNombre(String nombre) {
                try {
                        return repository.findByNombreContainingIgnoreCase(nombre).map(this::mapToDTO);
                } catch (Exception exception) {
                        exception.printStackTrace();
                        return Optional.empty();
                }
        }

        public SucursalResponseDTO save(SucursalRequestDTO dto) {
                Sucursal sucursal = new Sucursal(
                        null,
                        dto.getNombre(),
                        dto.getComunaId(),
                        dto.getDireccionFisica(),
                        dto.getTelefonoContacto()
                );
                return mapToDTO(repository.save(sucursal)) ;
        }

        public Optional<SucursalResponseDTO> update(Long id, SucursalRequestDTO dto) {
                return repository.findById(id).map(existing -> {
                        existing.setNombre(dto.getNombre());
                        existing.setComunaId(dto.getComunaId());
                        existing.setDireccionFisica(dto.getDireccionFisica());
                        existing.setTelefonoContacto(dto.getTelefonoContacto());
                        return mapToDTO(repository.save(existing));
                });
        }

        public void deleteById(Long id) {
                repository.deleteById(id);
        }

}
