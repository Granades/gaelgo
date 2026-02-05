import "../styles/Reserve.css";

type ReserveFormProps = {
  title: string;
  bullets: string[];
  info: string;
  icon: string;
  name: string;
  price: number;
  onLink: () => void;
  onShare: () => void;
};

export default function ReserveForm({
  title,
  bullets,
  info,
  icon,
  name,
  price,
  onLink,
  onShare,
}: ReserveFormProps) {
  return (
    <div className="reservePage">
      <div className="infoCard">
        <div className="infoTitle">{title}</div>
        <ul className="infoList">
          {bullets.map((b) => (
            <li key={b}>{b}</li>
          ))}
        </ul>
        <div className="infoFooter">{info}</div>

        <div className="providerRow">
          {icon ? (
            <img className="providerIcon" src={icon} alt={name} />
          ) : (
            <div className="providerIcon" />
          )}
          <div className="providerName">{name}</div>
          <button className="linkBtn" onClick={onLink}>
            Link
          </button>
          <button className="shareBtn" onClick={onShare}>
            Share
          </button>
        </div>

        <div className="totalCard">
          <span className="totalLabel">Total</span>
          <span className="totalValue">€{price}</span>
        </div>
      </div>
    </div>
  );
}

