# Write your MySQL query statement below
select MAX(salary) SecondHighestSalary from Employee where salary<(select Max(salary)  from Employee);