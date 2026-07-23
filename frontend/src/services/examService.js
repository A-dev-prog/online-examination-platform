import api from "../api/axios";

export const getAllExams = async (page = 0, size = 10) => {
  const response = await api.get("/api/exams", {
    params: {
      page,
      size,
    },
  });

  return response.data;
};

export const createExam = async (examData) => {
  const response = await api.post("/api/exams", examData);

  return response.data;
};

export const getExamById = async (id) => {
  const response = await api.get(`/api/exams/${id}`);

  return response.data;
};

export const deleteExam = async (examId) => {
  await api.delete(`/api/exams/${examId}`);
};
