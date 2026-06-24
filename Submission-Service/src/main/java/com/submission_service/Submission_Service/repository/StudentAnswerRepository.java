package com.submission_service.Submission_Service.repository;

import com.submission_service.Submission_Service.entity.ExamAttempt;
import com.submission_service.Submission_Service.entity.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {
}
