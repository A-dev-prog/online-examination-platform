package com.result_service.Result_Service.client;

import com.result_service.Result_Service.dto.internal.ExamAnswerKeyResponse;
import com.result_service.Result_Service.dto.internal.SubmissionAttemptResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EXAM-SERVICE")
public interface ExamServiceClient {


        @GetMapping("/api/exams/internal/{examId}/answer-key")
        ExamAnswerKeyResponse getAnswerKey(
                @PathVariable Long examId
        );


}
