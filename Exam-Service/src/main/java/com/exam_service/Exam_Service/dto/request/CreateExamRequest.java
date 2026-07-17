package com.exam_service.Exam_Service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
@Schema(description = "Request object for creating a new exam")
public record CreateExamRequest(
        @Schema(
                description = "Title of the exam",
                example = "Java Basics Test"
        )
        @NotBlank(message = "Title is required")
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
                description = "Total marks for the exam",
                example = "20"
        )
        Integer totalMarks,

        @Schema(
                description = "ID of the teacher creating the exam",
                example = "1"
        )
        Long createdBy,

        @Schema(
                description = "List of questions included in the exam"
        )
        List<CreateQuestionRequest> questions
) {
}
