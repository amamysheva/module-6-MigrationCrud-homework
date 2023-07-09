INSERT INTO worker (name, birthday, level, salary)
VALUES 
	('Name_1', '1998-04-14', 'Trainee', 500), 
	('Name_2', '1989-01-18', 'Junior', 1200), 
	('Name_3', '1994-06-06', 'Middle', 2300), 
	('Name_4', '1985-12-24', 'Senior', 6500), 
	('Name_5', '2005-11-11', 'Trainee', 400), 
	('Name_6', '1995-05-25', 'Junior', 900), 
	('Name_7', '2000-09-12', 'Middle', 1800), 
	('Name_8', '1992-02-28', 'Senior', 6500), 
	('Name_9', '2001-08-11', 'Trainee', 550), 
	('Name_10', '1988-07-30', 'Junior', 850);
	
INSERT INTO client (name)
VALUES
	('Client_1'),
	('Client_2'),
	('Client_3'),
	('Client_4'),
	('Client_5');
	
INSERT INTO project (name, client_id, start_date, finish_date)
VALUES
	('Project A', 1, '2023-01-20', '2023-03-22'),
	('Project B', 3, '2023-01-20', '2023-04-21'),
	('Project C', 2, '2023-01-20', '2023-05-03'),
	('Project D', 3, '2023-01-20', '2023-12-01'),
	('Project E', 4, '2023-01-20', '2023-07-01'),
	('Project F', 5, '2023-01-20', '2023-08-16'),
	('Project G', 5, '2023-01-20', '2023-09-02'),
	('Project H', 5, '2023-01-20', '2023-10-26'),
	('Project I', 3, '2023-01-20', '2023-11-12'),
	('Project J', 1, '2023-01-20', '2023-12-25');
	
INSERT INTO project_worker (project_id , worker_id)
VALUES
	(1, 3),
	(1, 2),
	(2, 3),
	(3, 4),
	(4, 4),
	(5, 3),
	(6, 7),
	(7, 8),
	(7, 6),
	(7, 10),
	(8, 10),
	(9, 2),
	(10, 7);