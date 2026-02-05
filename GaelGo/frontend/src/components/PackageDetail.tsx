type PackageDetailProps = {
  title: string;
  destination: string;
  nights: number;
  price: number;
  description: string;
  date: string;
  airline: string;
  hotel?: string; // Hotel name, stars, location, etc.
  includes?: string[];
  onClick?: () => void;
};

export default function PackageDetail({
  title,
  destination,
  nights,
  price,
  description,
  date,
  airline,
  hotel,
  includes = [],
  onClick,
}: PackageDetailProps) {
  return (
    <div className="detailPage">
      <div className="detailHero" onClick={onClick}></div>

      <div className="detailHeader">
        <div className="detailTitle">{title}</div>
        <div className="detailMeta">
          {destination} · {nights} nights · {date}
        </div>

        <div className="detailInfoRow">
          <span className="detailLabel">Airline:</span> {airline}
        </div>

        {hotel && (
          <div className="detailInfoRow">
            <span className="detailLabel">Hotel:</span> {hotel}
          </div>
        )}

        <div className="detailInfoRow">
          <span className="detailLabel">Description:</span> {description}
        </div>

        <div className="detailPrice">€{price}</div>
      </div>

      <div className="detailCard">
        {includes.length > 0 && (
          <ul className="detailList">
            {includes.map((item) => (
              <li key={item}>{item}</li>
            ))}
          </ul>
        )}
        <div className="detailCTA">
          <button className="btnPrimary">Reserve interest</button>
        </div>
      </div>
    </div>
  );
}
