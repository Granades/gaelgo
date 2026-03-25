import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { fetchPackageById, fetchProviderLinks } from "../services/packageService";
import ReserveForm from "../components/ReserveForm";

export default function Reserve() {
  const { id } = useParams();
  const [pkg, setPkg] = useState<any>(null);
  const [links, setLinks] = useState<any[]>([]);

  useEffect(() => {
    if (id) {
      fetchPackageById(id).then(setPkg).catch(console.error);
      fetchProviderLinks(id).then(setLinks).catch(console.error);
    }
  }, [id]);

  const bullets: string[] = [
    "We don’t earn money from these links.",
    "We are not a travel agency.",
    "We don’t handle bookings or work with airlines directly.",
  ];

  if (!pkg) {
    return (
      <div>
        <h2>Reserve</h2>
        <p>Loading...</p>
      </div>
    );
  }

  const firstLink = links[0];
  const providerUrl = firstLink?.url || "";
  const providerPrice = firstLink?.price ?? pkg.price;

  return (
    <div>
      <h2>Reserve</h2>
      <ReserveForm
        title={pkg.title}
        bullets={bullets}
        info="You'll complete the booking on the provider's website"
        icon=""
        name="Provider"
        price={providerPrice}
        onLink={() => providerUrl && window.open(providerUrl)}
        onShare={() => providerUrl && navigator.clipboard.writeText(providerUrl)}
      />
    </div>
  );
}
