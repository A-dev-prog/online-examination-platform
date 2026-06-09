package com.exam_service.Exam_Service.dto.request;

import com.exam_service.Exam_Service.entity.QuestionType;

import java.util.List;

public record CreateQuestionRequest(String questionText,
                                    Integer marks,
                                    Integer displayOrder,
                                    QuestionType questionType,
                                    List<CreateAnswerOptionRequest> options) {
}
