import { useNavigate, useParams } from "react-router-dom";
import { mockPackages } from "../services/mockPackages";
import PackageDetailCard from "../components/PackageDetailCard";

export default function PackageDetail() {
  const navigate = useNavigate();
  const { id } = useParams();

  const pkg = mockPackages.find((p) => p.id === id);

  if (!pkg) {
    return (
      <div>
        <h2>Package Detail</h2>
        <p>Package not found.</p>
      </div>
    );
  }

  return (
    <div>
      <h2>Package Detail</h2>
      <PackageDetailCard
        title={pkg.title}
        destination={pkg.destination}
        nights={pkg.nights}
        price={pkg.price}
        description={pkg.description}
        date={pkg.departureDate}
        airline={pkg.airline}
        hotel={pkg.hotel}
        includes={pkg.includes}
        onClick={() => navigate(`/reserve/${pkg.id}`)}
      />
    </div>
  );
}
