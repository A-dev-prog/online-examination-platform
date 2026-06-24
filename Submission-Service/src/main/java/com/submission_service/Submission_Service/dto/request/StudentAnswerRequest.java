package com.submission_service.Submission_Service.dto.request;

import jakarta.validation.constraints.NotNull;

public record StudentAnswerRequest(
        @NotNull
        Long questionId,

        @NotNull
        Long selectedOptionId) {
}
