package com.example.ms_sucursales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "comunas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comuna {
        
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message="Nombre de comuna es obligatorio")
        @Size(max=20, message="Nombre de comuna no puede exceder los 20 caracteres")
        @Column(unique=true, length=20, nullable=false)
        private String nombre;

        @NotNull(message="Id de region es obligatorio")
        @ManyToOne
        @JoinColumn(name="idRegion", nullable=false)
        private Region region;
}
