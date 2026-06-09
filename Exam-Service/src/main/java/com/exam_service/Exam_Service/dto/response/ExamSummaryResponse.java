package com.exam_service.Exam_Service.dto.response;

public record ExamSummaryResponse( Long id,
                                   String title,
                                   Integer durationMinutes,
                                   Integer totalMarks,
                                   Boolean published) {
}
