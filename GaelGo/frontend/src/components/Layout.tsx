import { Link, Outlet } from "react-router-dom";

import "../styles/layout.css";

export default function Layout() {
  return (
    <>
      <header className="nav">
        <nav className="navInner">
          <Link to="/" className="brand">GaelGo</Link>
          <Link to="/packages" className="navLink">Packages</Link>
          <Link to="/reserve" className="navLink">Reserve</Link>
        </nav>
      </header>
      <main className="container">
        <Outlet />
      </main>
      <footer className="footer">
        No cobramos por este trabajo. Desarrollado por Granades - Github - Contacta para desarrollos especificos
      </footer>
    </>
  );
}
