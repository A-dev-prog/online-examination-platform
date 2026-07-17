package com.submission_service.Submission_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Basic exam information")
public record ExamResponse(
        @Schema(
                description = "Unique ID of the exam",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Title of the exam",
                example = "Java Basics Test"
        )
        String title,

        @Schema(
                description = "Indicates whether the exam is published",
                example = "true"
        )
        Boolean published
) {
}
