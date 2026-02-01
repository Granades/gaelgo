
import { http } from "../api/http";
import type { AuthResponse } from "../auth/authTypes";

// Login
export type LoginPayload = {
  email: string;
  password: string;
};

// Register
export type RegisterPayload = {
  username: string;
  email: string;
  password: string;
};

export type ApiResult<T> =
  | { ok: true; data: T }
  | { ok: false; message: string };

export const login = async (
  credentials: LoginPayload
): Promise<ApiResult<AuthResponse>> => {
  try {
    const res = await http.post(`/auth/login`, credentials);
    return { ok: true, data: res.data };
  } catch {
    return { ok: false, message: "Login failed!" };
  }
};

export const register = async (
  userData: RegisterPayload
): Promise<ApiResult<AuthResponse>> => {
  try {
    const res = await http.post(`/auth/register`, userData);
    return { ok: true, data: res.data };
  } catch {
    return { ok: false, message: "Register failed" };
  }
};




