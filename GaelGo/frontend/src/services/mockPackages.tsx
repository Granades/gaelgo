import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { fetchPackages } from "../services/packageService";
import PackageCard from "../components/PackageCard";
import Chip from "../components/Chip";
import PrimaryButton from "../components/PrimaryButton";
import "../styles/home.css";

type Package = {
  packageId: number;
  title: string;
  destination: string;
  nights: number;
  price: number;
  departureDate: string;
};

export default function PackagesList() {
  const navigate = useNavigate();
  const [packages, setPackages] = useState<Package[]>([]);

  useEffect(() => {
    fetchPackages().then(setPackages).catch(console.error);
  }, []);

  return (
      <div className="page">
        <div className="header">
          <div className="brand">GaelGo</div>
          <div className="subtitle">Packages</div>
        </div>

        <div className="section">
          <div className="sectionTitle">Budget</div>
          <div className="chips">
            <Chip label="€200" />
            <Chip label="€300" />
            <Chip label="€400" />
          </div>
        </div>

        <div className="section">
          <div className="sectionTitle">All Packages</div>
          <div className="grid">
            {packages.map((p) => (
                <PackageCard
                    key={p.packageId}
                    title={p.title}
                    destination={p.destination}
                    nights={p.nights}
                    price={p.price}
                    date={p.departureDate}
                    onClick={() => navigate(`/packages/${p.packageId}`)}
                />
            ))}
          </div>
        </div>
        <div style={{ marginTop: "16px" }}>
          <PrimaryButton label="Back to Home" onClick={() => navigate("/")} />
        </div>
      </div>
  );
}