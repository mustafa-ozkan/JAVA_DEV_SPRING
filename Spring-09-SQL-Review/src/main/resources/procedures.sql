create or replace procedure update_department(emp_id int)
    language plpgsql
as
$$
declare
begin
    update employees set department = 'Toys' where employee_id = emp_id;
    commit;
end
$$;


call update_department(1);

select *
from employees
where employee_id = 1;

drop function if exists get_department(p_pattern varchar);

--write a query  procedure for changing salaries of two employees
--


create or replace procedure transfer(sender int, receiver int, amount dec)
    language plpgsql
as
$$
declare
begin
    update employees
    set salary = salary - amount
    where employee_id = sender;

    update employees
    set salary = salary + amount
    where employee_id = receiver;
    commit;
end
$$;

select * from employees order by employee_id;

call transfer(1,2,44000);

select * from employees order by employee_id;

drop procedure if exists update_salary_for_two_employee(sender integer, receiver integer, amount numeric);
