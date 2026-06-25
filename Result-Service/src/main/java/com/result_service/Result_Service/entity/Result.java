package com.result_service.Result_Service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "result")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long attemptId;

    private Long studentId;

    private Long examId;

    private Integer totalQuestions;

    private Integer correctAnswers;

    private Double percentage;

    private String status; // PASS / FAIL
}
