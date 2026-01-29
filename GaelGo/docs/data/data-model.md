# GaelGo — Data Model (MySQL)

## Entities

### 1) packages
Stores fixed‑price travel packages.

**Fields**
- id (PK, INT, auto)
- title (VARCHAR)
- destination (VARCHAR)
- price (INT) — 200/300/400
- currency (CHAR(3)) — EUR
- departure_date (DATE)
- nights (INT)
- departure (VARCHAR) — Dublin
- includes (TEXT) — comma list or JSON
- image (VARCHAR)
- created_at (TIMESTAMP)

### 2) reservations
Captures “interest” reservations (no payments).

**Fields**
- id (PK, INT, auto)
- package_id (FK → packages.id)
- name (VARCHAR)
- email (VARCHAR)
- phone (VARCHAR, nullable)
- created_at (TIMESTAMP)

### 3) favorites (optional)
Stores user favorites (lightweight, no login).

**Fields**
- id (PK, INT, auto)
- email (VARCHAR) — lightweight user identifier
- package_id (FK → packages.id)
- created_at (TIMESTAMP)

## Relationships
- packages 1 — * reservations
- packages 1 — * favorites

## Notes
- Keep it minimal for MVP.
- “includes” can be stored as JSON if preferred.
- Email is used as a lightweight user ID (no auth).
