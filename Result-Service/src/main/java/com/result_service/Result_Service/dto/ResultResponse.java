package com.result_service.Result_Service.dto;

public record ResultResponse(
        Long id,
        Long attemptId,
        Long studentId,
        Long examId,
        Integer totalQuestions,
        Integer correctAnswers,
        Double percentage,
        String status
) {
}
