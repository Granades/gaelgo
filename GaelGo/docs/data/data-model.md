# GaelGo — Data Model (PostgreSQL)

## Entities

### 1) packages
Stores fixed‑price travel packages.

**Fields**
- package_id (PK, UUID or SERIAL)
- title (VARCHAR)
- destination (VARCHAR)
- price (DECIMAL(10,2))
- currency (CHAR(3)) — EUR
- departure_date (DATE)
- nights (INT)
- departure (VARCHAR) — Dublin
- airline (VARCHAR)
- hotel (VARCHAR, nullable)
- description (TEXT)
- includes (JSON or TEXT)
- image (VARCHAR)
- created_at (TIMESTAMP)

### 2) provider
Stores providers.

**Fields**
- provider_id (PK, UUID or SERIAL)
- name (VARCHAR)
- base_url (VARCHAR)
- image (VARCHAR)

### 3) package_provider_link
Normalized provider links for each package.

**Fields**
- package_provider_id (PK, UUID or SERIAL)
- package_id (FK → packages.package_id)
- provider_id (FK → provider.provider_id)
- url (VARCHAR)
- last_checked (TIMESTAMP, nullable)
- price (DECIMAL(10,2))

### 4) package_price_history (optional)
Tracks price changes.

**Fields**
- price_history_id (PK, UUID or SERIAL)
- package_id (FK → packages.package_id)
- provider_id (FK → provider.provider_id)
- price (DECIMAL(10,2))
- timestamp (TIMESTAMP)

### 5) subscriber (optional)
Email capture for offers.

**Fields**
- subscriber_id (PK, UUID or SERIAL)
- email (VARCHAR, unique)
- package_id (FK → packages.package_id, nullable)
- created_at (TIMESTAMP)
- active (BOOLEAN)

## Relationships
- packages 1 — * package_provider_link
- provider 1 — * package_provider_link
- packages 1 — * package_price_history
- provider 1 — * package_price_history
- packages 0/1 — * subscriber

## Notes
- Use JSON for `includes` if you want structured data.
- `package_id` in subscriber is optional if the user subscribes globally.
- UUIDs are recommended for public‑facing IDs.
