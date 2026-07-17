package com.exam_service.Exam_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Answer option details")
public record AnswerOptionResponse (

        @Schema(
                description = "Unique ID of the answer option",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Text of the answer option",
                example = "extends"
        )
        String optionText,

        @Schema(
                description = "Indicates whether this is the correct answer",
                example = "true"
        )
        Boolean correct
){
}
