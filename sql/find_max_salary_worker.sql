SELECT name, salary
FROM worker
WHERE salary IN(
	SELECT MAX(salary)
	FROM worker
);