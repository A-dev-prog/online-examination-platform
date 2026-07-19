import api from "../api/axios";

export const login = async (loginRequest) => {

    console.log("Before API call");

    const response = await api.post(
        "/api/auth/login",
        loginRequest
    );

    console.log("After API call");

    return response.data;
};

export const register = async (registerRequest) => {

    const response = await api.post(
        "/api/auth/register",
        registerRequest
    );

    return response.data;
};

export const getCurrentUser = async () => {

    const response = await api.get(
        "/api/auth/me"
    );

    return response.data;
};