import { Link, Outlet } from "react-router-dom";

import "../styles/layout.css";

export default function Layout() {
  return (
    <>
      <header className="nav">
        <nav className="navInner">
          <Link to="/" className="brand">GaelGo</Link>
          <Link to="/packages" className="navLink">Packages</Link>
        </nav>
      </header>
      <main className="container">
        <Outlet />
      </main>
      <footer className="footer">
        Made with ❤️ by <a href="https://granades.github.io/portfolio/" target="_blank" rel="noreferrer">Granades</a> · <a href="https://github.com/Granades" target="_blank" rel="noreferrer">GitHub</a> · Open to collaboration
      </footer>
    </>
  );
}
