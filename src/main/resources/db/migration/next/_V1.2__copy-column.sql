
-- migrate data
UPDATE message SET date_as_date = to_timestamp(the_date, 'YYYY-MM-DD"T"HH24:MI:SS');
