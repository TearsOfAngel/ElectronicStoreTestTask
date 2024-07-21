import { Toaster } from "react-hot-toast";
import "./App.css";
import { IndexPage } from "./pages/index/main";

function App() {
  return (
    <>
      <IndexPage />;
      <Toaster position="bottom-right" />
    </>
  );
}

export default App;
