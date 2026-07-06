package com.result_service.Result_Service.dto.internal;

import java.util.List;

public record ExamAnswerKeyResponse (Long examId,

                                     List<QuestionAnswerKeyResponse> questions){
}
