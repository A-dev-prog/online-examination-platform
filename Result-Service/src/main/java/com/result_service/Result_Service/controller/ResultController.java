package com.result_service.Result_Service.controller;

import com.result_service.Result_Service.dto.GenerateResultResponse;
import com.result_service.Result_Service.dto.ResultResponse;
import com.result_service.Result_Service.service.ResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Result APIs",
        description = "Generate and retrieve exam results"
)
@Validated
@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;
    @Operation(
            summary = "Generate Result",
            description = "Generates the result for a submitted exam attempt."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Result generated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Attempt not found")
    })
    @PostMapping("/generate/{attemptId}")
    @ResponseStatus(HttpStatus.CREATED)
    public GenerateResultResponse generateResult(
            @Positive(message = "Attempt ID must be greater than 0")
            @PathVariable Long attemptId) {

        return resultService.generateResult(attemptId);
    }
    @Operation(
            summary = "Get Result",
            description = "Returns the details of a generated result."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Result found"),
            @ApiResponse(responseCode = "404", description = "Result not found")
    })
    @GetMapping("/{resultId}")
    public ResponseEntity<ResultResponse> getResult(
            @Positive(message = "Result ID must be greater than 0")
            @PathVariable Long resultId) {

        return ResponseEntity.ok(resultService.getResult(resultId));
    }
    @Operation(
            summary = "Get Student Results",
            description = "Returns all exam results of a student."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Results retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/student/{studentId}")
    public List<ResultResponse> getResultsByStudent(
            @Positive(message = "Student ID must be greater than 0")
            @PathVariable Long studentId) {

        return resultService.getResultsByStudent(studentId);
    }
}
