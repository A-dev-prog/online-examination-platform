package com.exam_service.Exam_Service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAnswerOptionRequest(
        @NotBlank(message = "Option text is required")
        @Schema(
                description = "Text of the answer option",
                example = "extends",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String optionText,

        @NotNull(message = "Correct flag is required")
        @Schema(
                description = "Whether this option is correct",
                example = "true",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Boolean correct

) {
}
