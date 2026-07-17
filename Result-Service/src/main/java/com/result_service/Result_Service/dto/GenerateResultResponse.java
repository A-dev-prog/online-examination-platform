package com.result_service.Result_Service.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after successfully generating an exam result")
public record GenerateResultResponse(
        @Schema(
                description = "Unique ID of the generated result",
                example = "1"
        )
        Long resultId,

        @Schema(
                description = "Operation status message",
                example = "Result generated successfully"
        )
        String message
) {
}
