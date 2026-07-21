import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { createExam } from "../../../services/examService";

export default function CreateExam() {

    const navigate = useNavigate();

    const {
        register,
        handleSubmit,
        formState: { errors, isSubmitting }
    } = useForm();

    const onSubmit = async (data) => {

    try {

        const payload = {

            title: data.title,

            description: data.description,

            durationMinutes: Number(data.durationMinutes),

            totalMarks: Number(data.totalMarks),

            createdBy: 1,      // Temporary

            questions: []

        };

        const response = await createExam(payload);

        alert(response.message);

        navigate("/teacher/exams");

    } catch (error) {

        console.error(error);

        alert("Failed to create exam");

    }

};

    return (

        <div className="mx-auto max-w-3xl rounded-xl bg-white p-8 shadow">

            <h1 className="mb-8 text-3xl font-bold">

                Create New Exam

            </h1>

            <form
                onSubmit={handleSubmit(onSubmit)}
                className="space-y-6"
            >

                <div>

                    <label className="mb-2 block font-medium">

                        Title

                    </label>

                    <input
                        {...register("title", {
                            required: "Title is required"
                        })}
                        className="w-full rounded-lg border p-3"
                    />

                    {errors.title && (

                        <p className="mt-1 text-sm text-red-500">

                            {errors.title.message}

                        </p>

                    )}

                </div>

                <div>

                    <label className="mb-2 block font-medium">

                        Description

                    </label>

                    <textarea
                        rows={4}
                        {...register("description")}
                        className="w-full rounded-lg border p-3"
                    />

                </div>

                <div className="grid grid-cols-2 gap-6">

                    <div>

                        <label className="mb-2 block font-medium">

                            Duration (minutes)

                        </label>

                        <input
                            type="number"
                            {...register("durationMinutes")}
                            className="w-full rounded-lg border p-3"
                        />

                    </div>

                    <div>

                        <label className="mb-2 block font-medium">

                            Total Marks

                        </label>

                        <input
                            type="number"
                            {...register("totalMarks")}
                            className="w-full rounded-lg border p-3"
                        />

                    </div>

                </div>

                <div className="flex gap-4">

                    <button
                        type="submit"
                        disabled={isSubmitting}
                        className="rounded-lg bg-blue-600 px-6 py-3 text-white hover:bg-blue-700"
                    >

                        {isSubmitting
                            ? "Creating..."
                            : "Create Exam"}

                    </button>

                    <button
                        type="button"
                        onClick={() => navigate("/teacher/exams")}
                        className="rounded-lg border px-6 py-3"
                    >

                        Cancel

                    </button>

                </div>

            </form>

        </div>

    );

}