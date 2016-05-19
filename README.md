* AUTHOR: TOMMY JONES
* PROJECT: BANDS AND VENUES
* PURPOSE: USERS CAN ENTER BANDS AND VENUES IN A MANY TO MANY RELATIONSHIP IN JAVA.

* DATABASE

* CREATE DATABASE band_tracker;

* CREATE TABLE bands (id serial PRIMARY KEY, name varchar);
* CREATE TABLE venues (id serial PRIMARY KEY, name varchar);
* CREATE TABLE bands_venues (id serial PRIMARY KEY, bandid int, venueid int);

* CREATE DATABASE band_tracker_test WITH TEMPLATE band_tracker;
