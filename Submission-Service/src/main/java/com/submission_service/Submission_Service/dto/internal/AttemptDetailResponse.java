package com.submission_service.Submission_Service.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Exam attempt details for Result Service (Internal API Response)")
public record AttemptDetailResponse(
        @Schema(
                description = "Unique ID of the exam attempt",
                example = "1"
        )
        Long attemptId,

        @Schema(
                description = "Unique ID of the exam",
                example = "1"
        )
        Long examId,

        @Schema(
                description = "Unique ID of the student",
                example = "101"
        )
        Long studentId,

        @Schema(
                description = "List of answers submitted by the student"
        )
        List<AttemptAnswerResponse> answers
) {
}
