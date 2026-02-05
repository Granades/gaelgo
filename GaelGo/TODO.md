# GaelGo — Backend TODO (Sprint 2)

> Purpose: build the Spring Boot backend to match the frontend MVP.
> Use this list as ordered tickets.

---

## 1) Project setup
**Goal:** Create Spring Boot project with required dependencies.

**Tasks**
- Create `backend/` Spring Boot project
- Add dependencies: Web, Validation, JPA, MySQL Driver
- Configure application.yml (port, DB connection)

**Acceptance**
- App starts with `./mvnw spring-boot:run`

---

## 2) Data model (Entities)
**Goal:** Implement DB models.

**Tasks**
- `Package` entity
- `Reservation` entity
- (Optional) `Favorite` entity

**Acceptance**
- Entities map correctly to tables

---

## 3) Repositories
**Goal:** Data access layer.

**Tasks**
- `PackageRepository`
- `ReservationRepository`

**Acceptance**
- Basic CRUD available

---

## 4) Services
**Goal:** Business logic layer.

**Tasks**
- `PackageService`
- `ReservationService`

**Acceptance**
- Services used by controllers

---

## 5) Controllers (API)
**Goal:** Expose REST endpoints.

**Tasks**
- `GET /api/v1/packages` (filters)
- `GET /api/v1/packages/{id}`
- `POST /api/v1/reservations`

**Acceptance**
- Endpoints respond with JSON

---

## 6) Seed data
**Goal:** Load initial packages.

**Tasks**
- Load from JSON or SQL on startup

**Acceptance**
- Packages available on first run

---

## 7) Validation & error handling
**Goal:** Clean API responses.

**Tasks**
- DTO validation
- Global exception handler

**Acceptance**
- 400/404 handled cleanly

---

## 8) Integration test (basic)
**Goal:** Ensure endpoints work.

**Tasks**
- Test packages list + detail

**Acceptance**
- Tests pass
