package org.example.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;
import org.example.entity.enumeration.Mode;
import org.example.entity.enumeration.TaskPriority;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
//    @Column(nullable = false)
    private User user;

}
