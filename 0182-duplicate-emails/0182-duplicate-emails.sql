# Write your MySQL query statement below
SELECT 
    email
FROM 
    person as p 
GROUP BY
    email
HAVING
    count(*)>1