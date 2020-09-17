CREATE TABLE VEHICLE(
    id bigint primary key,
    make varchar (10),
    model varchar (10),
    owner varchar (50),
    vehiclekind int,
    registrationDate timestamp
);

CREATE TABLE VEHICLE_LOCATION(
    id bigint primary key,
    location point,
    vehicleId bigint references VEHICLE(id),
    vehicleTime timestamp,
    logTime timestamp
);

CREATE INDEX GEO ON VEHICLE_LOCATION USING GiST (location);

CREATE SEQUENCE vehicle_seq START 1;
CREATE SEQUENCE vehicle_location_seq START 1;
