export default function StatCard({
    title,
    value,
    icon,
    bgColor = "bg-blue-500",
}) {

    return (

        <div
            className="bg-white rounded-xl shadow p-6 flex justify-between items-center hover:shadow-lg transition"
        >

            <div>

                <p className="text-gray-500 text-sm">

                    {title}

                </p>

                <h2 className="text-3xl font-bold mt-2">

                    {value}

                </h2>

            </div>

            <div
                className={`${bgColor} p-4 rounded-full text-white`}
            >

                {icon}

            </div>

        </div>

    );

}