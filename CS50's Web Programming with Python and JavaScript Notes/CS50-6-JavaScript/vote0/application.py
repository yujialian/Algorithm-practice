import os
import requests

from flask import Flask, jsonify, render_template, request
from flask_socketio import SocketIO, emit

app = Flask(__name__)
app.config["SECRET_KEY"] = os.getenv("SECRET_KEY")
socketio = SocketIO(app)#Use websockets inside a web application
#Webserver and web client sending(emiting) events broadcast to everyone else, they are going to listening events, recieving events.
@app.route("/")
def index():
    return render_template("index.html")

@socketio.on("submit vote")#When the socket io detects "submit vote" event, here's you should do
def vote(data):
    selection = data["selection"]
    emit("announce vote", {"selection": selection}, broadcast=True)
    #Emit to anyother sockets that are currently listening
