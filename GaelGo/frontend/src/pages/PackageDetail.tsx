import { useParams } from "react-router-dom";

export default function PackageDetail() {
  const { id } = useParams();

  return (
    <div>
      <h2>Package Detail</h2>
      <p>Package ID: {id}</p>
    </div>
  );
}
