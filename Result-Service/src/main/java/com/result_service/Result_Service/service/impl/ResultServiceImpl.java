package com.result_service.Result_Service.service.impl;

import com.result_service.Result_Service.client.ExamServiceClient;
import com.result_service.Result_Service.client.SubmissionServiceClient;
import com.result_service.Result_Service.dto.GenerateResultResponse;
import com.result_service.Result_Service.dto.ResultResponse;
import com.result_service.Result_Service.dto.internal.ExamAnswerKeyResponse;
import com.result_service.Result_Service.dto.internal.QuestionAnswerKeyResponse;
import com.result_service.Result_Service.dto.internal.SubmissionAnswerResponse;
import com.result_service.Result_Service.dto.internal.SubmissionAttemptResponse;
import com.result_service.Result_Service.entity.Result;
import com.result_service.Result_Service.repository.ResultRepository;
import com.result_service.Result_Service.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;
    private final SubmissionServiceClient submissionServiceClient;

    private final ExamServiceClient examServiceClient;

    @Override
    public GenerateResultResponse generateResult(Long attemptId) {

        // Get student's submitted answers
        SubmissionAttemptResponse attempt =
                submissionServiceClient.getAttemptDetails(attemptId);

        // Get exam answer key
        ExamAnswerKeyResponse answerKey =
                examServiceClient.getAnswerKey(attempt.examId());

        // Total questions in the exam
        int totalQuestions = answerKey.questions().size();

        // Count correct answers
        int correctAnswers = 0;

        for (SubmissionAnswerResponse studentAnswer : attempt.answers()) {

            for (QuestionAnswerKeyResponse question : answerKey.questions()) {

                if (studentAnswer.questionId().equals(question.questionId())) {

                    if (studentAnswer.selectedOptionId()
                            .equals(question.correctOptionId())) {

                        correctAnswers++;
                    }

                    break;
                }
            }
        }

        // Calculate percentage
        double percentage = totalQuestions == 0
                ? 0
                : (correctAnswers * 100.0) / totalQuestions;

        // Decide pass/fail
        String status = percentage >= 40 ? "PASS" : "FAIL";

        // Save result
        Result result = new Result();

        result.setAttemptId(attempt.attemptId());
        result.setStudentId(attempt.studentId());
        result.setExamId(attempt.examId());

        result.setTotalQuestions(totalQuestions);
        result.setCorrectAnswers(correctAnswers);
        result.setPercentage(percentage);
        result.setStatus(status);

        Result savedResult = resultRepository.save(result);

        return new GenerateResultResponse(
                savedResult.getId(),
                "Result generated successfully"
        );
    }

    @Override
    public ResultResponse getResult(Long resultId) {
        Result result = resultRepository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        return new ResultResponse(
                result.getId(),
                result.getAttemptId(),
                result.getStudentId(),
                result.getExamId(),
                result.getTotalQuestions(),
                result.getCorrectAnswers(),
                result.getPercentage(),
                result.getStatus()
        );
    }

    @Override
    public List<ResultResponse> getResultsByStudent(Long studentId) {
        List<Result> allResults = resultRepository.findByStudentId(studentId);

        return allResults.stream()
                .map(result -> new ResultResponse(
                        result.getId(),
                        result.getAttemptId(),
                        result.getStudentId(),
                        result.getExamId(),
                        result.getTotalQuestions(),
                        result.getCorrectAnswers(),
                        result.getPercentage(),
                        result.getStatus()
                ))
                .toList();
    }

}
