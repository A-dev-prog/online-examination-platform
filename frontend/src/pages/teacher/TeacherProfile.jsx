import { User, Mail, ShieldCheck, CircleCheck } from "lucide-react";
import { useAuth } from "../../context/AuthContext";

export default function Profile() {

    const { user } = useAuth();

    return (

        <div className="max-w-4xl mx-auto">

            <div className="bg-white rounded-xl shadow">

                <div className="p-8 border-b">

                    <h1 className="text-3xl font-bold">

                        Teacher Profile

                    </h1>

                    <p className="text-gray-500 mt-2">

                        Your account information

                    </p>

                </div>

                <div className="p-8">

                    <div className="flex items-center gap-6 mb-10">

                        <div className="h-24 w-24 rounded-full bg-blue-600 text-white flex items-center justify-center text-4xl font-bold">

                            {user?.username?.charAt(0).toUpperCase()}

                        </div>

                        <div>

                            <h2 className="text-2xl font-bold">

                                {user?.username}

                            </h2>

                            <p className="text-gray-500">

                                {user?.email}

                            </p>

                        </div>

                    </div>

                    <div className="grid md:grid-cols-2 gap-6">

                        <InfoCard
                            icon={<User size={20} />}
                            title="Username"
                            value={user?.username}
                        />

                        <InfoCard
                            icon={<Mail size={20} />}
                            title="Email"
                            value={user?.email}
                        />

                        <InfoCard
                            icon={<ShieldCheck size={20} />}
                            title="Role"
                            value={user?.role}
                        />

                        <InfoCard
                            icon={<CircleCheck size={20} />}
                            title="Status"
                            value="Active"
                        />

                    </div>

                </div>

            </div>

        </div>

    );

}

function InfoCard({ icon, title, value }) {

    return (

        <div className="border rounded-lg p-5 flex gap-4 items-center">

            <div className="text-blue-600">

                {icon}

            </div>

            <div>

                <p className="text-gray-500 text-sm">

                    {title}

                </p>

                <p className="font-semibold">

                    {value}

                </p>

            </div>

        </div>

    );

}