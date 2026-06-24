package com.submission_service.Submission_Service.dto.response;

import java.time.Instant;
import java.util.List;

public record AttemptResponse(Long attemptId,
                              Long examId,
                              Long studentId,
                              String status,
                              Instant startedAt,
                              Instant submittedAt,
                              List<StudentAnswerResponse> answers) {
}
