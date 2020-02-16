CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--
DROP TABLE IF EXISTS items;
--
CREATE TABLE items (
    id UUID NOT NULL DEFAULT uuid_generate_v1(),
    content VARCHAR NOT NULL,
    CONSTRAINT items_pk PRIMARY KEY ( id )
);
