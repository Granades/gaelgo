import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { fetchPackageById } from "../services/packageService";
import PackageDetailCard from "../components/PackageDetailCard";

export default function PackageDetail() {
  const navigate = useNavigate();
  const { id } = useParams();
  const [pkg, setPkg] = useState<any>(null);

  useEffect(() => {
    if (id) {
      fetchPackageById(id).then(setPkg).catch(console.error);
    }
  }, [id]);

  if (!pkg) {
    return (
      <div>
        <h2>Package Detail</h2>
        <p>Loading...</p>
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
        onClick={() => navigate(`/reserve/${pkg.packageId}`)}
      />
    </div>
  );
}
