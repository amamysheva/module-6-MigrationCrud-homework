SELECT name, DATEDIFF(MONTH, start_date, finish_date) AS month_count
FROM project
GROUP BY name
HAVING month_count IN (
	SELECT MAX(month_count)
	FROM (
		SELECT DATEDIFF(MONTH, start_date, finish_date) AS month_count
		FROM project
		GROUP BY id
	)
);