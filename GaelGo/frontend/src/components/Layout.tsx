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
        We don’t charge for this work. Built by <a href="https://github.com/Granades" target="_blank" rel="noreferrer">Granades</a> · <a href="https://github.com/Granades" target="_blank" rel="noreferrer">GitHub</a> · Contact me for specific development
      </footer>
    </>
  );
}
