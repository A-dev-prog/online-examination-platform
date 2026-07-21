package com.exam_service.Exam_Service.service.impl;

import com.exam_service.Exam_Service.dto.internal.ExamAnswerKeyResponse;
import com.exam_service.Exam_Service.dto.internal.QuestionAnswerKeyResponse;
import com.exam_service.Exam_Service.dto.request.CreateExamRequest;
import com.exam_service.Exam_Service.dto.request.CreateQuestionRequest;
import com.exam_service.Exam_Service.dto.response.*;
import com.exam_service.Exam_Service.entity.AnswerOption;
import com.exam_service.Exam_Service.entity.Exam;
import com.exam_service.Exam_Service.entity.Question;
import com.exam_service.Exam_Service.entity.QuestionType;
import com.exam_service.Exam_Service.exception.BusinessException;
import com.exam_service.Exam_Service.exception.ResourceNotFoundException;
import com.exam_service.Exam_Service.repository.ExamRepository;
import com.exam_service.Exam_Service.repository.QuestionRepository;
import com.exam_service.Exam_Service.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;


    public CreateExamResponse createExam(CreateExamRequest request) {

        validateExam(request);

        Exam exam = Exam.builder()
                .title(request.title())
                .description(request.description())
                .durationMinutes(request.durationMinutes())
                .totalMarks(request.totalMarks())
                .createdBy(request.createdBy())
                .published(false)
                .build();
        
        Exam saved = examRepository.save(exam);

        return new CreateExamResponse(
                saved.getId(),
                "Exam created Successfully"
        );

    }

    @Override
    @Transactional
    public QuestionResponse addQuestion(Long examId, CreateQuestionRequest request) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Exam not found"));

        Question question = Question.builder()
                .questionText(request.questionText())
                .marks(request.marks())
                .displayOrder(request.displayOrder())
                .questionType(request.questionType())
                .exam(exam)
                .build();

        List<AnswerOption> options = request.options()
                .stream()
                .map(optionRequest -> {

                    AnswerOption option = AnswerOption.builder()
                            .optionText(optionRequest.optionText())
                            .correct(optionRequest.correct())
                            .question(question)
                            .build();

                    return option;

                })
                .toList();

        question.setOptions(options);

        exam.getQuestions().add(question);

        examRepository.save(exam);

        Question savedQuestion = exam.getQuestions()
                .get(exam.getQuestions().size() - 1);

        return mapToQuestionResponse(savedQuestion);
    }

    private QuestionResponse mapToQuestionResponse(Question question) {

        List<AnswerOptionResponse> options = question.getOptions()
                .stream()
                .map(option ->
                        new AnswerOptionResponse(
                                option.getId(),
                                option.getOptionText(),
                                option.isCorrect()
                        )
                )
                .toList();

        return new QuestionResponse(
                question.getId(),
                question.getQuestionText(),
                question.getMarks(),
                question.getDisplayOrder(),
                question.getQuestionType().name(),
                options
        );
    }


    private void validateExam(CreateExamRequest request) {

//        if(request.questions() == null || request.questions().isEmpty()){
//            throw  new BusinessException("Exam must have at least one question");
//        }

        request.questions().forEach(this ::validateExam);
    }

    private void validateExam(CreateQuestionRequest question) {

        if (question.options() == null ||
                question.options().size() < 2) {

            throw new BusinessException(
                    "Question must contain at least two options"
            );
        }

        long correctAnswer = question.options().stream()
                .filter(option -> Boolean.TRUE.equals(option.correct()))
                .count();

        if(question.questionType()== QuestionType.SINGLE_CHOICE && correctAnswer != 1)
        {
            throw new BusinessException( "Single choice question must have exactly one correct answer");
        }

        if (question.questionType() == QuestionType.MULTIPLE_CHOICE && correctAnswer < 1)
        {
            throw new BusinessException("Multiple choice question must have exactly one correct answer");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ExamResponse getExamById(Long examId) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + examId));

        return new ExamResponse(
                exam.getId(),
                exam.getTitle(),
                exam.getDescription(),
                exam.getDurationMinutes(),
                exam.getTotalMarks(),
                exam.getPublished(),
                exam.getCreatedBy(),

                exam.getQuestions()
                        .stream()
                        .map(question ->
                                new QuestionResponse(
                                        question.getId(),
                                        question.getQuestionText(),
                                        question.getMarks(),
                                        question.getDisplayOrder(),
                                        question.getQuestionType().name(),

                                        question.getOptions()
                                                .stream()
                                                .map(option -> new AnswerOptionResponse(
                                                        option.getId(),
                                                        option.getOptionText(),
                                                        option.isCorrect()
                                                )).toList()
                                )).toList()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ExamSummaryResponse> getAllExams(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return examRepository.findAll(pageable)
                .map(exam -> new ExamSummaryResponse(
                        exam.getId(),
                        exam.getTitle(),
                        exam.getDurationMinutes(),
                        exam.getTotalMarks(),
                        exam.getPublished()
                ));

    }

    @Override
    @Transactional
    public PublishedExamResponse publishedExam(Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() ->new ResourceNotFoundException("Exam not found with id " + examId));

        exam.setPublished(true);

        return new  PublishedExamResponse(
                exam.getId(),
                exam.getPublished(),
                "Exam Published Successfully"
        );
    }

    @Override
    public void deleteExamById(Long examId) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() ->new ResourceNotFoundException("Exam not found with id " + examId));

        examRepository.delete(exam);

    }

    @Override
    public ExamAnswerKeyResponse getExamAnswerKey(Long examId) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + examId));

        List<QuestionAnswerKeyResponse> questions = exam.getQuestions()
                .stream()
                .map(question -> {
                          Long correctOptionId =  question.getOptions()
                                    .stream()
                                    .filter(answerOption -> answerOption.isCorrect())
                                    .findFirst()
                                    .orElseThrow(() -> new RuntimeException("Correct option is not found"))
                                    .getId();

                            return new QuestionAnswerKeyResponse(
                                    question.getId(),
                                    correctOptionId
                            );


                        }
                ).toList();

        return new ExamAnswerKeyResponse(
                exam.getId(),
                questions
        );
    }


}
