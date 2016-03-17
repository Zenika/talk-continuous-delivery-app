
-- the table !
CREATE TABLE message
(
  id       BIGINT PRIMARY KEY NOT NULL,
  the_date VARCHAR(255),
  message  VARCHAR(255),
  owner    VARCHAR(255)
);

-- magic counter
CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;
  ALTER TABLE hibernate_sequence
  OWNER TO postgres;
