package com.exam_service.Exam_Service.dto.response;

public record PublishedExamResponse(  Long examId,
                                      Boolean published,
                                      String message) {
}
