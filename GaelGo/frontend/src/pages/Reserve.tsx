import { useParams } from "react-router-dom";
import { mockPackages } from "../services/mockPackages";
import ReserveForm from "../components/ReserveForm";

export default function Reserve()
{

    const { id } = useParams();


    const rsv = mockPackages.find((r) => r.id === id);
    const bullets : string[] = [
        "We don’t earn money from these links.",
        "We are not a travel agency.",
        "We don’t handle bookings or work with airlines directly.",
    ];

    if(!rsv)
    {
        return(
        <div>
            <h2>NO RESERVE FOUND IT</h2>
            <p>PLEASE GO BACK</p>
        </div>)
    }

    return(
        <div>

            <h2>Reserve</h2>
            <ReserveForm
                title = {rsv.title}
                bullets = {bullets}
                info = "You'll complete the booking on the provider's website"
                icon = ""
                name =" Provider name"
                price = {rsv.price}
                onLink = {() => window.open("")}
                onShare = {() => navigator.clipboard.writeText("")}>

            </ReserveForm>

        </div>
    )
}