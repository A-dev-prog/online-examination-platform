package com.exam_service.Exam_Service.repository;

import com.exam_service.Exam_Service.entity.AnswerOption;
import com.exam_service.Exam_Service.entity.Exam;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, Long> {



}
