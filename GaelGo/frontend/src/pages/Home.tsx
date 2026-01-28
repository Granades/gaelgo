import { theme } from "../styles/theme";
import "../styles/home.css";

export default function Home() {
  return (
    <div className="page">
      <header className="header">
        <div className="brand">GaelGo</div>
        <div className="subtitle">Fixed‑price travel packages from Dublin</div>
      </header>

      <section className="panel">
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
      </section>

      <section className="grid">
        {[
          { title: "Dublin → Paris", nights: 2, price: 200 },
          { title: "Dublin → Rome", nights: 4, price: 300 },
          { title: "Dublin → Vienna", nights: 5, price: 400 },
        ].map((p) => (
          <div className="card" key={p.title}>
            <div className="cardImage" />
            <div className="cardBody">
              <div className="cardTitle">{p.title}</div>
              <div className="cardMeta">{p.nights} nights · €{p.price}</div>
              <button className="ghost">View details</button>
            </div>
          </div>
        ))}
      </section>

      <footer className="footer">
        <span style={{ color: theme.colors.textSecondary }}>
          No payments — redirects to providers with real prices
        </span>
      </footer>
    </div>
  );
}
