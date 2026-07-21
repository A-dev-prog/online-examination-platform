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
