package com.submission_service.Submission_Service.dto.internal;

import java.util.List;

public record AttemptDetailResponse(
        Long attemptId,

        Long examId,

        Long studentId,

        List<AttemptAnswerResponse> answers
) {
}
