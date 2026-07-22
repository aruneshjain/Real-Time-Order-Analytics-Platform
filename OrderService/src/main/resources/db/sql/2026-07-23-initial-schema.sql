-- ============================
-- Schema for Real-Time Analytics Platform
-- Created: 2026-07-23
-- ============================

-- 1. Orders Table
CREATE TABLE IF NOT EXISTS orders (
    order_id      VARCHAR(50) PRIMARY KEY,
    product_id    VARCHAR(50) NOT NULL,
    amount        NUMERIC(10,2) NOT NULL,
    order_time    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Dummy Orders
INSERT INTO orders (order_id, product_id, amount, order_time) VALUES
('ORD001', 'P001', 1200.50, '2026-07-22 10:15:00'),
('ORD002', 'P002', 800.00, '2026-07-22 10:20:00'),
('ORD003', 'P003', 1500.75, '2026-07-22 10:25:00'),
('ORD004', 'P004', 450.00, '2026-07-22 10:30:00'),
('ORD005', 'P005', 999.99, '2026-07-22 10:35:00');

-- 2. Order Metrics Table
CREATE TABLE IF NOT EXISTS order_metrics (
    metric_id     SERIAL PRIMARY KEY,
    metric_date   DATE NOT NULL,
    total_orders  INT NOT NULL,
    total_revenue NUMERIC(12,2) NOT NULL,
    top_product   VARCHAR(50)
);

-- Dummy Metrics
INSERT INTO order_metrics (metric_date, total_orders, total_revenue, top_product) VALUES
('2026-07-22', 5, 4951.24, 'P003'),
('2026-07-21', 8, 7200.00, 'P001');

-- 3. Alerts Table
CREATE TABLE IF NOT EXISTS alerts (
    alert_id      SERIAL PRIMARY KEY,
    alert_type    VARCHAR(50) NOT NULL,
    description   TEXT NOT NULL,
    created_at    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Dummy Alerts
INSERT INTO alerts (alert_type, description, created_at) VALUES
('ANOMALY', 'Sudden drop in orders detected', '2026-07-22 11:00:00'),
('REVENUE_SPIKE', 'Revenue exceeded threshold in last hour', '2026-07-22 12:00:00');

-- 4. Products Table
CREATE TABLE IF NOT EXISTS products (
    product_id    VARCHAR(50) PRIMARY KEY,
    product_name  VARCHAR(100) NOT NULL,
    category      VARCHAR(50),
    price         NUMERIC(10,2)
);

-- Expanded Dummy Products
INSERT INTO products (product_id, product_name, category, price) VALUES
('P001', 'Smartphone X', 'Electronics', 1200.50),
('P002', 'Wireless Headphones', 'Electronics', 800.00),
('P003', 'Laptop Pro', 'Computers', 1500.75),
('P004', 'Smartwatch Z', 'Wearables', 450.00),
('P005', 'Gaming Console Y', 'Entertainment', 999.99),
('P006', 'Bluetooth Speaker', 'Electronics', 299.00),
('P007', '4K LED TV', 'Home Appliances', 2200.00),
('P008', 'Tablet Mini', 'Computers', 650.00),
('P009', 'DSLR Camera', 'Photography', 1800.00),
('P010', 'Air Purifier', 'Home Appliances', 400.00);

