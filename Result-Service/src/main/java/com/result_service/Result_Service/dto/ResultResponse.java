package com.result_service.Result_Service.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Complete details of a student's exam result")
public record ResultResponse(
        @Schema(
                description = "Unique ID of the result",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Unique ID of the exam attempt",
                example = "1"
        )
        Long attemptId,

        @Schema(
                description = "Unique ID of the student",
                example = "101"
        )
        Long studentId,

        @Schema(
                description = "Unique ID of the exam",
                example = "1"
        )
        Long examId,

        @Schema(
                description = "Total number of questions in the exam",
                example = "20"
        )
        Integer totalQuestions,

        @Schema(
                description = "Number of correctly answered questions",
                example = "18"
        )
        Integer correctAnswers,

        @Schema(
                description = "Percentage score obtained by the student",
                example = "90.0"
        )
        Double percentage,

        @Schema(
                description = "Result status",
                example = "PASS"
        )
        String status
) {
}
