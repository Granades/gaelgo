-- Providers
INSERT INTO providers (provider_id, name, base_url, image) VALUES
                                                               (1, 'Ryanair Holidays', 'https://www.ryanair.com', 'ryanair.png'),
                                                               (2, 'TUI', 'https://www.tui.com', 'tui.png');

-- Packages
INSERT INTO packages
    (package_id, title, destination, price, currency, departure_date, nights,
     departure, airline, hotel, description, includes, image) VALUES
     (1, 'Weekend in Paris', 'Paris', 499.99, 'EUR', '2026-05-10', 3, 'Dublin', 'Ryanair', 'Hotel Lumiere', 'City break', 'Flights+Hotel', 'paris.jpg'),
     (2, 'Rome Adventure', 'Rome', 699.50, 'EUR', '2026-06-02', 5, 'Dublin', 'Aer Lingus', 'Roma Inn', 'Historic tour', 'Flights+Hotel+Breakfast', 'rome.jpg');

-- Provider links
INSERT INTO package_provider_links (package_provider_link_id, package_id, provider_id, url, last_checked, price) VALUES
    (1, 1, 1, 'https://ryanair.com/paris', NOW(), 499.99),
    (2, 2, 2, 'https://tui.com/rome', NOW(), 699.50);

-- Reset sequences
SELECT setval('providers_provider_id_seq', (SELECT MAX(provider_id) FROM providers));
SELECT setval('packages_package_id_seq', (SELECT MAX(package_id) FROM packages));
SELECT setval('package_provider_links_package_provider_link_id_seq', (SELECT MAX(package_provider_link_id) FROM package_provider_links));