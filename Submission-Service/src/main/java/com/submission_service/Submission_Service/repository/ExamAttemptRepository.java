package com.submission_service.Submission_Service.repository;

import com.submission_service.Submission_Service.entity.ExamAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamAttemptRepository extends JpaRepository<ExamAttempt, Long> {
}
