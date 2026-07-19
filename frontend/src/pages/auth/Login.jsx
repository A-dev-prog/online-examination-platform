import { useForm } from "react-hook-form";
import { useAuth } from "../../context/AuthContext";
import { useNavigate } from "react-router-dom";

export default function Login() {

    const { login } = useAuth();
const navigate = useNavigate();

    const {
        register,
        handleSubmit,
    } = useForm();

    const onSubmit = async (data) => {

    try {

        const user = await login(data);

      

        if (user.role === "ROLE_TEACHER") {
            navigate("/teacher/dashboard");
        } else if (user.role === "ROLE_STUDENT") {
            navigate("/student/dashboard");
        }

    } catch (error) {

        console.log(error);

        alert("Invalid Email or Password");
    }
};

    return (
        <div
            style={{
                display: "flex",
                justifyContent: "center",
                marginTop: "100px"
            }}
        >
            <form
                onSubmit={handleSubmit(onSubmit)}
                style={{
                    display: "flex",
                    flexDirection: "column",
                    width: "300px",
                    gap: "15px"
                }}
            >
                <h2>Login</h2>

                <input
                    type="email"
                    placeholder="Email"
                    {...register("email")}
                />

                <input
                    type="password"
                    placeholder="Password"
                    {...register("password")}
                />

                <button type="submit">
                    Login
                </button>

            </form>
        </div>
    );
}