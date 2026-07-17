package com.exam_service.Exam_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after publishing an exam")
public record PublishedExamResponse(
        @Schema(
                description = "Unique ID of the published exam",
                example = "1"
        )
        Long examId,

        @Schema(
                description = "Indicates whether the exam is published",
                example = "true"
        )
        Boolean published,

        @Schema(
                description = "Operation status message",
                example = "Exam published successfully"
        )
        String message
) {
}
