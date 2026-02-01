import type { AuthResponse } from "./authTypes";

const KEY = "user"; // USER KEY

export function setUser(u: AuthResponse) {
  localStorage.setItem(KEY, JSON.stringify(u));
}

export function getUser(): AuthResponse | null {
  const raw = localStorage.getItem(KEY);
  if (!raw) return null;
  try {
    return JSON.parse(raw) as AuthResponse;
  } catch {
    return null;
  }
}

export function logout() {
  localStorage.removeItem(KEY);
}

export function getToken(): string | null {
  return getUser()?.token ?? null;
}
