-- schema.sql
CREATE SCHEMA IF NOT EXISTS franquicias_schema;

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE franquicias_schema.franquicia (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE franquicias_schema.sucursal (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre VARCHAR(100) NOT NULL,
    franquicia_id UUID NOT NULL,
    CONSTRAINT fk_franquicia FOREIGN KEY (franquicia_id)
        REFERENCES franquicias_schema.franquicia(id) ON DELETE CASCADE
);

CREATE TABLE franquicias_schema.producto (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre VARCHAR(100) NOT NULL,
    precio NUMERIC(10, 2) NOT NULL,
    sucursal_id UUID NOT NULL,
    CONSTRAINT fk_sucursal FOREIGN KEY (sucursal_id)
        REFERENCES franquicias_schema.sucursal(id) ON DELETE CASCADE
);
