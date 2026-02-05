import "../styles/home.css";

export default function Home() {
  return (
    <div className="page">
      <header className="header">
        <div className="brand">GaelGo</div>
        <div className="subtitle">Budget‑first trips from Dublin</div>
      </header>

      <section className="hero">
        <div className="heroLeft">
          <div className="heroTitle">Find fixed‑price trips</div>
          <div className="heroNote">Simple search, no payment flow</div>

          <div className="filters">
            <span className="label">Budget</span>
            <div className="chips">
              <button className="chip active">€200</button>
              <button className="chip">€300</button>
              <button className="chip">€400</button>
            </div>
          </div>

          <div className="filters">
            <span className="label">Departure date</span>
            <input className="input" type="date" />
          </div>

          <button className="cta">Search packages</button>
        </div>

        <div className="heroRight">
          <div className="featuredCard">
            <div className="featuredTag">Featured offer</div>
            <div className="featuredTitle">Dublin → Rome</div>
            <div className="featuredMeta">€300 · 4 nights</div>
          </div>
        </div>
      </section>

      <section className="section">
        <div className="sectionTitle">Offers</div>
        <div className="row">
          <div className="card wide" />
          <div className="card wide" />
          <div className="card wide" />
        </div>
      </section>

      <section className="section">
        <div className="sectionTitle">Popular</div>
        <div className="grid">
          <div className="card" />
          <div className="card" />
          <div className="card" />
          <div className="card" />
        </div>
      </section>

      <footer className="footer">
        Made with ❤️ by <a href="https://granades.github.io/portfolio/" target="_blank" rel="noreferrer">Granades</a> · <a href="https://github.com/Granades" target="_blank" rel="noreferrer">GitHub</a> · Open to collaboration<br />
        No payments — redirects to providers with real prices
      </footer>
    </div>
  );
}
