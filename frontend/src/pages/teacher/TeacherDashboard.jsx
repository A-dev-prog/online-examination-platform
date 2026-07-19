import {
    BookOpen,
    ClipboardCheck,
    FileText,
    Users,
} from "lucide-react";

import StatCard from "../../components/teacher/Dashboard/StatCard";
import QuickActions from "../../components/teacher/Dashboard/QuickActions";
import RecentActivity from "../../components/teacher/Dashboard/RecentActivity";

export default function TeacherDashboard() {

    return (

        <div className="space-y-8">

            <div>

                <h1 className="text-3xl font-bold">

                    Good Morning 👋

                </h1>

                <p className="text-gray-500 mt-2">

                    Welcome back. Manage your examinations efficiently.

                </p>

            </div>

            <div
                className="grid gap-6 sm:grid-cols-2 xl:grid-cols-4"
            >

                <StatCard
                    title="Total Exams"
                    value="0"
                    icon={<BookOpen size={24} />}
                    bgColor="bg-blue-500"
                />

                <StatCard
                    title="Published Exams"
                    value="0"
                    icon={<ClipboardCheck size={24} />}
                    bgColor="bg-green-500"
                />

                <StatCard
                    title="Draft Exams"
                    value="0"
                    icon={<FileText size={24} />}
                    bgColor="bg-yellow-500"
                />

                <StatCard
                    title="Total Attempts"
                    value="0"
                    icon={<Users size={24} />}
                    bgColor="bg-purple-500"
                />

            </div>

            <QuickActions />

            <RecentActivity />

        </div>

    );

}