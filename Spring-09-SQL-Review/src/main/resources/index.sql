SELECT *
FROM departments;
SELECT *
FROM employees;
SELECT *
FROM regions;
SELECT employee_id, first_name, department
FROM employees;
SELECT *
FROM employees
WHERE department = 'Sports';
SELECT *
FROM employees
WHERE department LIKE '%nit%';
SELECT *
FROM employees
WHERE department LIKE 'F%nit%';
SELECT *
FROM employees
WHERE salary > 100000;
SELECT *
FROM employees
WHERE salary < 100000;
SELECT *
FROM employees
WHERE salary >= 100000;
SELECT *
FROM employees
WHERE salary <= 100000;
SELECT *
FROM employees
WHERE department = 'Clothing'
  AND salary > 90000;
SELECT *
FROM employees
WHERE department = 'Clothing'
  AND salary > 90000
  AND region_id = 2;
SELECT *
FROM employees
WHERE department = 'Clothing'
   OR salary > 90000;
SELECT *
FROM employees
WHERE salary < 40000
  AND (department = 'Clothing'
    OR department = 'Pharmacy');
SELECT *
FROM employees
WHERE department != 'Sports';
SELECT *
FROM employees
WHERE department <> 'Sports';
SELECT *
FROM employees
WHERE NOT department <> 'Sports';
SELECT *
FROM employees
WHERE email IS NULL;
SELECT *
FROM employees
WHERE email IS NOT NULL;
SELECT *
FROM employees
WHERE department = 'Sports'
   OR department = 'First Aid'
   OR department = 'Toys'
   OR department = 'Garden';
SELECT *
FROM employees
WHERE department IN ('Sports', 'First Aid', 'Toys');
SELECT *
FROM employees
WHERE salary BETWEEN 80000 AND 100000;

--write a query that returns the first name and email of females that work in the tools department
--having a salary greater than 110000

select first_name, email, salary, department
from employees
where gender = 'F'
  and department = 'Tools'
  and salary > 110000;

--write a query that returns the first name and hire date of those employees who earn more than 165000
--as well as those employees that work in the sports department and also happen to be man

select *
from employees
where salary > 165000
   or (department = 'Sports' and gender = 'M');

select *
from employees
order by employee_id desc;

select distinct department
from employees;

select distinct department
from employees
    fetch first 3 rows only;

select salary as yearly_salary
from employees;

--write a query that displays the name and ages of the top 4 oldest students

select *
from students
order by age desc fetch first 4 rows only;

--write a query that returns students based on the following criteria:
--The student must not be older than age 20 if their student_no is either between 3 and 5
--or their student_no is 7. your query should also return students older than age 20 nbut in case they must
--have a student _no that is at least 4.

select *
from students
where (age <= 20 and (student_no between 3 and 5 or student_no = 7))
   or (student_no >= 4 and age > 20);

select upper(first_name) FIRST_NAME, lower(department) DEPARTMENT
from employees;

select length(first_name)
from employees;

select ('     Hello There    ') with_spaces, trim('     Hello There    ') trimmed;

select first_name || ' ' || last_name full_name
from employees;

select salary > 140000 high_paid
from employees
order by salary desc;

select department, (department LIKE '%oth%')
from employees;

select 'This is test data' test_data;

select SUBSTRING('This is test data' from 1 for 4) as test_data;

select SUBSTRING('This is test data' from 9) as test_data;

select department, replace(department, 'Clothing', 'Clothes')
from employees;

select MAX(salary)
from employees;

select MIN(salary)
from employees;

SELECT avg(salary)
from employees;

select round(avg(salary))
from employees;

select count(employee_id)
from employees;

select count(email)
from employees;

select sum(salary)
from employees
where department = 'Clothing';

--write a query that returns all of the records and columns from the professors table
--but shortens the department names to only the first 3 characters and in upper case

select last_name, upper(substr(department, 1, 3)) dept, salary, hire_date
from professors;

--write a query that returns the highest and lowest salary from the professors table and
--exclude professor named  'Wilson'

select 'Highest Salary', max(salary), 'Lowest Salary', min(salary)
from employees
where last_name != 'Wilson';

select department, count(*)
from employees
group by department;


select sum(salary)        as total_salary,
       min(salary)        as min_salary,
       max(salary)        as max_salary,
       avg(salary)        as avg_salary,
       round(avg(salary)) as roundAvg_salary,
       count(*)              number_off_employees,
       department
from employees
group by department;

select sum(salary) as total_salary, department
from employees
where region_id in (4, 5, 6, 7)
group by department;

select department, count(*) as count
from employees
group by department
having count(*) < 36
order by count desc;

--show all unique email domain and number of employees

select count(*), substr(email, position('@' in email) + 1) email_domain
from employees
where email is not null
group by email_domain;

select d.department
from employees e,
     departments d;

select distinct (department)
from employees
where department not in (
    select department
    from departments);

select count(department) count_dept
from employees
where department not in (
    select department
    from departments);

select *
from (select * from employees where salary > 150000) a;

select first_name, last_name, salary, (select count(first_name) from employees)
from employees;

--return all employees that work in electronic division

select *
from departments;

select *
from employees
where department in (select department from departments where division = 'Electronics');

--return all employees from asia or canada and make more than 130000

select *
from regions;

select *
from employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'));

--return first name who works in Asia and Canada, and how much  less making from the highest employee in the company

select first_name, (select max(salary) from employees) - salary
from employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'));

--write a query that retursn all of those employees that work in the kids division and
-- the dates at which those employees were hired is greater than all of the hire dates of employees
-- who work in the maintenance department

select *
from employees
where department = any (select department from departments where division = 'Kids')
  and hire_date > ALL (select hire_date from employees where department = 'Maintenance');


--write a query that returns the names of those students that are taking the courses Physics and US History

select *
from students
where student_no in (select student_no
                     from student_enrollment
                     where course_no
                               in (select course_no
                                   from courses
                                   where course_title
                                             in ('Physics', 'US History')
                           ));


select first_name,
       salary,
       case
           when salary < 100000 then 'UNDER PAID'
           when salary > 10000 then 'PAID WELL'
           else 'UNPAID'
           end as category
from employees;

select category, count(*)
from (select first_name,
             case
                 when salary < 100000 then 'UNDER PAID'
                 when salary > 100000 and salary < 160000 then 'PAID WELL'
                 else 'EXECUTIVE'
                 end as category
      from employees) a
group by category;

select first_name, country
from employees e,
     regions r
where e.region_id = r.region_id;


select first_name, email, d.department, division
from employees e,
     departments d,
     regions r
where e.department = d.department
  and e.region_id = r.region_id;

select first_name, country
from employees
         inner join regions r
                    on employees.region_id = r.region_id



EXPLAIN ANALYZE
select *
from towns
where name = '5ea33c48f94d370114a69fc7ace216b4';
-- and article ='72c33948a5aefea7ce2477496209ca79';

EXPLAIN ANALYZE
select *
from towns
where id = '457';

create index idx_towns_name on towns(name);
drop index if exists idx_towns_name;

SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;