package com.submission_service.Submission_Service.dto.response;

public record SubmitExamResponse(Long attemptId,
                                 String status,
                                 String message) {
}
