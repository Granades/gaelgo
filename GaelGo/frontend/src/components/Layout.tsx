
import {Link} from "react-router-dom";

export default function Layout()
{
   // const [isLoginOpen, setIsLoginOpen] = useState(false)
   // const [isRegisterOpen, setIsRegisterOpen] = useState(false)

    return(
        <header style = {{padding : "10px"}}>
            <nav>
                <Link to="/" style={{ marginRight: "10px" }}>Home</Link>
                <Link to="/packages" style={{ marginRight: "10px" }}>Admin</Link>
                <Link to="/offers" style={{ marginRight: "10px" }}>Offers</Link>
                <Link to="/reserve" style={{ marginRight: "10px" }}>Reserve</Link>
            </nav>


        </header>
    )

}