package com.exam_service.Exam_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Complete details of an exam")
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
                description = "Brief description of the exam",
                example = "Assessment covering Core Java fundamentals."
        )
        String description,

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
                description = "Indicates whether the exam is published",
                example = "true"
        )
        Boolean published,

        @Schema(
                description = "ID of the teacher who created the exam",
                example = "1"
        )
        Long createdBy,

        @Schema(
                description = "List of questions included in the exam"
        )
        List<QuestionResponse> questions
) {
}
