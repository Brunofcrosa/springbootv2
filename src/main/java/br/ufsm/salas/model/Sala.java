package br.ufsm.salas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "sala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da sala gerado pelo banco", example = "1")
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Schema(description = "Nome da sala (entre 3 e 50 caracteres)", example = "Laboratório de Redes")
    @Column(nullable = false, length = 50)
    private String nome;

    @NotBlank
    @Size(max = 10)
    @Schema(description = "Código único da sala (até 10 caracteres)", example = "CT-105")
    @Column(name = "codigo_sala", nullable = false, length = 10, unique = true)
    private String codigo;

    @NotNull
    @Min(10)
    @Max(200)
    @Schema(description = "Capacidade de alunos (entre 10 e 200)", example = "40")
    @Column(name = "capacidade_alunos", nullable = false)
    private Integer capacidadeAlunos;

    @Min(0)
    @Schema(description = "Quantidade de computadores (maior ou igual a 0)", example = "30")
    @Column(name = "quantidade_computadores")
    private Integer quantidadeComputadores;

    @NotNull
    @Min(1960)
    @Max(2026)
    @Schema(description = "Ano de construção (entre 1960 e 2026)", example = "2015")
    @Column(name = "ano_construcao", nullable = false)
    private Integer anoConstrucao;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Schema(description = "Área da sala em metros quadrados (maior que zero)", example = "65.50")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal area;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Schema(description = "Situação atual da sala", example = "DISPONIVEL")
    @Column(nullable = false, length = 20)
    private SituacaoSala situacao;
}
