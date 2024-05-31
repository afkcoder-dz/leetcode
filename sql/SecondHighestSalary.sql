SELECT (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;


SELECT Max(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT Max(salary) FROM Employee));


SELECT Max(salary) AS SecondHighestSalary
FROM (SELECT salary FROM Employee WHERE salary < (SELECT Max(salary) FROM Employee)) AS temp;
