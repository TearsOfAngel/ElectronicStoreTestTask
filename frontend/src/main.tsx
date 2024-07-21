import React from "react";
import ReactDOM, { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App";
import { Swr } from "./providers/main";

createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <Swr>
      <App />
    </Swr>
  </React.StrictMode>
);
