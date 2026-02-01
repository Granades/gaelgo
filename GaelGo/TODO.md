# GaelGo — Ordered TODO (Sprint 1)

> Purpose: build the Web MVP first (React + Vite + TS), then mirror to Kotlin.
> Use this list as if it were Jira tickets: do them in order.

---

## 1) Routing Setup
**Goal:** Enable navigation between pages.

**Tasks**
- Install React Router.
- Create the following pages:
  - `Home`
  - `PackagesList`
  - `PackageDetail`
  - `Reserve`
- Add routes in `App.tsx`.
- Add a simple top nav (logo + “Packages” link).

**Acceptance**
- Navigation works between all pages.
- URL reflects page (e.g., `/packages`, `/packages/1`, `/reserve`).

**Status:** In progress

---

## 2) Base Layout + Navigation
**Goal:** Shared layout used by all pages.

**Tasks**
- Create `Layout` component (header + container).
- Move nav into `Layout`.
- Wrap routes with `Layout`.

**Acceptance**
- All pages show consistent header and spacing.

---

## 3) Mock Data Layer
**Goal:** UI uses local mock data before backend.

**Tasks**
- Create `src/services/mockPackages.ts`.
- Export an array of 5–6 packages (use seed data).
- Each package should include:
  - `id`, `title`, `destination`, `price`, `currency`, `departureDate`, `nights`, `departure`, `includes`, `image`

**Acceptance**
- Pages can import the array without errors.

**Status:** Not started

---

## 4) UI Components (Basic)
**Goal:** Reusable UI for consistent styling.

**Tasks**
- `PackageCard` component
- `PrimaryButton` component
- `Chip` component

**Acceptance**
- Components are used in `PackagesList` and `Home`.

---

## 5) Packages List Page
**Goal:** Display all packages with filters UI.

**Tasks**
- Render list of packages from mock data.
- Add filter chips (200/300/400).
- Add date input (no real filtering yet).

**Acceptance**
- Cards render with price, title, nights.
- Clicking a card navigates to detail page.

---

## 6) Package Detail Page
**Goal:** Show one package’s full detail.

**Tasks**
- Load package by route param `id`.
- Display full info + includes list.
- Add “Reserve interest” CTA.

**Acceptance**
- Works for valid id.
- Shows fallback message if id not found.

---

## 7) Reserve Page
**Goal:** Capture interest (no payment).

**Tasks**
- Simple form: name, email, phone (optional).
- On submit: log values to console.
- Add success message UI (local state).

**Acceptance**
- Form submits without crash.
- Shows confirmation message.

---

## 8) Styling Pass
**Goal:** Make UI consistent with Temple Bar palette.

**Tasks**
- Apply colors, spacing, and typography from style guide.
- Ensure buttons, chips, cards look consistent.

**Acceptance**
- UI matches dark/gold/burgundy style.

---

## 9) Cleanup
**Goal:** Keep project tidy.

**Tasks**
- Remove unused template files if any.
- Ensure `npm run build` passes.

**Acceptance**
- Build succeeds.
- No unused sample code remains.
