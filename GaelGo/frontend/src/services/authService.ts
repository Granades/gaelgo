import axios from "axios";

const API = "//Fill later";

// Register
export type RegisterPayload = {
  username: string;
  email: string;
  password: string;
};

export type RegisterResult =
  | { ok: true; data: unknown }
  | { ok: false; message: string };

export const register = async (
  userData: RegisterPayload
): Promise<RegisterResult> => {
  try {
    const res = await axios.post(`${API}/register`, userData);
    return { ok: true, data: res.data };
  } catch {
    return { ok: false, message: "Register failed" };
  }
};

// Login
export type LoginPayload = {
  email: string;
  password: string;
};

export type LoginResult =
  | { ok: true; data: unknown }
  | { ok: false; message: string };

export const login = async (
  credentials: LoginPayload
): Promise<LoginResult> => {
  try {
    const res = await axios.post(`${API}/login`, credentials);
    return { ok: true, data: res.data };
  } catch {
    return { ok: false, message: "Login failed!" };
  }
};
