package com.submission_service.Submission_Service.service;

import com.submission_service.Submission_Service.dto.request.StartExamRequest;
import com.submission_service.Submission_Service.dto.request.SubmitExamRequest;
import com.submission_service.Submission_Service.dto.response.AttemptResponse;
import com.submission_service.Submission_Service.dto.response.StartExamResponse;
import com.submission_service.Submission_Service.dto.response.SubmitExamResponse;

public interface ExamAttemptService {

    StartExamResponse startExam(StartExamRequest request);

    SubmitExamResponse submitExam(Long attemptId , SubmitExamRequest request);

    AttemptResponse getAttempt(Long attemptId);
}
