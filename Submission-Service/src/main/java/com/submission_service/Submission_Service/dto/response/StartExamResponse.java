package com.submission_service.Submission_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after successfully starting an exam")
public record StartExamResponse(
        @Schema(
                description = "Unique ID of the created exam attempt",
                example = "1"
        )
        Long attemptId,

        @Schema(
                description = "Operation status message",
                example = "Exam started successfully"
        )
        String message
) {
}
