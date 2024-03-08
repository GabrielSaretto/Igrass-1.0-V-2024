use igrass;
-- Tabela para armazenar informações de usuários (clientes e prestadores de serviços)
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role ENUM('CLIENT', 'PROVIDER') NOT NULL -- Papel do usuário: cliente ou prestador de serviço
);

-- Tabela para armazenar informações de serviços de corte de grama
CREATE TABLE lawn_services (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    provider_id INT NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    location VARCHAR(255) NOT NULL,
    FOREIGN KEY (provider_id) REFERENCES users(user_id)
);

-- Tabela para armazenar informações de pedidos
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    service_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('PENDING', 'ACCEPTED', 'COMPLETED', 'CANCELLED') NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES users(user_id),
    FOREIGN KEY (service_id) REFERENCES lawn_services(service_id)
);

-- Tabela para armazenar informações de avaliações
CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    rating INT NOT NULL,
    comment TEXT,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);
