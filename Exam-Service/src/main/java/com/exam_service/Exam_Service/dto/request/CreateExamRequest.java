package com.exam_service.Exam_Service.dto.request;

import java.util.List;

public record CreateExamRequest(String title,
                                String description,
                                Integer durationMinutes,
                                Integer totalMarks,
                                Long createdBy,
                                List<CreateQuestionRequest> questions) {
}
