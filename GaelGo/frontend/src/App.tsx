import { Routes, Route } from "react-router-dom";
import Layout from "./components/Layout";
import Home from "./pages/Home";
import PackageDetail from "./pages/PackageDetail";
import PackagesList from "./pages/PackagesList";
import Reserve from "./pages/Reserve";

function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<Home />} />
        <Route path="/packages" element={<PackagesList />} />
        <Route path="/packages/:id" element={<PackageDetail />} />
        <Route path="/reserve/:id" element={<Reserve />} />
      </Route>
    </Routes>
  );
}

export default App;
