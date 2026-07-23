import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { ArrowLeft, Clock, FileText, Trophy, Plus } from "lucide-react";
import { getExamById } from "../../../services/examService";
import { Trash2, Pencil,} from "lucide-react";
import { deleteQuestion } from "../../../services/questionService";

export default function ViewExam() {
  const { id } = useParams();

  const navigate = useNavigate();

  const [exam, setExam] = useState(null);

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadExam();
  }, []);

  const loadExam = async () => {
    try {
      const response = await getExamById(id);

      setExam(response);
    } catch (error) {
      console.error(error);

      alert("Failed to load exam");
    } finally {
      setLoading(false);
    }
  };
  const handleDelete = async (questionId) => {

    const confirmed = window.confirm(
        "Delete this question?"
    );

    if (!confirmed) return;

    try {

        await deleteQuestion(questionId);

        loadExam();

    } catch (error) {

        console.error(error);

        alert("Failed to delete question");

    }

};

  if (loading) {
    return <div className="flex justify-center py-20">Loading...</div>;
  }

  return (
    <div className="space-y-6">
      {/* Header */}

      <div className="flex items-center justify-between">
        <button
          onClick={() => navigate("/teacher/exams")}
          className="flex items-center gap-2 text-blue-600 hover:text-blue-800"
        >
          <ArrowLeft size={18} />
          Back
        </button>

        <button
          onClick={() => navigate(`/teacher/exams/${exam.id}/questions/create`)}
          className="flex items-center gap-2 rounded-lg bg-blue-600 px-5 py-2 text-white hover:bg-blue-700"
        >
          <Plus size={18} />
          Add Question
        </button>
      </div>

      {/* Exam Info */}

      <div className="rounded-xl bg-white p-8 shadow">
        <h1 className="text-3xl font-bold">{exam.title}</h1>

        <p className="mt-3 text-gray-600">{exam.description}</p>

        <div className="mt-8 grid grid-cols-3 gap-6">
          <div className="rounded-lg border p-4">
            <div className="flex items-center gap-2">
              <Clock size={18} />

              <span className="font-medium">Duration</span>
            </div>

            <p className="mt-2 text-xl font-bold">{exam.durationMinutes} min</p>
          </div>

          <div className="rounded-lg border p-4">
            <div className="flex items-center gap-2">
              <Trophy size={18} />

              <span className="font-medium">Total Marks</span>
            </div>

            <p className="mt-2 text-xl font-bold">{exam.totalMarks}</p>
          </div>

          <div className="rounded-lg border p-4">
            <div className="flex items-center gap-2">
              <FileText size={18} />

              <span className="font-medium">Status</span>
            </div>

            <p className="mt-2">
              {exam.published ? (
                <span className="rounded-full bg-green-100 px-3 py-1 text-green-700">
                  Published
                </span>
              ) : (
                <span className="rounded-full bg-gray-100 px-3 py-1 text-gray-700">
                  Draft
                </span>
              )}
            </p>
          </div>
        </div>
      </div>

      {/* Questions */}

      <div className="rounded-xl bg-white p-8 shadow">
        <h2 className="mb-6 text-2xl font-bold">Questions</h2>

        {exam.questions.length === 0 ? (
          <div className="py-10 text-center text-gray-500">
            No questions added yet.
          </div>
        ) : (
          exam.questions.map((question) => (
            <div key={question.id} className="mb-8 rounded-lg border p-6">
              <div className="mb-4 flex items-center justify-between">

    <div>

        <h3 className="text-lg font-semibold">

            Q{question.displayOrder}. {question.questionText}

        </h3>

    </div>

    <div className="flex items-center gap-3">

    <button
        onClick={() =>
            navigate(
                `/teacher/exams/${exam.id}/questions/${question.id}/edit`
            )
        }
    >
        <Pencil
            size={18}
            className="text-blue-600 hover:text-blue-800"
        />
    </button>

    <button
        onClick={() => handleDelete(question.id)}
    >
        <Trash2
            size={18}
            className="text-red-600 hover:text-red-800"
        />
    </button>

</div>

</div>

              <div className="space-y-3">
                {question.options.map((option) => (
                  <div
                    key={option.id}
                    className={`rounded-lg border p-3 ${
                      option.correct ? "border-green-500 bg-green-50" : ""
                    }`}
                  >
                    <div className="flex items-center justify-between">
                      <span>{option.optionText}</span>

                      {option.correct && (
                        <span className="font-medium text-green-600">
                          ✓ Correct
                        </span>
                      )}
                    </div>
                  </div>
                ))}
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  );
}
