CREATE TABLE "users" (
    "id" SERIAL PRIMARY KEY,
    "phone_number" VARCHAR UNIQUE,
    "email" VARCHAR UNIQUE,
    "username" VARCHAR UNIQUE,
    "password" VARCHAR,
    "photo_url" VARCHAR
);

CREATE TABLE "passports" (
    "id" SERIAL PRIMARY KEY,
    "user_id" SERIAL,
    "last_name" VARCHAR,
    "name" VARCHAR,
    "middle_name" VARCHAR,
    "series" VARCHAR(4),
    "number" VARCHAR(6),
    "issue_date" DATE,
    "who_issued" TEXT,
    "birth_date" DATE
);

CREATE TABLE "passports_trips" (
    "passport_id" SERIAL,
    "trip_id" SERIAL,
    "user_id" SERIAL
);

CREATE TABLE "countries" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(200),
    "cities_id" SERIAL
);

CREATE TABLE "cities" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(200)
);

CREATE TABLE "cities_representatives" (
    "representative_id" SERIAL PRIMARY KEY,
    "city_id" SERIAL
);

CREATE TABLE "tours" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR,
    "country_id" SERIAL,
    "representative_id" SERIAL,
    "stay_duration" DOUBLE PRECISION,
    "cost" DECIMAL,
    "photos_url" TEXT[]
);

CREATE TABLE "route_points" (
    "id" SERIAL PRIMARY KEY,
    "tour_id" SERIAL,
    "title" VARCHAR(250),
    "city_id" SERIAL,
    "stay_duration" DOUBLE PRECISION,
    "excursion_id" SERIAL,
    "hotel_id" SERIAL
);

CREATE TABLE "excursions" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(250),
    "description" TEXT
);

CREATE TABLE "hotels" (
    "id" SERIAL PRIMARY KEY,
    "title" VARCHAR(250),
    "rating" integer
);

CREATE TABLE "trips" (
    "id" SERIAL PRIMARY KEY,
    "tour_id" SERIAL,
    "cost" DECIMAL,
    "departure_date" DATE,
    "arrival_date" DATE,
    "tourists_count" INTEGER,
    "penalty_amount" DECIMAL
);

CREATE TABLE "representatives" (
    "id" SERIAL PRIMARY KEY,
    "last_name" VARCHAR,
    "name" VARCHAR,
    "middle_name" VARCHAR,
    "description" TEXT
);

CREATE TABLE "refresh_tokens" (
    "id" SERIAL PRIMARY KEY,
    "user_id" SERIAL,
    "token" varchar UNIQUE,
    "expiry_date" TIMESTAMP WITHOUT TIME ZONE
);

ALTER TABLE "passports" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "refresh_tokens" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "countries" ADD FOREIGN KEY ("cities_id") REFERENCES "cities" ("id");
ALTER TABLE "tours" ADD FOREIGN KEY ("country_id") REFERENCES "countries" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("tour_id") REFERENCES "tours" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("city_id") REFERENCES "cities" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("excursion_id") REFERENCES "excursions" ("id");
ALTER TABLE "route_points" ADD FOREIGN KEY ("hotel_id") REFERENCES "hotels" ("id");
ALTER TABLE "tours" ADD FOREIGN KEY ("representative_id") REFERENCES "representatives" ("id");
ALTER TABLE "trips" ADD FOREIGN KEY ("tour_id") REFERENCES "tours" ("id");
ALTER TABLE "passports_trips" ADD FOREIGN KEY ("passport_id") REFERENCES "passports" ("id");
ALTER TABLE "passports_trips" ADD FOREIGN KEY ("trip_id") REFERENCES "trips" ("id");
ALTER TABLE "passports_trips" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "cities_representatives" ADD FOREIGN KEY ("representative_id") REFERENCES "representatives" ("id");
ALTER TABLE "cities_representatives" ADD FOREIGN KEY ("city_id") REFERENCES "cities" ("id");
--ALTER TABLE "representatives" ADD FOREIGN KEY ("cities_id") REFERENCES "cities" ("id");