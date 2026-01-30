import { type ChangeEvent, useState } from "react";
import { login } from "../../services/authService";

type LoginFormProps = {
  onSuccess?: () => void;
};

export default function LoginForm({ onSuccess }: LoginFormProps) {
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const [message, setMessage] = useState<string>("");

  const handleLogin = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const res = await login({ email, password });
      if (res.ok) {
        localStorage.setItem("user", JSON.stringify(res.data));
        setMessage("Login successfully");
        onSuccess?.();
      } else {
        setMessage(res.message);
      }
    } catch {
      setMessage("Error!");
    }
  };

  return (
    <form onSubmit={handleLogin}>
      <h2>Log In</h2>
      {message && <p>{message}</p>}
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e: ChangeEvent<HTMLInputElement>) => setEmail(e.target.value)}
        required
      />
      <br />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e: ChangeEvent<HTMLInputElement>) => setPassword(e.target.value)}
        required
      />
      <br />
      <button type="submit">Log In</button>
    </form>
  );
}
