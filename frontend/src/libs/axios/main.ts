import axios from "axios";

// eslint-disable-next-line no-console
console.log("API URL", "http://localhost:8080/estore/api");

export const api = axios.create({
  baseURL: "http://localhost:8080/estore/api",
  withCredentials: false,
});
