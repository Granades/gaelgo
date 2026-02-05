import { useNavigate } from "react-router-dom";
import { mockPackages } from "../services/mockPackages";
import PackageCard from "../components/PackageCard";
import Chip from "../components/Chip";
import PrimaryButton from "../components/PrimaryButton";

export default function PackagesList() {
    const navigate = useNavigate();

    return (
        <div>
            <h2>Packages</h2>


            <div style={{ display: "flex", gap: "8px", margin: "12px 0" }}>
                <Chip label="€200" />
                <Chip label="€300" />
                <Chip label="€400" />
            </div>


            <div style={{ display: "grid", gap: "16px", gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))" }}>
                {mockPackages.map((p) => (
                    <PackageCard
                        key={p.id}
                        title={p.title}
                        destination={p.destination}
                        nights={p.nights}
                        price={p.price}
                        date={p.departureDate}
                        onClick={() => navigate(`/packages/${p.id}`)}
                    />
                ))}
            </div>

            <div style={{ marginTop: "16px" }}>
                <PrimaryButton label="Back to Home" onClick={() => navigate("/")} />
            </div>
        </div>
    );
}