package com.submission_service.Submission_Service.service.impl;

import com.submission_service.Submission_Service.client.ExamServiceClient;
import com.submission_service.Submission_Service.dto.internal.AttemptAnswerResponse;
import com.submission_service.Submission_Service.dto.internal.AttemptDetailResponse;
import com.submission_service.Submission_Service.dto.request.StartExamRequest;
import com.submission_service.Submission_Service.dto.request.SubmitExamRequest;
import com.submission_service.Submission_Service.dto.response.*;
import com.submission_service.Submission_Service.entity.ExamAttempt;
import com.submission_service.Submission_Service.entity.StudentAnswer;
import com.submission_service.Submission_Service.enums.AttemptStatus;
import com.submission_service.Submission_Service.exception.BusinessException;
import com.submission_service.Submission_Service.exception.ResourceNotFoundException;
import com.submission_service.Submission_Service.repository.ExamAttemptRepository;
import com.submission_service.Submission_Service.service.ExamAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExamAttemptServiceImpl implements ExamAttemptService {

    private final ExamAttemptRepository examAttemptRepository;
    private final ExamServiceClient examServiceClient;
    @Override
    public StartExamResponse startExam(StartExamRequest request) {


        ExamResponse exam = examServiceClient.getExamById(request.examId());

        if (!Boolean.TRUE.equals(exam.published())) {
            throw new BusinessException("Exam is  not published");
        }

        ExamAttempt attempt = ExamAttempt.builder()
                .examId(request.examId())
                .studentId(request.studentId())
                .startedAt(Instant.now())
                .status(AttemptStatus.IN_PROGRESS)
                .build();

        ExamAttempt savedAttempt = examAttemptRepository.save(attempt);

        return new StartExamResponse(
                savedAttempt.getId(),
                "Exam started successfully"
        );
    }

    @Transactional
    @Override
    public SubmitExamResponse submitExam(Long attemptId, SubmitExamRequest request) {
        ExamAttempt attempt = examAttemptRepository.findById(attemptId)
                .orElseThrow(() -> new ResourceNotFoundException("Attempt  not found"));

        if (attempt.getStatus() == AttemptStatus.SUBMITTED) {
            throw new BusinessException("Exam is already submitted");
        }

        List<StudentAnswer> answerList = request.answers().stream()
                .map(answerRequest -> StudentAnswer.builder()
                        .questionId(answerRequest.questionId())
                        .selectedOptionId(answerRequest.selectedOptionId())
                        .examAttempt(attempt)
                        .build()
                ).toList();

        attempt.getAnswers().addAll(answerList);
        attempt.setSubmittedAt(Instant.now());
        attempt.setStatus(AttemptStatus.SUBMITTED);
        examAttemptRepository.save(attempt);

        return new SubmitExamResponse(
                attempt.getId(),
                attempt.getStatus().name(),
                "Exam submitted successfully"
        );
    }

    @Override
    @Transactional(readOnly = true)
    public AttemptResponse getAttempt(Long attemptId) {

        ExamAttempt attempt =
                examAttemptRepository.findById(attemptId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Attempt  not found"));

        List<StudentAnswerResponse> answers =
                attempt.getAnswers()
                        .stream()
                        .map(answer ->
                                new StudentAnswerResponse(
                                        answer.getQuestionId(),
                                        answer.getSelectedOptionId()
                                ))
                        .toList();

        return new AttemptResponse(
                attempt.getId(),
                attempt.getExamId(),
                attempt.getStudentId(),
                attempt.getStatus().name(),
                attempt.getStartedAt(),
                attempt.getSubmittedAt(),
                answers
        );

    }

    @Override
    @Transactional(readOnly = true)
    public AttemptDetailResponse getAttemptDetails(Long attemptId) {

        ExamAttempt attempt = examAttemptRepository.findById(attemptId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Attempt not found with id : " + attemptId));

        List<AttemptAnswerResponse> answers = attempt.getAnswers()
                .stream()
                .map(answer -> new AttemptAnswerResponse(
                        answer.getQuestionId(),
                        answer.getSelectedOptionId()
                ))
                .toList();

        return new AttemptDetailResponse(
                attempt.getId(),
                attempt.getExamId(),
                attempt.getStudentId(),
                answers
        );
    }
}
