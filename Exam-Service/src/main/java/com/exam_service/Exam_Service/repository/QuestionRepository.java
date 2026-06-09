package com.exam_service.Exam_Service.repository;

import com.exam_service.Exam_Service.entity.AnswerOption;
import com.exam_service.Exam_Service.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
