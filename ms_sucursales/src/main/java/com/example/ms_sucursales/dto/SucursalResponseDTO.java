package com.example.ms_sucursales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalResponseDTO {

        private Long id;
        private String nombre; 
        private Long comunaId;
        private String direccionFisica; 
        private Integer telefonoContacto;
        
}
