# GaelGo — Architecture (Detailed)

This document explains the software architecture decisions for GaelGo across **backend**, **web**, and **mobile**. The goal is to keep the system **simple, scalable, and easy to explain**.

---

## 1) High‑Level Architecture
GaelGo is a **multi‑client system** that shares a single backend:

```
[Mobile App]   [Web App]
      \        /
       \      /
        [REST API]
            |
        [MySQL]
```

**Why this approach:**
- One source of truth for data
- Consistent behavior across clients
- Easier maintenance and testing

---

## 2) Backend Architecture (Spring Boot)
We use a **layered architecture**, which is standard in enterprise Java.

### Layers
1. **Controller Layer**
   - Receives HTTP requests
   - Validates input (DTO validation)
   - Returns JSON responses

2. **Service Layer**
   - Business logic
   - Coordinates repositories
   - Keeps controllers thin

3. **Repository Layer**
   - Data access
   - Uses Spring Data JPA

### Key principles
- **DTOs vs Entities**: API models are separated from DB models.
- **Validation**: Input validation with annotations (`@NotNull`, `@Email`).
- **Error handling**: Centralized with `@ControllerAdvice`.

**Why:**
- Clean separation of concerns
- Easier testing
- Standard for interviews/industry

---

## 3) Database Architecture (MySQL)
The DB stores only what we need for the MVP.

### Tables
- `packages`
- `reservations`
- `favorites`

### Relationships
- One package → many reservations
- One package → many favorites

### Data strategy
- **Seed data** for packages (stable demo)
- Reservations are “interest only” (no payment)

---

## 4) Web Architecture (React)
We use a **feature‑based folder structure**:

```
frontend/src/
  pages/       # Home, PackagesList, Detail, Reserve
  components/  # Cards, Buttons, Chips
  services/    # API layer (fetch/axios)
  styles/      # Global + theme styles
```

**Why:**
- Easy to scale as pages grow
- Components are reusable
- Services isolate API logic

---

## 5) Mobile Architecture (Kotlin + MVVM)
The Android app follows **MVVM**:

```
View (Activity/Fragment)
   -> ViewModel
       -> Repository
           -> API (Retrofit)
```

**Why:**
- Clear separation between UI and logic
- Testable ViewModels
- Standard Kotlin Android architecture

---

## 6) API Design Principles
- **RESTful endpoints**
- **Stateless** requests
- JSON input/output
- Simple filtering via query params

Example:
```
GET /api/v1/packages?budget=200&date=2026-03-06
```

---

## 7) Security & Scope (MVP)
- No authentication for MVP
- Email used as lightweight identifier
- Payments excluded (redirect to provider)

---

## 8) Scalability Considerations (Future)
- Add auth (JWT)
- Add caching for package lists
- Admin panel for package management
- Payment integration (Stripe)

---

## 9) Why this architecture works for a CV project
- Demonstrates real industry patterns
- Easy to explain in interviews
- Balanced complexity (not over‑engineered)
