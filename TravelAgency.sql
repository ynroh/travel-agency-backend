CREATE TABLE "users" (
    "id" SERIAL PRIMARY KEY,
    "phone_number" VARCHAR UNIQUE,
    "email" VARCHAR UNIQUE,
    "login" VARCHAR UNIQUE,
    "password" VARCHAR,
    "photo_url" VARCHAR,
    "passports_id" BIGINT
);

CREATE TABLE "passports" (
    "id" BIGINT PRIMARY KEY,
    "last_name" VARCHAR,
    "name" VARCHAR,
    "middle_name" VARCHAR,
    "series" VARCHAR(4),
    "number" VARCHAR(6),
    "issue_date" DATE,
    "who_issued" VARCHAR[],
    "birth_date" DATE
);

CREATE TABLE "passports_trips" (
    "passport_id" BIGINT,
    "trip_id" BIGINT,
    "user_id" BIGINT
);

CREATE TABLE "countries" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(200),
    "cities_id" BIGINT
);

CREATE TABLE "cities" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(200)
);

CREATE TABLE "cities_representatives" (
    "representative_id" BIGINT,
    "city_id" BIGINT
);

CREATE TABLE "tours" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR,
    "country_id" BIGINT,
    "stay_duration" DOUBLE PRECISION
);

CREATE TABLE "route_points" (
    "id" SERIAL PRIMARY KEY,
    "tour_id" BIGINT,
    "title" VARCHAR(250),
    "city_id" BIGINT,
    "stay_duration" DOUBLE PRECISION,
    "excursion_id" VARCHAR,
    "hotel_id" BIGINT
);

CREATE TABLE "excursions" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(250),
    "description" VARCHAR[]
);

CREATE TABLE "hotels" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(250),
    "rating" integer
);

CREATE TABLE "trips" (
    "id" SERIAL PRIMARY KEY,
    "route_id" BIGINT,
    "representative_id" BIGINT,
    "cost" FLOAT,
    "departure_date" DATE,
    "arrival_date" DATE,
    "tourists_count" INTEGER,
    "penalty_amount" FLOAT
);

CREATE TABLE "representatives" (
    "id" SERIAL PRIMARY KEY,
    "last_name" VARCHAR,
    "name" VARCHAR,
    "middle_name" VARCHAR,
    "description" VARCHAR[]
);

ALTER TABLE "users" ADD FOREIGN KEY ("passports_id") REFERENCES "passports" ("id");
ALTER TABLE "countries" ADD FOREIGN KEY ("cities_id") REFERENCES "cities" ("id");
ALTER TABLE "tours" ADD FOREIGN KEY ("country_id") REFERENCES "countries" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("tour_id") REFERENCES "tours" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("city_id") REFERENCES "cities" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("excursion_id") REFERENCES "excursions" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("hotel_id") REFERENCES "hotels" ("id");
ALTER TABLE "trips" ADD FOREIGN KEY ("representative_id") REFERENCES "representatives" ("id");
ALTER TABLE "trips" ADD FOREIGN KEY ("route_id") REFERENCES "tours" ("id");
ALTER TABLE "passports_trips" ADD FOREIGN KEY ("passport_id") REFERENCES "passports" ("id");
ALTER TABLE "passports_trips" ADD FOREIGN KEY ("trip_id") REFERENCES "trips" ("id");
ALTER TABLE "passports_trips" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "cities_representatives" ADD FOREIGN KEY ("representative_id") REFERENCES "representatives" ("id");
ALTER TABLE "cities_representatives" ADD FOREIGN KEY ("city_id") REFERENCES "cities" ("id");
--ALTER TABLE "representatives" ADD FOREIGN KEY ("cities_id") REFERENCES "cities" ("id");