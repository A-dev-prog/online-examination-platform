package com.exam_service.Exam_Service.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Correct answer information for a question (Internal API Response)")
public record QuestionAnswerKeyResponse(
        @Schema(
                description = "Unique ID of the question",
                example = "1"
        )
        Long questionId,

        @Schema(
                description = "ID of the correct answer option",
                example = "3"
        )
        Long correctOptionId
) {
}
