package com.exam_service.Exam_Service.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Answer key details of an exam (Internal API Response)")
public record ExamAnswerKeyResponse(
        @Schema(
                description = "Unique ID of the exam",
                example = "1"
        )
        Long examId,

        @Schema(
                description = "List of questions with their correct answer option IDs"
        )
        List<QuestionAnswerKeyResponse> questions
) {
}
