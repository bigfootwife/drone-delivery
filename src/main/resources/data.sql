-- ==============================
-- 📌 CREATE DATABASE (Optional in H2)
-- ==============================
CREATE SCHEMA IF NOT EXISTS droneDB;

-- ==============================
-- 📌 DROP TABLES (IF EXIST) - Ensures a fresh start
-- ==============================
DROP TABLE IF EXISTS medication;
DROP TABLE IF EXISTS drone;

-- ==============================
-- 📌 CREATE DRONE TABLE
-- ==============================
CREATE TABLE drone (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       serial_number VARCHAR(100) UNIQUE NOT NULL,
                       model ENUM('LIGHTWEIGHT', 'MIDDLEWEIGHT', 'CRUISERWEIGHT', 'HEAVYWEIGHT') NOT NULL,
                       weight_limit INT CHECK (weight_limit <= 1000), -- Max weight 1000g
                       battery_capacity INT CHECK (battery_capacity BETWEEN 0 AND 100), -- 0-100%
                       state ENUM('IDLE', 'LOADING', 'LOADED', 'DELIVERING', 'DELIVERED', 'RETURNING') NOT NULL
);

-- ==============================
-- 📌 CREATE MEDICATION TABLE
-- ==============================
-- Allowed: letters, numbers, -, _
-- Ensure positive weight
-- Only uppercase letters, numbers, and _
-- Stores image URL/path
CREATE TABLE medication (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL CHECK (name ~ '^[a-zA-Z0-9-_]+$'),
    weight INT NOT NULL CHECK (weight > 0),
    code VARCHAR(50) UNIQUE NOT NULL CHECK (code ~ '^[A-Z0-9_]+$'),
    image_url VARCHAR(500)
);

-- Preloading Drones
INSERT INTO drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('DRONE1001', 'LIGHTWEIGHT', 500, 80, 'IDLE'),
       ('DRONE1002', 'MIDDLEWEIGHT', 800, 50, 'IDLE'),
       ('DRONE1003', 'HEAVYWEIGHT', 1000, 90, 'IDLE');

-- Preloading Medications
INSERT INTO medication (name, weight, code, image_url)
VALUES ('Paracetamol', 200, 'MED_001', 'sample1.jpg'),
       ('Ibuprofen', 250, 'MED_002', 'sample2.jpg'),
       ('Insulin', 300, 'MED_003', 'sample3.jpg');
