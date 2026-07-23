import api from "../api/axios";

export const addQuestion = async (examId, question) => {
  const response = await api.post(`/api/exams/${examId}/questions`, question);

  return response.data;
};

export const getQuestion = async (questionId) => {
  const response = await api.get(`/api/exams/questions/${questionId}`);

  return response.data;
};

export const updateQuestion = async (questionId, payload) => {
  const response = await api.put(`/api/exams/questions/${questionId}`, payload);

  return response.data;
};

export const deleteQuestion = async (questionId) => {
  await api.delete(`/api/exams/questions/${questionId}`);
};
