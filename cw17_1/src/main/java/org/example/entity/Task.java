package org.example.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;
import org.example.entity.enumaration.Mode;
import org.example.entity.enumaration.TaskPriority;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private TaskPriority taskPriority;
    private Mode mode;

    @ManyToOne
    private User user;

}
