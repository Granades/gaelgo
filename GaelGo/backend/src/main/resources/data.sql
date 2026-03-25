-- Providers
INSERT INTO providers (provider_id, name, base_url, image) VALUES
  (1, 'Ryanair Holidays', 'https://www.ryanair.com', 'ryanair.png'),
  (2, 'TUI', 'https://www.tui.com', 'tui.png'),
  (3, 'Aer Lingus', 'https://www.aerlingus.com', 'aerlingus.png')
ON CONFLICT (provider_id) DO NOTHING;

-- Packages
INSERT INTO packages
  (package_id, title, destination, price, currency, departure_date, nights,
   departure, airline, hotel, description, includes, image) VALUES
  (1, 'Weekend in Paris', 'Paris', 499.99, 'EUR', '2026-05-10', 3, 'Dublin', 'Ryanair', 'Hotel Lumiere', 'City break', 'Flights+Hotel', 'paris.jpg'),
  (2, 'Rome Adventure', 'Rome', 699.50, 'EUR', '2026-06-02', 5, 'Dublin', 'Aer Lingus', 'Roma Inn', 'Historic tour', 'Flights+Hotel+Breakfast', 'rome.jpg'),
  (3, 'Lisbon Escape', 'Lisbon', 399.00, 'EUR', '2026-05-22', 3, 'Dublin', 'Ryanair', 'Tejo Hotel', 'Sun & city', 'Flights+Hotel', 'lisbon.jpg'),
  (4, 'Barcelona Sun', 'Barcelona', 549.00, 'EUR', '2026-06-14', 4, 'Dublin', 'Vueling', 'Las Ramblas Stay', 'Beach & tapas', 'Flights+Hotel+Breakfast', 'barcelona.jpg'),
  (5, 'Prague Classic', 'Prague', 459.00, 'EUR', '2026-05-28', 3, 'Dublin', 'Ryanair', 'Charles Bridge Hotel', 'Historic city break', 'Flights+Hotel', 'prague.jpg'),
  (6, 'Amsterdam Weekend', 'Amsterdam', 520.00, 'EUR', '2026-06-08', 3, 'Dublin', 'Aer Lingus', 'Canal View', 'Museums & canals', 'Flights+Hotel+Breakfast', 'amsterdam.jpg'),
  (7, 'Berlin Lights', 'Berlin', 510.00, 'EUR', '2026-06-20', 3, 'Dublin', 'Ryanair', 'Mitte Central', 'Modern city break', 'Flights+Hotel', 'berlin.jpg'),
  (8, 'Madrid Culture', 'Madrid', 565.00, 'EUR', '2026-07-02', 4, 'Dublin', 'Iberia', 'Gran Via Hotel', 'Museums & parks', 'Flights+Hotel+Breakfast', 'madrid.jpg'),
  (9, 'Vienna Music', 'Vienna', 610.00, 'EUR', '2026-06-26', 4, 'Dublin', 'Austrian', 'Opera House Inn', 'Classical weekend', 'Flights+Hotel', 'vienna.jpg'),
  (10, 'Copenhagen Hygge', 'Copenhagen', 640.00, 'EUR', '2026-07-10', 4, 'Dublin', 'SAS', 'Nyhavn Stay', 'Nordic escape', 'Flights+Hotel+Breakfast', 'copenhagen.jpg')
ON CONFLICT (package_id) DO NOTHING;

-- Provider links
INSERT INTO package_provider_links (package_provider_link_id, package_id, provider_id, url, last_checked, price) VALUES
  (1, 1, 1, 'https://ryanair.com/paris', NOW(), 499.99),
  (2, 2, 3, 'https://aerlingus.com/rome', NOW(), 699.50),
  (3, 3, 1, 'https://ryanair.com/lisbon', NOW(), 399.00),
  (4, 4, 2, 'https://tui.com/barcelona', NOW(), 549.00),
  (5, 5, 1, 'https://ryanair.com/prague', NOW(), 459.00),
  (6, 6, 3, 'https://aerlingus.com/amsterdam', NOW(), 520.00),
  (7, 7, 1, 'https://ryanair.com/berlin', NOW(), 510.00),
  (8, 8, 2, 'https://tui.com/madrid', NOW(), 565.00),
  (9, 9, 2, 'https://tui.com/vienna', NOW(), 610.00),
  (10, 10, 3, 'https://aerlingus.com/copenhagen', NOW(), 640.00)
ON CONFLICT (package_provider_link_id) DO NOTHING;

-- Reset sequences
SELECT setval('providers_provider_id_seq', (SELECT MAX(provider_id) FROM providers));
SELECT setval('packages_package_id_seq', (SELECT MAX(package_id) FROM packages));
SELECT setval('package_provider_links_package_provider_link_id_seq', (SELECT MAX(package_provider_link_id) FROM package_provider_links));
