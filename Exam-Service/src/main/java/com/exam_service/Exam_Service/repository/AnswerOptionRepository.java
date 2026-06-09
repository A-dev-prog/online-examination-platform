package com.exam_service.Exam_Service.repository;

import com.exam_service.Exam_Service.entity.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
}
