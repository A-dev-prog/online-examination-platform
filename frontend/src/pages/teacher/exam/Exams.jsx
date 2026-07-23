import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Search, Plus, Eye, Pencil, Trash2 } from "lucide-react";

import { getAllExams, deleteExam } from "../../../services/examService";

export default function Exams() {
  const navigate = useNavigate();

  const [exams, setExams] = useState([]);
  const [loading, setLoading] = useState(false);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    loadExams();
  }, [page]);

  const loadExams = async () => {
    try {
      setLoading(true);

      const data = await getAllExams(page);

      setExams(data.content);
      setTotalPages(data.totalPages);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };
  const handleDeleteExam = async (examId) => {
    const confirmed = window.confirm(
      "Are you sure you want to delete this exam?",
    );

    if (!confirmed) return;

    try {
      await deleteExam(examId);

      alert("Exam deleted successfully");

      loadExams(); // refresh list
    } catch (error) {
      console.error(error);

      alert("Failed to delete exam");
    }
  };

  return (
    <div className="space-y-6">
      {/* Header */}

      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold">Exams</h1>

          <p className="text-gray-500">Manage all your examinations</p>
        </div>

        <button
          onClick={() => navigate("/teacher/exams/create")}
          className="flex items-center gap-2 rounded-lg bg-blue-600 px-5 py-2 text-white hover:bg-blue-700"
        >
          <Plus size={18} />
          Create Exam
        </button>
      </div>

      {/* Search */}

      <div className="relative">
        <Search size={18} className="absolute left-3 top-3 text-gray-400" />

        <input
          type="text"
          placeholder="Search exams..."
          className="w-full rounded-lg border py-2 pl-10 pr-4 outline-none focus:border-blue-500"
        />
      </div>

      {/* Table */}

      <div className="overflow-hidden rounded-xl bg-white shadow">
        <table className="w-full">
          <thead className="bg-gray-100">
            <tr>
              <th className="px-6 py-4 text-left">Title</th>

              <th className="px-6 py-4 text-left">Duration</th>

              <th className="px-6 py-4 text-left">Marks</th>

              <th className="px-6 py-4 text-left">Status</th>

              <th className="px-6 py-4 text-left">Actions</th>
            </tr>
          </thead>

          <tbody>
            {loading && (
              <tr>
                <td colSpan="5" className="py-10 text-center">
                  Loading...
                </td>
              </tr>
            )}

            {!loading && exams.length === 0 && (
              <tr>
                <td colSpan="5" className="py-10 text-center text-gray-500">
                  No exams found.
                </td>
              </tr>
            )}

            {!loading &&
              exams.map((exam) => (
                <tr key={exam.id} className="border-t">
                  <td className="px-6 py-4 font-medium">{exam.title}</td>

                  <td className="px-6 py-4">{exam.durationMinutes} min</td>

                  <td className="px-6 py-4">{exam.totalMarks}</td>

                  <td className="px-6 py-4">
                    {exam.published ? (
                      <span className="rounded-full bg-green-100 px-3 py-1 text-sm font-medium text-green-700">
                        Published
                      </span>
                    ) : (
                      <span className="rounded-full bg-gray-100 px-3 py-1 text-sm font-medium text-gray-700">
                        Draft
                      </span>
                    )}
                  </td>

                  <td className="px-6 py-4">
                    <div className="flex gap-4">
                      <button
                        onClick={() => navigate(`/teacher/exams/${exam.id}`)}
                      >
                        <Eye
                          size={18}
                          className="text-blue-600 hover:text-blue-800"
                        />
                      </button>

                      <button>
                        <Pencil
                          size={18}
                          className="text-yellow-600 hover:text-yellow-800"
                        />
                      </button>

                      <button onClick={() => handleDeleteExam(exam.id)}>
                        <Trash2
                          size={18}
                          className="text-red-600 hover:text-red-800"
                        />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
          </tbody>
        </table>
      </div>

      {/* Pagination */}

      <div className="flex items-center justify-between">
        <button
          disabled={page === 0}
          onClick={() => setPage(page - 1)}
          className="rounded-lg border px-4 py-2 disabled:cursor-not-allowed disabled:opacity-50"
        >
          Previous
        </button>

        <span>
          Page {page + 1} of {totalPages}
        </span>

        <button
          disabled={page + 1 >= totalPages}
          onClick={() => setPage(page + 1)}
          className="rounded-lg border px-4 py-2 disabled:cursor-not-allowed disabled:opacity-50"
        >
          Next
        </button>
      </div>
    </div>
  );
}
