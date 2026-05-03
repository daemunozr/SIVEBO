package com.example.ms_sucursales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "sucursales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Size(max=20, message="Nombre de sucursal no puede exceder los 20 caracteres")
    @Column(unique=true, length=20, nullable=false)
    private String nombre; 
    
    @Column(name="comuna_id", nullable=false)
    private Long comunaId;

    @Column(unique=true, nullable=false)
    private String direccionFisica; 

    @Digits(integer=9, fraction=0, message="Telefono de contacto debe tener 9 digitos")
    @Column(unique=true, precision=9, nullable=true)
    private Integer telefonoContacto;
}
