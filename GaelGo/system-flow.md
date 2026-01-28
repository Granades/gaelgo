# System Flow (App ↔ Web ↔ Backend ↔ Database)

## High‑level architecture
- **Clients:** Mobile app + Web app
- **Backend:** REST API (single source of truth)
- **Database:** Stores packages + interest reservations + favorites

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

### 3) Reserve interest (no payment)
1. User fills form (name/email)
2. Client calls `POST /reservations`
3. API validates input and saves record
4. API returns confirmation
5. Client shows success message

### 4) Save favorites (optional)
1. User taps “save”
2. Client calls `POST /favorites`
3. API saves favorite in DB
4. Client updates UI

## Key principles
- **Single backend for app + web** (no duplicated logic)
- **Stateless API** (simple, easy to demo)
- **No payment** (redirect to provider if needed)
- **Seed data** (fixed packages for a stable demo)
