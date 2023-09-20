CREATE TYPE "role" AS ENUM (
    'CLIENT',
    'REPRESENTATIVE'
    );

CREATE TABLE "users" (
    "id" SERIAL PRIMARY KEY,
    "role" role,
    "full_name" VARCHAR,
    "password" VARCHAR
);

CREATE TABLE "clients" (
    "id" SERIAL PRIMARY KEY,
    "photo_url" VARCHAR,
    "user_id" BIGINT
);

CREATE TABLE "passports" (
    "id" SERIAL PRIMARY KEY,
    "series" VARCHAR(4),
    "number" VARCHAR(6),
    "issue_date" DATE,
    "who_issued" VARCHAR[],
    "birth_date" DATE
);

CREATE TABLE "countries" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(200)
);

CREATE TABLE "hotels" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(250),
    "rating" integer
);

CREATE TABLE "route_points" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(250),
    "stay_duration" DOUBLE PRECISION,
    "tour_name" VARCHAR,
    "hotel_id" BIGINT
);

CREATE TABLE "routes" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR,
    "country_id" BIGINT,
    "stay_duration" DOUBLE PRECISION,
    "route_points_id" BIGINT
);

CREATE TABLE "representatives" (
    "id" SERIAL PRIMARY KEY,
    "user_id" BIGINT
);

CREATE TABLE "trips" (
    "id" SERIAL PRIMARY KEY,
    "route_id" BIGINT,
    "representative_id" BIGINT,
    "cost" FLOAT,
    "departure_date" DATE,
    "arrival_date" DATE,
    "tourists_count" INTEGER,
    "clients_id" BIGINT,
    "penalty_amount" FLOAT
);

ALTER TABLE "clients" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("hotel_id") REFERENCES "hotels" ("id");
ALTER TABLE "routes" ADD FOREIGN KEY ("country_id") REFERENCES "countries" ("id");
ALTER TABLE "routes" ADD FOREIGN KEY ("route_points_id") REFERENCES "routes" ("id");
ALTER TABLE "representatives" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "trips" ADD FOREIGN KEY ("route_id") REFERENCES "routes" ("id");
ALTER TABLE "trips" ADD FOREIGN KEY ("representative_id") REFERENCES "representatives" ("id");
ALTER TABLE "trips" ADD FOREIGN KEY ("clients_id") REFERENCES "clients" ("id");