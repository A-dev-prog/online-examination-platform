package com.submission_service.Submission_Service.dto.request;

import java.util.List;

public record SubmitExamRequest(List<StudentAnswerRequest> answers) {
}
