import { useForm } from "react-hook-form";
import { useNavigate, useParams } from "react-router-dom";
import { addQuestion } from "../../../services/questionService";

export default function AddQuestion() {

    const { id } = useParams();

    const navigate = useNavigate();

    const {

        register,

        handleSubmit,

        formState: { isSubmitting }

    } = useForm();

    const onSubmit = async (data) => {

        try {

            const payload = {

                questionText: data.questionText,

                marks: Number(data.marks),

                displayOrder: Number(data.displayOrder),

                questionType: "SINGLE_CHOICE",

                options: [

                    {
                        optionText: data.option1,
                        correct: data.correctOption === "1"
                    },

                    {
                        optionText: data.option2,
                        correct: data.correctOption === "2"
                    },

                    {
                        optionText: data.option3,
                        correct: data.correctOption === "3"
                    },

                    {
                        optionText: data.option4,
                        correct: data.correctOption === "4"
                    }

                ]

            };

            await addQuestion(id, payload);

            alert("Question Added Successfully");

            navigate(`/teacher/exams/${id}`);

        } catch (error) {

            console.error(error);

            alert("Failed to add question");

        }

    };

    return (

        <div className="mx-auto max-w-4xl rounded-xl bg-white p-8 shadow">

            <h1 className="mb-8 text-3xl font-bold">

                Add Question

            </h1>

            <form
                onSubmit={handleSubmit(onSubmit)}
                className="space-y-6"
            >

                <div>

                    <label>Question</label>

                    <textarea

                        rows="3"

                        {...register("questionText")}

                        className="mt-2 w-full rounded-lg border p-3"

                    />

                </div>

                <div className="grid grid-cols-2 gap-6">

                    <div>

                        <label>Marks</label>

                        <input
                            type="number"
                            {...register("marks")}
                            className="mt-2 w-full rounded-lg border p-3"
                        />

                    </div>

                    <div>

                        <label>Display Order</label>

                        <input
                            type="number"
                            {...register("displayOrder")}
                            className="mt-2 w-full rounded-lg border p-3"
                        />

                    </div>

                </div>

                <hr />

                <h2 className="text-xl font-semibold">

                    Options

                </h2>

                {[1,2,3,4].map((number)=>(
                    <div
                        key={number}
                        className="flex items-center gap-4"
                    >

                        <input
                            type="radio"
                            value={number}
                            {...register("correctOption")}
                        />

                        <input

                            placeholder={`Option ${number}`}

                            {...register(`option${number}`)}

                            className="flex-1 rounded-lg border p-3"

                        />

                    </div>
                ))}

                <div className="flex gap-4">

                    <button

                        type="submit"

                        disabled={isSubmitting}

                        className="rounded-lg bg-blue-600 px-6 py-3 text-white"

                    >

                        Save Question

                    </button>

                    <button

                        type="button"

                        onClick={() => navigate(`/teacher/exams/${id}`)}

                        className="rounded-lg border px-6 py-3"

                    >

                        Cancel

                    </button>

                </div>

            </form>

        </div>

    );

}