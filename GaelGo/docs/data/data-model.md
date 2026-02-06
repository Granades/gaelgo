# GaelGo — Data Model (PostgreSQL)

> **Note:** This project uses a **SINGULAR** naming approach (e.g., `package`, `provider`).

## Entities

### 1) package
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
- package_id (FK → package.package_id)
- provider_id (FK → provider.provider_id)
- url (VARCHAR)
- last_checked (TIMESTAMP, nullable)
- price (DECIMAL(10,2))

### 4) package_price_history (no mvp, later)
Tracks price changes.

**Fields**
- price_history_id (PK, UUID or SERIAL)
- package_id (FK → package.package_id)
- provider_id (FK → provider.provider_id)
- price (DECIMAL(10,2))
- timestamp (TIMESTAMP)

### 5) subscriber (no mvp, later)
Email capture for offers.

**Fields**
- subscriber_id (PK, UUID or SERIAL)
- email (VARCHAR, unique)
- package_id (FK → package.package_id, nullable)
- created_at (TIMESTAMP)
- active (BOOLEAN)

## Relationships
- package 1 — * package_provider_link
- provider 1 — * package_provider_link
- package 1 — * package_price_history
- provider 1 — * package_price_history
- package 0/1 — * subscriber
