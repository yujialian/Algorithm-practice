Data types:
```
Integer
Decimal
Serial
Varchar
Timestamp
Boolean
Enum
...
```
Constraints:
```
Not null
Unique
Primary key
Default
Check
...
```
INSERT INTO flights (origin, destination, duration) VALUES ('NEW YORK', 'LONDON', 415)

SELECT * FROM flights WHERE origin IN ('NEW YORK', 'LIMA')

SELECT * FROM flights WHERE origin LIKE '%a%';
```
% can represent any text here as a placeholder.
```
Functions
```
SUM, COUNT, MIN, MAX, AVG...
```

```
UPDATE:
UPDATE flights SET duration = 430 WHERE origin = 'New York' AND destination = 'LONDON';

DELETE:
DELETE FROM countries WHERE destination = 'Tokyo';

GROUP BY:
SELECT ORIGIN, COUNT(*) FROM flights GROUP BY origin;

HAVING:
SELECT ORIGIN, COUNT(*) FROM flights GROUP BY origin HAVING COUNT(*) > 1;
```
Foreign keys
```
CREATE TABLE passengers (
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  flight_id INTEGER REFERENCES flights
  );

References: help to enforce constraints to make sure I can't do something wrong.

INSERT INTO passengers (name, flight_id) VALUES ('Alice', 1);
...

SELECT origin, destination, name FROM flights JOIN passengers ON passengers.flight_id = flights.id;

SELECT origin, destination, name FROM flights JOIN passengers ON passengers.flight_id = flights.id WHERE NAME = 'Alice';

Create Index

Nested query:
SELECT * FROM flights WHERE id IN (SELECT flight_id FROM passengers GROUP BY flight_id HAVING COUNT(*) > 1);
```
SQL Injection:
```
Username
Password
```
Race Conditions
```
SELECT balance FROM bank WHERE user_id=1;
UPDATE bank SET balance = balance - 100 WHERE user_id = 1;
If both draw $100 from bank:

Concurrency solution:
SQL Transaction:
Syntax:
Begin--
Commit--
```
SQLALchemy: Connect python with sql
```
Allow python code to be able to run sql queries.






```
