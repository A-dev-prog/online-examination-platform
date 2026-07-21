package com.exam_service.Exam_Service.service;

import com.exam_service.Exam_Service.dto.internal.ExamAnswerKeyResponse;
import com.exam_service.Exam_Service.dto.request.CreateExamRequest;
import com.exam_service.Exam_Service.dto.request.CreateQuestionRequest;
import com.exam_service.Exam_Service.dto.response.*;
import org.springframework.data.domain.Page;

public interface ExamService {

    CreateExamResponse createExam(CreateExamRequest request);
    QuestionResponse addQuestion(Long examId, CreateQuestionRequest request);

    ExamResponse getExamById(Long examId);

    Page<ExamSummaryResponse> getAllExams(
            int page,
            int size
    );

   PublishedExamResponse publishedExam(Long examId);

   public void deleteExamById(Long examId);

   ExamAnswerKeyResponse getExamAnswerKey(Long examId);
}
