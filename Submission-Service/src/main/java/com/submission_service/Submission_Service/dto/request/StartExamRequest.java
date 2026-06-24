package com.submission_service.Submission_Service.dto.request;

import jakarta.validation.constraints.NotNull;

public record StartExamRequest(
        @NotNull
        Long examId,
        @NotNull
        Long studentId) {
}
