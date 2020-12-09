

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