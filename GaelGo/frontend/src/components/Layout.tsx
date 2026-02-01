import { Link, Outlet } from "react-router-dom";

export default function Layout() {
  return (
    <>
      <header style={{ padding: "10px" }}>
        <nav>
          <Link to="/" style={{ marginRight: "10px" }}>Home</Link>
          <Link to="/packages" style={{ marginRight: "10px" }}>Packages</Link>
          <Link to="/reserve" style={{ marginRight: "10px" }}>Reserve</Link>
        </nav>
      </header>
      <main>
        <Outlet />
      </main>
    </>
  );
}
