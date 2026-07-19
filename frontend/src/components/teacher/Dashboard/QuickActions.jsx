import { Plus, FileText } from "lucide-react";
import { useNavigate } from "react-router-dom";

export default function QuickActions() {

    const navigate = useNavigate();

    return (

        <div className="bg-white rounded-xl shadow p-6">

            <h2 className="text-xl font-semibold mb-6">

                Quick Actions

            </h2>

            <div className="flex gap-4">

                <button
                    onClick={() => navigate("/teacher/exams/create")}
                    className="flex items-center gap-2 rounded-lg bg-blue-600 px-5 py-3 text-white hover:bg-blue-700"
                >

                    <Plus size={18} />

                    Create Exam

                </button>

                <button
                    onClick={() => navigate("/teacher/exams")}
                    className="flex items-center gap-2 rounded-lg border px-5 py-3 hover:bg-gray-100"
                >

                    <FileText size={18} />

                    View Exams

                </button>

            </div>

        </div>

    );

}