package com.exam_service.Exam_Service.dto.response;

import java.util.List;

public record ExamResponse(Long id,
                           String title,
                           String description,
                           Integer durationMinutes,
                           Integer totalMarks,
                           Boolean published,
                           Long createdBy,
                           List<QuestionResponse> questions) {
}
