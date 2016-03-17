
-- migrate data
UPDATE message SET dataAsDate = to_timestamp(the_date, 'YYYY-MM-DD"T"HH24:MI:SS');
