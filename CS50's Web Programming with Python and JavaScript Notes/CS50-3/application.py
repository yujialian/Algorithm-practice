from flask import Flask, render_template, request
app=Flask(__name__)
#I want create new webapplication, it's a flask webapp, __name__ means current file
@app.route("/")
def sta():
    return "hello world!"
@app.route("/david")
def david():
    return "hello yujia!"
@app.route("/<string:name>")
def hello(name):
    name=name.capitalize()
    return "hello, {name}!".format(name=name)
#The letter “f” indicates that these strings are used for formatting.
@app.route("/index")
def index():
    return render_template("index.html")

@app.route("/hello", methods=["POST"])
def hello():
    name = request.form.get("name")
    return render_template("hello.html", name=name)
