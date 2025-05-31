-- Вставляем 3 компании
INSERT INTO companies (email, password, name, enable, avatar) VALUES
  ('sky_airlines@example.com', 'qwe', 'Sky Airlines', true, '2fc5774d-4ae8-4583-8cb2-3714856c3784_Снимок экрана 2025-05-30 122704.png'),
  ('star_flights@example.com', 'qwe', 'Star Flights', true, '217613b4-3044-44f0-aead-8205f65a465b_Снимок экрана 2025-05-30 122704.png'),
  ('global_travel@example.com', 'qwe', 'Global Travel', true, 'not');

-- Вставляем рейсы с датами и временем
INSERT INTO flights (
    date_time_dep,
    date_time_arrive,
    city_dep,
    city_arrive,
    uniq_number,
    company_id
) VALUES
-- Рейс Sky Airlines (Нью-Йорк -> Лондон)
('2025-06-01 08:30:00', '2025-06-01 16:45:00', 'New York', 'London', 'SKY-1001', (select id from companies where name = 'Sky Airlines')),
-- Рейс Star Flights (Париж -> Токио)
('2025-06-02 11:00:00', '2025-06-03 07:20:00', 'Paris', 'Tokyo', 'STR-2001', (select id from companies where name = 'Star Flights')),
-- Рейс Global Travel (Берлин -> Рим)
('2025-06-03 14:15:00', '2025-06-03 16:05:00', 'Berlin', 'Rome', 'GLB-3001', (select id from companies where name = 'Global Travel'));

-- Вставляем билеты для Sky Airlines (рейс 1)
INSERT INTO tickets (price, flight_id, status, type, place) VALUES
-- 7 economy tickets
(199.99, (select id from flights where id = 1), true, 'ECONOMY', 1),
(199.99, (select id from flights where id = 1), true, 'ECONOMY', 2),
(199.99, (select id from flights where id = 1), true, 'ECONOMY', 3),
(199.99, (select id from flights where id = 1), true, 'ECONOMY', 4),
(199.99, (select id from flights where id = 1), true, 'ECONOMY', 5),
(199.99, (select id from flights where id = 1), true, 'ECONOMY', 6),
(199.99, (select id from flights where id = 1), true, 'ECONOMY', 7),
-- 3 business tickets
(799.99, (select id from flights where id = 1), true, 'BUSINESS', 8),
(799.99, (select id from flights where id = 1), true, 'BUSINESS', 9),
(799.99, (select id from flights where id = 1), true, 'BUSINESS', 10);

-- Вставляем билеты для Star Flights (рейс 2)
INSERT INTO tickets (price, flight_id, status, type, place) VALUES
-- 7 economy tickets
(249.99, (select id from flights where id = 2), true, 'ECONOMY', 11),
(249.99, (select id from flights where id = 2), true, 'ECONOMY', 12),
(249.99, (select id from flights where id = 2), true, 'ECONOMY', 13),
(249.99, (select id from flights where id = 2), true, 'ECONOMY', 14),
(249.99, (select id from flights where id = 2), true, 'ECONOMY', 15),
(249.99, (select id from flights where id = 2), true, 'ECONOMY', 16),
(249.99, (select id from flights where id = 2), true, 'ECONOMY', 17),
-- 3 business tickets
(899.99, (select id from flights where id = 2), true, 'BUSINESS', 18),
(899.99, (select id from flights where id = 2), true, 'BUSINESS', 19),
(899.99, (select id from flights where id = 2), true, 'BUSINESS', 20);

-- Вставляем билеты для Global Travel (рейс 3)
INSERT INTO tickets (price, flight_id, status, type, place) VALUES
-- 7 economy tickets
(179.99, (select id from flights where id = 3), true, 'ECONOMY', 21),
(179.99, (select id from flights where id = 3), true, 'ECONOMY', 22),
(179.99, (select id from flights where id = 3), true, 'ECONOMY', 23),
(179.99, (select id from flights where id = 3), true, 'ECONOMY', 24),
(179.99, (select id from flights where id = 3), true, 'ECONOMY', 25),
(179.99, (select id from flights where id = 3), true, 'ECONOMY', 26),
(179.99, (select id from flights where id = 3), true, 'ECONOMY', 27),
-- 3 business tickets
(749.99, (select id from flights where id = 3), true, 'BUSINESS', 28),
(749.99, (select id from flights where id = 3), true, 'BUSINESS', 29),
(749.99, (select id from flights where id = 3), true, 'BUSINESS', 30);