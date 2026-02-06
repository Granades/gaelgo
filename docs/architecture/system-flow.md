# System Flow (App ↔ Web ↔ Backend ↔ Database)

## High‑level architecture
- **Clients:** Mobile app + Web app
- **Backend:** Java (Spring Boot) REST API (single source of truth)
- **Database:** PostgreSQL stores packages + providers + provider links

```
[Mobile App]        [Web App]
     │                 │
     └─────── HTTPS ───┘
              │
           [REST API]
              │
           [Database]
```

## Core flows

### 1) Browse packages
1. User opens app/web
2. Client calls `GET /packages?budget=200&date=2026-04-10`
3. API queries DB for matching packages
4. API returns list
5. Client renders cards

### 2) View package details
1. User taps a package
2. Client calls `GET /packages/:id`
3. API fetches package from DB
4. API returns full package data
5. Client renders detail view

### 3) Continue to provider (no payment)
1. User taps “Reserve interest”
2. Client calls `GET /packages/:id` (if not already loaded)
3. UI shows provider links
4. User clicks provider link
5. Booking continues on provider site

## Key principles
- **Single backend for app + web** (no duplicated logic)
- **Stateless API** (simple)
- **No payment** (redirect to provider links)
- **Seed data** (fixed packages for a stable demo)
