### Git:

Branching: Maintain one master branch, other branch working on different features.

Start new feature in a branch, keep working on new feature, find bug in master branch, fig bug and merge with.

git commit -am(combine the git add step and git commit step into one step.) "add another line."

git branch branch name:
```
Add new branch
```
git log:
```
show the history of commit made in a particular branch.
```
git merge feature:
```
take the commits on the feature branch, merge them into master branch.
```
git checkout feature:
```
Switch to feature branch.
```
git push --set-upstream origin feature
```
You create a feature branch locally, but you haven't push it in GitHub yet, so you can set up a new branch on GitHub and upload your branch, otherwise if trying to push in master branch, will encounter error.
```
1. git fetch
```
goto remote, download the latest commit.
```
2. git merge origin master
```
update the current master branch to the latest version of origin.
1 and 2 can be together using git pull
```
3. git fork
```
take the original repository, make necessary changes(if any), merge back to the original code.
If like to merge with original version of code.
can submit with pull requests
```

### HTML 5:

#### HTML 5 Organization:
```
<header>
<nav>
<section>
<footer>
```
#### New HTML5 Elements:
```
<audio>
<video>
<datalist>
...
```
### CSS
#### css selectors:
```
a,b: Multiple element selector;
a b: Decendant selector;
a > b: Child selector;
a + b: Adjacent sibling selector
[a = b]: Attribute selector
a:b: Pseudoclass selector
a::b: Pseudoelement selector
```
### Response design
#### View point:
#### Media Queries:
Assign CSS not to a particular html element, but to a particular HTML element on a particular type of media.(type of media can be size of a phone/PC)
#### Flexbox
#### Grids

### Sass:
Extension to css, give us power and flexibility when it comes to design css.
Make it easier to generate the stylesheet we want to generate

Sass can watch a file, anytime the file changes, automatically recompile the file.
