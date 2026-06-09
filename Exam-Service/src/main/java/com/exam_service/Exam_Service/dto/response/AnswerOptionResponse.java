package com.exam_service.Exam_Service.dto.response;

public record AnswerOptionResponse (Long id,
                                    String optionText,
                                    Boolean correct){
}
