# Write your MySQL query statement below
select 
distinct d.name as Department,e.name as Employee,e.Salary
from employee e 
inner join department d 
on e.departmentId=d.id 
where
(e.departmentId,e.salary) in (select departmentId,max(salary) 
from employee group by departmentId) 


