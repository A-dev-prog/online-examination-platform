package com.submission_service.Submission_Service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after submitting an exam")
public record SubmitExamResponse(@Schema(
        description = "Unique ID of the exam attempt",
        example = "1"
)
                                 Long attemptId,

                                 @Schema(
                                         description = "Current status of the exam attempt",
                                         example = "SUBMITTED"
                                 )
                                 String status,

                                 @Schema(
                                         description = "Operation status message",
                                         example = "Exam submitted successfully"
                                 )
                                 String message
) {
}
