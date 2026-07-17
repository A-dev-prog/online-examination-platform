package com.submission_service.Submission_Service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
@Schema(description = "Request to start an exam attempt")
public record StartExamRequest(
        @NotNull(message = "Exam ID is required")
        @Schema(
                description = "Unique ID of the exam to be attempted",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long examId,

        @NotNull(message = "Student ID is required")
        @Schema(
                description = "Unique ID of the student",
                example = "101",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long studentId
        ) {
}
