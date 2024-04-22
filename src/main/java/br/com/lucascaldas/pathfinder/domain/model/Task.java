package br.com.lucascaldas.pathfinder.domain.model;

import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.lucascaldas.pathfinder.domain.enums.TaskPriorityEnum;
import br.com.lucascaldas.pathfinder.domain.enums.TaskStatusEnum;
import br.com.lucascaldas.pathfinder.domain.enums.TaskTagEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "task_gen")
    @TableGenerator(name = "task_gen", initialValue = 10000)
    @Column(name = "TASK_CD_ID")
    private Long taskId;

    @Column(name = "TASK_TX_CODE", nullable = false)
    private String taskCode;

    @PrePersist
    public void generateTaskCode() {
        this.taskCode = "TASK-" + this.taskId;
    }

    @Column(name = "TASK_TX_DESC")
    private String taskDesc;

    @Column(name = "TASK_TX_TAG", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskTagEnum taskTag;

    @Column(name = "TASK_TX_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum tastStatus;

    @Column(name = "TASK_TX_PRIORITY", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum taskPriority;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private transient List<Flow> previusFlow;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private transient List<Flow> nextFlow;

    @CreationTimestamp
    @Column(name = "TASK_DT_CREATE", nullable = false, columnDefinition = "datetime")
    private OffsetDateTime dataCadastro;
    
    @UpdateTimestamp
    @Column(name = "TASK_DT_", nullable = false, columnDefinition = "datetime")
    private OffsetDateTime dataAtualizacao;

}
