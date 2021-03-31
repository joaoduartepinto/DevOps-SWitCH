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

## 3. Implementation

### Show existing tags

```shell script
$ git tag
```

### Create Tag
```shell script
$ git tag -a v1.2.0 -m "Version 1.2.0."
```

### Push Tag to remote repository
```shell script
$ git push origin v1.2.0
```

### Creating new branch @ local
```shell script
$ git checkout -b "email-field"
```

OR

```shell script
$ git branch "email-field"
$ git checkout "email-field"
```

### Show all branches and current branch
```shell script
$ git branch
```

The current branch is preceded by *

### Push branch to remote repository
```shell script
$ git push origin email-field
```

If no upstream branch is defined use:

```shell script
$ git push --set-upstream origin email-field
```

### Adding changes to staging area

```shell script
$ git add <file_name>
```

To add all modified files:
```shell script
$ git add .
```

### Committing changes

```shell script
$ git commit -m "<commit_message>"
``` 

OR: add to stage, already tracked files, and commit:

```shell script
$ git commit -a -m "<commit_message>"
```


## Analysis of the alternative


## Implementation of the alternative