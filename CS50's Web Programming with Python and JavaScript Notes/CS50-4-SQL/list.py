import os
from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker

engine = create_engine(os.getenv("DATABASE_URL"))
#Engine that is a object create by sqlalchemy use to manage connection
#to the database. Process of communication with database, python send command
#to the db and get result from db.
#os.getenv("DATABASE_URL"): get Environment variable. URL where database locate.
db = scoped_session(sessionmaker(bind=engine))
#Create a scope session, make sure what person A doing with db separate person B
#doing with database.
def main():
    flights = db.execute(
    "SELECT origin, destination, duration FROM flights;"
    ).fetchall() #get all results (lists)
    for flight in flights:
        print(f"{flight.origin} to {flight.destination}, {flight.duration} minutes.")

if __name__ == "__main__":
    main()
