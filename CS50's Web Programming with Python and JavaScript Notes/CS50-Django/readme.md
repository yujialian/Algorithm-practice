# Django
```
Flask: quick, few lines of code set up web application, control routes, light weight.
When application getting big, flask becomes frustrated to have to deal with complexities, try to build things for yourself.
```

Start project: django-admin startproject projectname

manage.py

projectname(directory):
```
__init__.py: Tell that projectname directory is a python package.(Collection of different python files group together for some purpose.)

manage.py: Python script inorder to perform operations on the application

settings.py: All the settings for the webapplication.(Exp: Time zone, Database)

urls.py: Active the file that takes care of determine what routes the users can go to.

wsgi.py: deploy

python managy.py startapp helloworld

helloworld folder: name of app we created.

views.py: just like flask's application.py, writing code, decide what user sees.

```
django db models:

```
As application becomes complicated, modification can be a problem (modify the column of tables, change the table modify the relationship between them). Have to use command like alter table. Django use migrations, to solve the problem for us. Everytime we modify the change to models.py file, automatically generate the sql code neccesary to run the database make the neccesary changes.
 ```
python manage.py makemigrations:
python manage.py migrates
```
look through the model files look changes been made on those model files, and automatically generate migration, which is changes going to made on the database, in inorder to make the changes made on the models file effective in database.
```
python manage.py sqlmigrate flights 0001
```
0001 migration number's sql code.
```
Django shell:
```
python manage.py shell
```
