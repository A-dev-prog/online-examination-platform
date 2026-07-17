package com.submission_service.Submission_Service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
@Schema(description = "Student's answer for a question")
public record StudentAnswerRequest(

        @NotNull(message = "Question ID is required")
        @Schema(
                description = "Unique ID of the question being answered",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long questionId,

        @NotNull(message = "Selected option ID is required")
        @Schema(
                description = "ID of the option selected by the student",
                example = "3",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long selectedOptionId
) {
}
