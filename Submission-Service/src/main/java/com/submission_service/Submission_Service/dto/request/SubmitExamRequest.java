package com.submission_service.Submission_Service.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record SubmitExamRequest(
        @NotEmpty(message = "Answers cannot be empty")
        List<@Valid StudentAnswerRequest> answers
)
{
}
