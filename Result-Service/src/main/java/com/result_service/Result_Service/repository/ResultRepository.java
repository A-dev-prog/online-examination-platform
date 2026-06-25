package com.result_service.Result_Service.repository;

import com.result_service.Result_Service.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Long> {

   List<Result> findByStudentId(Long studentId);
}
