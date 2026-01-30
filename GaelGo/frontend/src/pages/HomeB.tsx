import { theme } from "../styles/theme";
import "../styles/home.css";
import {Link} from "react-router-dom";

function Home() {


  return (
      <header style = {{backgroundColor : theme.colors.primary}}>
          <nav>
              <Link to ="/" style = {{marginRight: "10px"}}>Home</Link>
              <Link to ="/list" style = {{marginRight: "10px"}}>PackagesList</Link>
              <Link to ="/reserve" style = {{marginRight: "10px"}}>Reserve</Link>
          </nav>
      </header>


  )
}

export default Home