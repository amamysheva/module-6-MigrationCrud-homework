CREATE TABLE IF NOT EXISTS worker (
id IDENTITY PRIMARY KEY,
name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2),
birthday DATE CHECK (birthday > '1900-12-31'),
level VARCHAR(100) NOT NULL CHECK level IN ('Trainee', 'Junior', 'Middle', 'Senior'),
salary INT CHECK (salary >= 100 AND salary <= 100000)
);

CREATE TABLE IF NOT EXISTS client (
id IDENTITY PRIMARY KEY,
name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2)
);

CREATE TABLE IF NOT EXISTS project (
id IDENTITY PRIMARY KEY,
name VARCHAR(100) NOT NULL,
client_id BIGINT NOT NULL,
start_date DATE,
finish_date DATE,
CONSTRAINT client_id_fk FOREIGN KEY (client_id) REFERENCES client (id),
CONSTRAINT project_duration CHECK DATEDIFF(MONTH, start_date, finish_date) BETWEEN 1 AND 100
);

CREATE TABLE IF NOT EXISTS project_worker (
project_id BIGINT NOT NULL,
worker_id BIGINT NOT NULL,
PRIMARY KEY(project_id, worker_id),
FOREIGN KEY(project_id) REFERENCES project(id),
FOREIGN KEY(worker_id) REFERENCES worker(id)
);