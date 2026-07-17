package com.submission_service.Submission_Service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
@Schema(description = "Request to submit an exam with student's answers")
public record SubmitExamRequest(
        @NotEmpty(message = "Answers cannot be empty")
        @Schema(
                description = "List of answers submitted by the student",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        List<@Valid StudentAnswerRequest> answers
)
{
}
