import { Link } from "react-router-dom";

export default function Unauthorized() {

    return (
        <div
            style={{
                textAlign: "center",
                marginTop: "100px",
            }}
        >
            <h1>403</h1>

            <h2>Access Denied</h2>

            <Link to="/">
                Go Home
            </Link>
        </div>
    );
}