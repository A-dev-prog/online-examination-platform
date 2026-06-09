package com.exam_service.Exam_Service.dto.request;

public record CreateAnswerOptionRequest(String optionText,
                                        Boolean correct) {
}
