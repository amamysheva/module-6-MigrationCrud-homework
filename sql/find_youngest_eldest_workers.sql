SELECT 'YOUNGEST' type, name, birthday 
FROM worker
WHERE birthday = (
	SELECT MAX (birthday)
	FROM worker
)
UNION
SELECT 'ELDEST' type, name, birthday 
FROM worker
WHERE birthday = (
	SELECT MIN (birthday)
	FROM worker
)
ORDER BY birthday DESC;