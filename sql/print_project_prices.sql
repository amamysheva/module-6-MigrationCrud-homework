SELECT p.name, SUM(salary)*DATEDIFF(MONTH, start_date, finish_date) AS price
FROM project p
JOIN project_worker ON p.id = project_worker.project_id
JOIN worker ON project_worker.worker_id = worker.id
GROUP BY p.name
ORDER BY price DESC;