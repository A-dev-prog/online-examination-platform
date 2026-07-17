package com.exam_service.Exam_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Question details of an exam")
public record QuestionResponse(

        @Schema(
                description = "Unique ID of the question",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Question statement",
                example = "Which keyword is used to inherit a class in Java?"
        )
        String questionText,

        @Schema(
                description = "Marks assigned to the question",
                example = "10"
        )
        Integer marks,

        @Schema(
                description = "Order in which the question appears in the exam",
                example = "1"
        )
        Integer displayOrder,

        @Schema(
                description = "Type of the question",
                example = "SINGLE_CHOICE"
        )
        String questionType,

        @Schema(
                description = "Available answer options for the question"
        )
        List<AnswerOptionResponse> options
) {
}
