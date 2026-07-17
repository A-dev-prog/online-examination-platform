package com.submission_service.Submission_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.List;
@Schema(description = "Complete details of an exam attempt")
public record AttemptResponse(
        @Schema(
                description = "Unique ID of the exam attempt",
                example = "1"
        )
        Long attemptId,

        @Schema(
                description = "ID of the exam",
                example = "1"
        )
        Long examId,

        @Schema(
                description = "ID of the student who attempted the exam",
                example = "101"
        )
        Long studentId,

        @Schema(
                description = "Current status of the exam attempt",
                example = "SUBMITTED"
        )
        String status,

        @Schema(
                description = "Date and time when the exam was started (UTC)",
                example = "2026-07-17T10:15:30Z"
        )
        Instant startedAt,

        @Schema(
                description = "Date and time when the exam was submitted (UTC)",
                example = "2026-07-17T10:42:15Z"
        )
        Instant submittedAt,

        @Schema(
                description = "List of answers submitted by the student"
        )
        List<StudentAnswerResponse> answers
) {
}
