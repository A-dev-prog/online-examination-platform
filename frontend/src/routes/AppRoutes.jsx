import { Routes, Route, Navigate } from "react-router-dom";

import Login from "../pages/auth/Login";
import TeacherDashboard from "../pages/teacher/TeacherDashboard";
import StudentDashboard from "../pages/student/StudentDashboard";
import PrivateRoute from "../pages/auth/PrivateRoute";
import RoleRoute from "../pages/auth/RoleRoute";
import Unauthorized from "../pages/Unauthorized";
import TeacherLayout from "../components/teacher/TeacherLayout";
import TeacherProfile from "../pages/teacher/TeacherProfile";
import Exams from "../pages/teacher/exam/Exams";
import CreateExam from "../pages/teacher/exam/CreateExam";
import ViewExam from "../pages/teacher/exam/ViewExam";
import AddQuestion from "../pages/teacher/exam/AddQuestion";

export default function AppRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" replace />} />

      <Route path="/login" element={<Login />} />
      <Route path="/unauthorized" element={<Unauthorized />} />

      <Route
        path="/teacher"
        element={
          <PrivateRoute>
            <RoleRoute allowedRole="ROLE_TEACHER">
              <TeacherLayout />
            </RoleRoute>
          </PrivateRoute>
        }
      >
        <Route path="dashboard" element={<TeacherDashboard />} />

        <Route path="profile" element={<TeacherProfile />} />
        <Route path="exams" element={<Exams />} />
        <Route path="exams/create" element={<CreateExam />} />
        <Route path="exams/:id" element={<ViewExam />} />
        <Route path="exams/:id/questions/create" element={<AddQuestion />} />
      </Route>

      <Route
        path="/student/dashboard"
        element={
          <RoleRoute allowedRole="ROLE_STUDENT">
            <StudentDashboard />
          </RoleRoute>
        }
      />
    </Routes>
  );
}
