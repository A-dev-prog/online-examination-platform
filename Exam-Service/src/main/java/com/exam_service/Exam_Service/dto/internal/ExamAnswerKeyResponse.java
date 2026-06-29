package com.exam_service.Exam_Service.dto.internal;

import java.util.List;

public record ExamAnswerKeyResponse(
        Long examId,
        List<QuestionAnswerKeyResponse> questions
) {
}
