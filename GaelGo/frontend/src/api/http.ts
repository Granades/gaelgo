import axios from "axios";
import { getToken } from "../auth/authStore";

export const http = axios.create({
  baseURL: "http://localhost:8080", // CHANGE WITH REAL URL BACKEND
  headers: { "Content-Type": "application/json" },
  timeout: 10000,
});

// interceptor: attach token
http.interceptors.request.use((config) => {
  const token = getToken();
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

// interceptor: normalize errors
http.interceptors.response.use(
  (res) => res,
  (err) => {
    const message =
      err?.response?.data?.message ??
      err?.message ??
      "Unknown network error";
    return Promise.reject(new Error(message));
  }
);
