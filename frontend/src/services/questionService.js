import api from "../api/axios";

export const addQuestion = async (examId, question) => {

    const response = await api.post(
        `/api/exams/${examId}/questions`,
        question
    );

    return response.data;

};