package com.submission_service.Submission_Service.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Student's answer details (Internal API Response)")
public record AttemptAnswerResponse(

        @Schema(
                description = "Unique ID of the question",
                example = "1"
        )
        Long questionId,

        @Schema(
                description = "ID of the option selected by the student",
                example = "3"
        )
        Long selectedOptionId
) {
}
