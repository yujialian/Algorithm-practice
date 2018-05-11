from django.db import models
#As application becomes complicated, modification can be a problem(modify the column of tables, change the table
#modify the relationship between them. Have to use command like alter table.Django use migrations, to solve the
#problem for us.Everytime we modify the change to models.py file, automatically generate the sql code neccesary
#to run on the database in order to allow the changes happen in the database.)
# Create your models here.
class Airport(models.Model):
    code = models.CharField(max_length=3)
    city = models.CharField(max_length=64)
    def __str__(self):#what the object should look like, when it print out on the screen
        #triggered when do: Airport.objects.all()
        #get first: Flight.objects.first()
        return f"{self.city} ({self.code})"

class Flight(models.Model):
    #on_delete: what if happens if I delete a airport.
    #models.CASCADE: if I delete air port that have particular origin.
    #related_name: if I have an airport, i want to access all the flights who's origin is that
    #airport, I can use departures to access that.
    #Airport.departure.all() or Airport.arrivals.all()
    
    origin = models.ForeignKey(Airport, on_delete=models.CASCADE, related_name="departures")
    destination = models.ForeignKey(Airport, on_delete=models.CASCADE, related_name="arrivals")
    duration = models.IntegerField()
    def __str__(self):
        return f"{self.id} - {self.origin} to {self.destination}"

class Passenger(models.Model):
    first = models.CharField(max_length=64)
    last = models.CharField(max_length=64)
    flights = models.ManyToManyField(Flight, blank=True, related_name="passengers")
    def __str__(self):
        return f"{self.first} {self.last}"
