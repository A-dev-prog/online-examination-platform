package com.exam_service.Exam_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Summary information of an exam")
public record ExamSummaryResponse(
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
                description = "Duration of the exam in minutes",
                example = "30"
        )
        Integer durationMinutes,

        @Schema(
                description = "Total marks of the exam",
                example = "20"
        )
        Integer totalMarks,

        @Schema(
                description = "Indicates whether the exam has been published",
                example = "true"
        )
        Boolean published
) {
}
