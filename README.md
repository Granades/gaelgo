# GaelGo — Budget travel packages (app + web)

Academic project for GitHub: a **mobile app + web app** connected to one backend. Focused on **fixed-price travel packages** departing from Dublin (200/300/400 EUR), designed for budget‑driven travelers.

## Real problem
Many people want to travel on a fixed budget with flexible dates, but they struggle to compare real options quickly. GaelGo offers simple, comparable packages by **price + date** and captures **interest (no payment)**.

## MVP scope
- Package listing
- Filters by **budget (200/300/400 EUR)** and date
- Package detail view
- “Reserve interest” (simple form)
- Favorites (save packages)

## Users
- Budget travelers (end users)
- (Optional) Internal admin to manage packages

## Main flow
Search → filter → view detail → reserve interest → confirmation

## Proposed architecture (high level)
- **Backend:** Java (Spring Boot) REST API
- **Mobile app:** Kotlin (Android)
- **Web app:** React
- **Database:** MySQL (packages + interest reservations)

## Competition & Differentiation
Most travel OTAs offer generic package listings and flexible search, but **few focus on Dublin departures** or **fixed‑budget discovery**. GaelGo differentiates by:
- **Budget‑first search** (200/300/400 EUR)
- **Dublin‑only departures** (simple, local focus)
- **Mobile + web in sync** (same data, same flow)
- **No payment flow** (redirect to provider with real prices)

## Product statement
**GaelGo helps budget‑focused travelers in Ireland find fixed‑price weekend trips from Dublin, fast.**

## Project structure
```
GaelGo/
  frontend/        # React (Vite) web app
  backend/         # Spring Boot API (placeholder)
  docs/            # Architecture, data, UI assets
  TODO.md          # Ordered tasks (Sprint 1)
```

## How to run (frontend)
```bash
# Clone
git clone https://github.com/Granades/gaelgo.git
cd gaelgo/frontend

# Install & run
npm install
npm run dev
```
Open: http://localhost:5173/

## Collaboration
Contributions are welcome. If you want to help, pick a task from `TODO.md` and open a PR.

## Task list
See **TODO.md** for the ordered Sprint 1 tasks.
