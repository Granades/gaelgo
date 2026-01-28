export const theme = {
  colors: {
    primary: "#D4AF37",
    primaryDark: "#A9872A",
    accent: "#7B1E3A",
    background: "#0F0F10",
    surface: "#1A1B1E",
    border: "#2A2D33",
    textPrimary: "#F5F3EE",
    textSecondary: "#C9C2B8",
    success: "#2E8B57",
    warning: "#C7782A",
  },
  radius: {
    card: 12,
    button: 10,
    input: 8,
  },
  spacing: {
    xs: 8,
    sm: 16,
    md: 24,
    lg: 32,
  },
  typography: {
    fontFamily: "Inter, Arial, sans-serif",
    h1: { size: 28, weight: 700 },
    h2: { size: 22, weight: 600 },
    body: { size: 16, weight: 400 },
    caption: { size: 12, weight: 400 },
  },
} as const;
