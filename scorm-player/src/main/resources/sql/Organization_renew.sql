DROP TABLE IF EXISTS Organization CASCADE;

CREATE TABLE Organization
(
  id serial,
  organizationID text NOT NULL,
  packageID integer NOT NULL,
  title text,
  CONSTRAINT Organization_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

ALTER TABLE Organization ADD CONSTRAINT Organization_fk1 FOREIGN KEY (packageID) REFERENCES Package(id);