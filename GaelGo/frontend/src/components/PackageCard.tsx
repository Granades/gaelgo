type PackageCardProps = {
    title : string;
    destination : string;
    nights : number;
    price : number;
    date : string;
    onClick?: () => void;
};


export default function PackageCard({title, destination, nights, price, date, onClick} : PackageCardProps)
{

    return(
        <div className = "packageCard" onClick={onClick}>
            <div className = "packageImage"/>
            <div className = "packageBody">
                <div className = "packageTitle">{title}</div>
                <div className = "packageMeta">
                    {destination} {nights} - {date}</div>
                <div className = "packagePrice">€{price}</div>
                <div className = "packageCTA">
                    <button className = "btnPrimary">View details</button>

                </div>
            </div>
        </div>
    )
}