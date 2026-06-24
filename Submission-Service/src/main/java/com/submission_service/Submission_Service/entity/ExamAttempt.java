package com.submission_service.Submission_Service.entity;

import com.submission_service.Submission_Service.enums.AttemptStatus;
import jakarta.persistence.*;

import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam_attempts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;

    private Long studentId;

    private Instant startedAt;

    private Instant submittedAt;
    @Enumerated(EnumType.STRING)
    private AttemptStatus  status;

    @OneToMany(
            mappedBy = "examAttempt",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentAnswer> answers = new ArrayList<>();


}
