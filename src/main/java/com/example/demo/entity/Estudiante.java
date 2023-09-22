package com.example.demo.entity;

import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="TBL_ESTUDIANTES")
public class Estudiante{
        @Id
        @Column(name = "ID")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEstudiantes")
        @SequenceGenerator(name = "seqEstudiantes", allocationSize = 1, sequenceName = "SEQ_ESTUDIANTES")
        @Builder.Default
        private Long id=0L;
        @NotNull @NotBlank
        private String nombres;
        @NotNull @NotBlank
        private String apellidos;
        private Integer edad;
        @NotBlank(message = "Direccion es requerida")
        @Size(min = 3, max = 50)
        private String direccion;
        private String ciudad;
        private String pais;
        
        @ManyToOne
        @JoinColumn(name="CARRERA_ID", nullable = false)
        private Carrera carrera;
}