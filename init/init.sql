CREATE USER weather WITH PASSWORD 'weather';
CREATE DATABASE weather_db OWNER weather;
GRANT ALL PRIVILEGES ON DATABASE weather_db TO weather;
