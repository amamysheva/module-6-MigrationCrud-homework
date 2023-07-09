SELECT c.name, count(project.id) AS project_count
FROM client c
JOIN project ON c.id = project.client_id
GROUP BY c.name
HAVING project_count IN (
	SELECT MAX(project_count) 
	FROM (
		SELECT count(id) AS project_count 
		FROM project 
		GROUP BY client_id
	)
);