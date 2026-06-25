package com.result_service.Result_Service.service;

import com.result_service.Result_Service.dto.GenerateResultResponse;
import com.result_service.Result_Service.dto.ResultResponse;

import java.util.List;

public interface ResultService {

   GenerateResultResponse generateResult(Long attemptId);
   ResultResponse getResult(Long resultId);
  List<ResultResponse> getResultsByStudent(Long studentId);
}
