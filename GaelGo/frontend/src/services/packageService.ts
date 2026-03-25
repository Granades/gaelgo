const API = "http://localhost:8080/api/v1";

export async function fetchPackages() {
  const res = await fetch(`${API}/package`);
  if (!res.ok) throw new Error("Failed to load packages");
  return res.json();
}

export async function fetchPackageById(id: string) {
  const res = await fetch(`${API}/package/${id}`);
  if (!res.ok) throw new Error("Package not found");
  return res.json();
}

export async function fetchProviderLinks(id: string) {
  const res = await fetch(`${API}/package/${id}/provider`);
  if (!res.ok) throw new Error("Failed to load provider links");
  return res.json();
}
