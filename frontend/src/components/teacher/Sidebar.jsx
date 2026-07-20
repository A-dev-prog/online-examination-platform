import {
  LayoutDashboard,
  User,
  FileText,
  ClipboardList,
  BarChart3,
  BookOpen,
  LogOut,
} from "lucide-react";

import { NavLink, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";

export default function Sidebar() {
  const { logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();

    navigate("/login");
  };

  const navLinkClass = ({ isActive }) =>
    `flex items-center gap-3 rounded-lg px-4 py-3 transition-all duration-200
        ${
          isActive
            ? "bg-blue-600 text-white shadow"
            : "text-gray-700 hover:bg-blue-100 hover:text-blue-600"
        }`;

  return (
    <aside className="flex h-screen w-64 flex-col bg-white shadow-lg">
      {/* Logo */}

      <div className="border-b p-6">
        <h1 className="text-2xl font-bold text-blue-600">Exam Portal</h1>
      </div>

      {/* Navigation */}

      <nav className="flex-1 space-y-2 p-4">
        <NavLink to="/teacher/dashboard" className={navLinkClass}>
          <LayoutDashboard size={20} />
          Dashboard
        </NavLink>

        <NavLink to="/teacher/profile" className={navLinkClass}>
          <User size={20} />
          Profile
        </NavLink>

        <hr className="my-4" />

        {/* Placeholder Links */}

        <NavLink to="/teacher/exams" className={navLinkClass}>
          <BookOpen size={20} />
          Exams
        </NavLink>

        <button
          disabled
          className="flex w-full items-center gap-3 rounded-lg px-4 py-3 text-left text-gray-400"
        >
          <ClipboardList size={20} />
          Submissions
        </button>

        <button
          disabled
          className="flex w-full items-center gap-3 rounded-lg px-4 py-3 text-left text-gray-400"
        >
          <BarChart3 size={20} />
          Results
        </button>
      </nav>
    </aside>
  );
}
