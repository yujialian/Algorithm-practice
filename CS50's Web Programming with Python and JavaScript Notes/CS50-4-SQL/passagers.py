import os
from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker

engine = create_engine(os.getenv("DATABASE_URL"))
db = scoped_session(sessionmaker(bind=engine))

def main():
    flights = db.execute(
    "SELECT origin, destination, duration FROM flights;"
    ).fetchall() #get all results (lists)
    #List all flights
    for flight in flights:
        print(f"{flight.origin} to {flight.destination}, {flight.duration} minutes.")
    #Prompt user to choose a flight
    flight_id = int(input("\nFlight ID:"))
    flight = db.execute("SELECT origin, destination, duration FROM flights WHERE id = :id",
    {"id:": flight_id}).fetchone()
    #make sure id is valid
    if flight is None:
        print("Error! not such flight!")
        return
    passengers = db.execute("SELECT name FROM passengers WHERE flight_id = :flight_id",
        {"flight_id": flight_id}).fetchall()
    )
    for passenger in passengers:
        print(passenger.name)
    if len(passengers) == 0:
        print("No passengers in this flight currently.")
    )
