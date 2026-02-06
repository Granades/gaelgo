# GaelGo — API Spec (Spring Boot REST)

> **Note:** This project uses a **SINGULAR** naming approach (e.g., `/package`, `/provider`).

Base URL: `/api/v1`

## 1) Package
### GET `/package`
List packages with optional filters.

**Query params**
- `budget` (int) — 200/300/400
- `date` (YYYY‑MM‑DD)
- `destination` (string, optional)

**Response 200**
```json
[
  {
    "id": "PKG-001",
    "title": "Dublin → Paris (2‑night escape)",
    "destination": "Paris, France",
    "price": 200,
    "currency": "EUR",
    "departureDate": "2026-03-06",
    "nights": 2,
    "departure": "Dublin",
    "airline": "Ryanair",
    "hotel": "Hotel Lumière (3★, Central)",
    "description": "A quick weekend break with iconic sights and easy connections.",
    "includes": ["Return flight", "3★ hotel", "Breakfast"],
    "image": "paris.jpg"
  }
]
```

### GET `/package/{id}`
Get package details (same fields as above).

**Response 200**
```json
{
  "id": "PKG-001",
  "title": "...",
  "destination": "...",
  "price": 200,
  "currency": "EUR",
  "departureDate": "2026-03-06",
  "nights": 2,
  "departure": "Dublin",
  "airline": "...",
  "hotel": "...",
  "description": "...",
  "includes": ["..."],
  "image": "..."
}
```

---

## 2) Provider links
### GET `/package/{id}/provider`
Get provider links for a package.

**Response 200**
```json
[
  {
    "providerId": "PROV-1",
    "name": "Provider Name",
    "url": "https://example.com/deal",
    "lastChecked": "2026-02-01T10:00:00Z",
    "price": 200
  }
]
```
