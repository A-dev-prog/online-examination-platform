package com.exam_service.Exam_Service.dto.response;

import java.util.List;

public record QuestionResponse(Long id,
                               String questionText,
                               Integer marks,
                               Integer displayOrder,
                               String questionType,
                               List<AnswerOptionResponse> options) {
}
