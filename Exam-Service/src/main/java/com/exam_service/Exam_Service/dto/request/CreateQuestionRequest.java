package com.exam_service.Exam_Service.dto.request;

import com.exam_service.Exam_Service.entity.QuestionType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Schema(description = "Request object for creating a question")
public record CreateQuestionRequest(

        @Schema(
                description = "Question text",
                example = "Which keyword is used to inherit a class in Java?"
        )
        @NotBlank(message = "Question text is required")
        String questionText,

        @Schema(
                description = "Marks assigned to this question",
                example = "10"
        )
        Integer marks,

        @Schema(
                description = "Display order of the question in the exam",
                example = "1"
        )
        Integer displayOrder,

        @Schema(
                description = "Type of question",
                example = "SINGLE_CHOICE"
        )
        QuestionType questionType,

        @Schema(
                description = "Available answer options for the question"
        )
        List<CreateAnswerOptionRequest> options
) {
}
