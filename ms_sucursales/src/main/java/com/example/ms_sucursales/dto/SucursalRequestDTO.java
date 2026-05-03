package com.example.ms_sucursales.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalRequestDTO {

        @NotBlank(message="Nombre de sucursal es obligatorio")    
        private String nombre; 

        @NotNull(message="Id de comuna es obligatorio")
        private Long comunaId;
        
        @NotBlank(message="Direccion fisica es obligatoria")
        private String direccionFisica; 
        
        @NotNull(message="Telefono de contacto es obligatorio")
        private Integer telefonoContacto;
        
        
        
}
