# GaelGo Backend API (MVP)

Base URL: `http://localhost:8080/api/v1`

## Packages

### List packages
- **GET** `/package`
- **Optional filters (query params)**:
  - `destination`
  - `maxPrice`
  - `minPrice`
  - `date` (departureDate)
  - `departureAfter`

### Search packages (same filters)
- **GET** `/package/search`

### Package detail
- **GET** `/package/{id}`

### Create package
- **POST** `/package`
- **Body (PackageRequest):**
  - `title` (string)
  - `destination` (string)
  - `price` (number)
  - `currency` (string, 3 letters)
  - `departureDate` (YYYY-MM-DD)
  - `nights` (int)
  - `departure` (string)
  - `airline` (string)
  - `hotel` (string, optional)
  - `description` (string, optional)
  - `includes` (string, optional)
  - `image` (string, optional)

### Update package
- **PUT** `/package/{id}`
- **Body:** same as create

### Delete package
- **DELETE** `/package?packageId={id}`

### Provider links for package
- **GET** `/package/{id}/provider`

### Update package price
- **PATCH** `/package/{id}/price`
- **Query params:**
  - `newPrice` (number)
  - `reason` (string, optional)

---

## Providers

### List providers
- **GET** `/provider`

### Provider detail
- **GET** `/provider/{id}`

### Create provider
- **POST** `/provider`
- **Body (ProviderRequest):**
  - `name` (string)
  - `baseUrl` (string)
  - `image` (string)

### Update provider
- **PUT** `/provider/{id}`
- **Body:** same as create

### Delete provider
- **DELETE** `/provider?providerId={id}`

---

## Subscribers

### Subscribe
- **POST** `/subscribers`
- **Body (SubscriberRequest):**
  - `email` (string)
  - `packageId` (long)

### Unsubscribe
- **DELETE** `/subscribers?email={email}&packageId={id}`

### List subscribers by package
- **GET** `/subscribers/package/{packageId}`

---

## Error Handling

Errors return JSON with:
- `status`
- `message`
- `path`
- `timestamp`

---

## Database

PostgreSQL expected. Example config:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/gaelgo_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

---

## Frontend connection steps

1. Ensure backend runs on `http://localhost:8080`
2. Replace mocks with real calls (fetch/axios)
3. Use endpoints above for list/detail/create

---

## Seed data

`backend/src/main/resources/data.sql` is loaded at startup if DB config is valid.
