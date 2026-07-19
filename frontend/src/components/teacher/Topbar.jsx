import {
    Bell,
    ChevronDown,
    UserCircle2,
    LogOut
} from "lucide-react";

import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";

export default function Topbar() {

   const { logout, user } = useAuth();
    const navigate = useNavigate();

    const [open, setOpen] = useState(false);

    const handleLogout = () => {

        logout();

        navigate("/login");

    };

    return (

        <header className="bg-white shadow">

            <div className="flex items-center justify-between px-8 py-4">

                <div>

                    <h1 className="text-2xl font-bold">

                        Teacher Dashboard

                    </h1>

                    <p className="text-sm text-gray-500">

                        Welcome back, Teacher

                    </p>

                </div>

                <div className="flex items-center gap-6">

                    <button className="rounded-full p-2 hover:bg-gray-100">

                        <Bell size={22} />

                    </button>

                    <div className="relative">

                        <button
                            onClick={() => setOpen(!open)}
                            className="flex items-center gap-3 rounded-lg px-3 py-2 hover:bg-gray-100"
                        >

                            <UserCircle2
                                size={36}
                                className="text-blue-600"
                            />

                            <div className="text-left">

                                <p className="font-semibold">

                                    {user?.username}

                                </p>

                                <p className="text-xs text-gray-500">

                                    {user?.role}

                                </p>

                            </div>

                            <ChevronDown size={18} />

                        </button>

                        {
                            open && (

                                <div
                                    className="absolute right-0 mt-3 w-44 rounded-lg bg-white shadow-lg"
                                >

                                    <button
                                        onClick={handleLogout}
                                        className="flex w-full items-center gap-2 rounded-lg px-4 py-3 text-red-600 hover:bg-red-100"
                                    >

                                        <LogOut size={18} />

                                        Logout

                                    </button>

                                </div>

                            )
                        }

                    </div>

                </div>

            </div>

        </header>

    );

}