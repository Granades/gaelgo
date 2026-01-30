import Home from "./pages/Home";
import PackageDetail from "./pages/PackageDetail";
import PackagesList from "./pages/PackagesList";
import Reserve from "./pages/Reserve";
import Offers from "./pages/Offers";
import {Routes, Route} from "react-router-dom"

function App() {
  return(
      <Routes>
        <Route path="/" element = {<Home/>} />
        <Route path="/detailed" element = {<PackageDetail/>} />
        <Route path="/packages" element = {<PackagesList/>} />
        <Route path="/reserve" element = {<Reserve/>} />
        <Route path="/offers" element = {<Offers/>}/>
      </Routes>

  )
}

export default App;
