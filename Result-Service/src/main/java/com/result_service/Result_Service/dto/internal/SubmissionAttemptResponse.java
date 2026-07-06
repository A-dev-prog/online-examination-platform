package com.result_service.Result_Service.dto.internal;

import java.util.List;

public record SubmissionAttemptResponse(Long attemptId,

                                        Long examId,

                                        Long studentId,

                                        List<SubmissionAnswerResponse> answers) {


}
