package com.exam_service.Exam_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after successfully creating an exam")
public record CreateExamResponse(
        @Schema(
                description = "Unique ID of the newly created exam",
                example = "1"
        )
        Long examId,

        @Schema(
                description = "Operation status message",
                example = "Exam created successfully"
        )
        String message
) {
}
