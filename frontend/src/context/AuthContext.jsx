import { createContext, useContext, useEffect, useState } from "react";
import { jwtDecode } from "jwt-decode";
import { login as loginService, getCurrentUser } from "../services/authService";
import { saveToken, getToken, removeToken } from "../utils/token";


const AuthContext = createContext();

export function AuthProvider({ children }) {

    const [loading, setLoading] = useState(true);

    const [user, setUser] = useState(null);

   useEffect(() => {

    const loadUser = async () => {

        const token = getToken();

        if (!token) {
            setLoading(false);
            return;
        }

        try {

            const currentUser = await getCurrentUser();

            setUser(currentUser);

        } catch (error) {

            removeToken();
            setUser(null);

        } finally {

            setLoading(false);

        }

    };

    loadUser();

}, []);

    const login = async (credentials) => {

    const response = await loginService(credentials);

    saveToken(response.accessToken);

    const currentUser = await getCurrentUser();

    setUser(currentUser);

    setLoading(false);

    return currentUser;   

};

    const logout = () => {

        removeToken();
        setUser(null);
    };

    return (
        <AuthContext.Provider
            value={{
                user,
                login,
                logout,
                loading,
                isAuthenticated: !!user
            }}
        >
            {children}
        </AuthContext.Provider>
    );
}

export function useAuth() {
    return useContext(AuthContext);
}