package br.com.lucascaldas.pathfinder.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Flow {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLOW_CD_ID")
    private Long flowId;

    @ManyToOne
    @JoinColumn(name = "PRIOR_TAST_PK")
    @JsonBackReference
    private Task previusTask;

    @ManyToOne
    @JoinColumn(name = "AFTER_TAST_PK")
    @JsonBackReference
    private Task nextTask;



}
