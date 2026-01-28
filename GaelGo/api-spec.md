# GaelGo — API Spec (Spring Boot REST)

Base URL: `/api/v1`

## 1) Packages
### GET `/packages`
List packages with optional filters.

**Query params**
- `budget` (int) — 200/300/400
- `date` (YYYY‑MM‑DD)
- `destination` (string, optional)

**Response 200**
```json
[
  {
    "id": 1,
    "title": "Dublin → Paris (2‑night escape)",
    "destination": "Paris, France",
    "price": 200,
    "currency": "EUR",
    "departureDate": "2026-03-06",
    "nights": 2,
    "departure": "Dublin",
    "includes": ["Return flight", "3★ hotel", "Breakfast"],
    "image": "paris.jpg"
  }
]
```

### GET `/packages/{id}`
Get package details.

**Response 200**
```json
{ "id": 1, "title": "...", "destination": "..." }
```

---

## 2) Reservations (interest only)
### POST `/reservations`
Create a reservation of interest (no payment).

**Request body**
```json
{
  "packageId": 1,
  "name": "John Doe",
  "email": "john@email.com",
  "phone": "+353000000"
}
```

**Response 201**
```json
{ "id": 10, "status": "CONFIRMED" }
```

---

## 3) Favorites (optional)
### POST `/favorites`
Save a favorite.

**Request body**
```json
{ "email": "john@email.com", "packageId": 1 }
```

**Response 201**
```json
{ "id": 12 }
```

### GET `/favorites?email=...`
List favorites by email.

**Response 200**
```json
[
  { "id": 12, "packageId": 1 }
]
```

---

## Conventions
- JSON responses
- Validation errors → 400
- Not found → 404
- Server errors → 500
