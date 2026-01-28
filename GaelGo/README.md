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
- **Single backend** (REST API)
- **Mobile app** (client)
- **Web app** (client)
- Database with packages + interest reservations

## Next steps
1. Define data model
2. Design basic endpoints
3. Sketch app/web screens
4. Create seed data
