# Description of the analysis, design and implementation of the requirements

## 1. Requirements and Analysis

## 1.1. Client Notes

>*"You should develop new features in branches named after the feature. For instance, a branch named "email-field" to add a new email field to the application"*

>*"The server should only accept Employees with a valid email (e.g., an email must have the "@" sign)"*

## 1.2. Requirements

The requirements raised after analyzing the document provided by the client are as follows:

- Create an email field for the application:
    - email must have validations;
    - the feature must be tested with unit tests.
    
- Acceptance criteria:
    - New email field with validation (must have the "@" sign).

## 1.3. Analysis

After the requirements survey it was analyzed that:

- A new field must be added to display email information;

- Front-end and serve side must be changed and updated to comply with requirements;

- There should be validations of the email field on the server side.

## 2. Design

For the realization of this new feature, a new attribute called email must be added to Employee class to store the email data.
Validations will be done through Regex, to ensure that the email provided is valid (for example, check if the email contains an @). It will also have to be validated if the String provided is not null, empty or blank.

To accommodate these changes, an attribute of type Email must be added to the class Employee, in which an object of type String will be accepted in the constructor to be instantiated the attribute when creating an object of type Employee.

Changes will also have to be made on the front end, to display the email field. In the DatabaseLoader class, emails must be added when the Employee objects are instantiated, because if they are not added there will be a compilation error.

## 3. Implementation

### Show existing tags

```
$ git tag
```

### Create Tag
```
$ git tag -a v1.2.0 -m "Version 1.2.0."
```

### Push Tag to remote repository
```
$ git push origin v1.2.0
```

### Creating new branch @ local
```
$ git checkout -b "email-field"
```

OR

```
$ git branch "email-field"
$ git checkout "email-field"
```

### Show all branches and current branch
```
$ git branch
```

The current branch is preceded by *

### Push branch to remote repository
```
$ git push origin email-field
```

If no upstream branch is defined use:

```
$ git push --set-upstream origin email-field
```

### Adding changes to staging area

```
$ git add <file_name>
```

To add all modified files:
```
$ git add .
```

### Committing changes

```
$ git commit -m "<commit_message>"
``` 

OR: add to stage, already tracked files, and commit:

```
$ git commit -a -m "<commit_message>"
```


## Analysis of the alternative


## Implementation of the alternative