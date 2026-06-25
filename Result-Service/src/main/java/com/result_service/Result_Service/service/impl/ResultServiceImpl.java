package com.result_service.Result_Service.service.impl;

import com.result_service.Result_Service.dto.GenerateResultResponse;
import com.result_service.Result_Service.dto.ResultResponse;
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

    @Override
    public GenerateResultResponse generateResult(Long attemptId) {
        Result result = new Result();

        result.setAttemptId(attemptId);

        // Dummy data for now
        result.setStudentId(102L);
        result.setExamId(2L);
        result.setTotalQuestions(10);
        result.setCorrectAnswers(8);
        result.setPercentage(44.0);
        result.setStatus("FAIL");

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
