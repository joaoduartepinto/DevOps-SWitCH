# Ca1 - Version Control Systems

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

Next, it will be demonstrated how the implementation was made using the **Git** version control system:

### 3.1. The current version was tagged with the tag v.1.2.0

#### Show existing tags

```
$ git tag
```

#### Create Tag
```
$ git tag -a v1.2.0 -m "Version 1.2.0."
```

#### Push Tag to remote repository
```
$ git push origin v1.2.0
```

### 3.2. A new branch was created to develop the new feature (email-field)

The branch of work was changed to the branch created for the development of the feature, then it was pushed to the remote repository.

#### Creating new branch @ local
```
$ git checkout -b "email-field"
```

OR

```
$ git branch "email-field"
$ git checkout "email-field"
```

#### Show all branches and current branch
```
$ git branch
```

The current branch is preceded by *

#### Push branch to remote repository
```
$ git push origin email-field
```

If no upstream branch is defined use:

```
$ git push --set-upstream origin email-field
```

### 3.4. Code

Changes were made to accept the email field in Employee class, but without validations:

```
public class Employee {

    private @Id
    @GeneratedValue
    Long id; // <2>
    private String firstName;
    private String lastName;
    private String description;
    private String jobTitle;
    private String email;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String description, String jobTitle, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.jobTitle = jobTitle;
        this.email = email;
    }

[...]

}
```

Then the tests were written for the validations of the Class Employee fields. The test driven development process was applied, so they were written tests that failed:

```
[...]

    @DisplayName("Null First Name")
    @Test
    void shouldThrowNullFirstName() {
        String nullFirstName = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(nullFirstName, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Empty First Name")
    @Test
    void shouldThrowEmptyFirstName() {
        String emptyFirstName = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(emptyFirstName, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Blank First Name")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankFirstName(String blankFirstName) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(blankFirstName, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Null Last Name")
    @Test
    void shouldThrowNullLastName() {
        String nullLastName = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, nullLastName, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Empty Last Name")
    @Test
    void shouldThrowEmptyLastName() {
        String emptyLastName = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, emptyLastName, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Blank Last Name")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankLastName(String blankLastName) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, blankLastName, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Null Description")
    @Test
    void shouldThrowNullDescription() {
        String nullDescription = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, nullDescription, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Empty Description")
    @Test
    void shouldThrowEmptyDescription() {
        String emptyDescription = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, emptyDescription, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Blank Description")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankDescription(String blankDescription) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, blankDescription, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Null Job Title")
    @Test
    void shouldThrowNullJobTitle() {
        String nullJobTitle = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, nullJobTitle, VALID_EMAIL));
    }

    @DisplayName("Empty Job Title")
    @Test
    void shouldThrowEmptyJobTitle() {
        String emptyJobTitle = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, emptyJobTitle, VALID_EMAIL));
    }

    @DisplayName("Blank Job Title")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankJobTitle(String blankJobTitle) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, blankJobTitle, VALID_EMAIL));
    }

    @DisplayName("Null Email")
    @Test
    void shouldThrowNullEmail() {
        String nullEmail = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, nullEmail));
    }

    @DisplayName("Empty Email")
    @Test
    void shouldThrowEmptyEmail() {
        String emptyEmail = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, emptyEmail));
    }

    @DisplayName("Blank Email")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankEmail(String blankEmail) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, blankEmail));
    }

[...]
```

After the first phase of TDD, validations were implemented to make the tests pass:

```
[...]

    public Employee(String firstName, String lastName, String description, String jobTitle, String email) {
        checkFirstName(firstName);
        checkLastName(lastName);
        checkDescription(description);
        checkJobTitle(jobTitle);
        checkEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.jobTitle = jobTitle;
        this.email = email;
    }

    private void checkFirstName(String firstName) {
        if (!isFirstNameValid(firstName))
            throw new IllegalArgumentException("Invalid First Name");
    }

    private boolean isFirstNameValid(String firstName) {
        if (firstName == null || firstName.isBlank() || firstName.isBlank())
            return false;

        return true;
    }

    private void checkLastName(String lastName) {
        if (!isLastNameValid(lastName))
            throw new IllegalArgumentException("Invalid First Name");
    }

    private boolean isLastNameValid(String lastName) {
        if (lastName == null || lastName.isBlank() || lastName.isBlank())
            return false;

        return true;
    }

    private void checkDescription(String description) {
        if (!isDescriptionValid(description))
            throw new IllegalArgumentException("Invalid First Name");
    }

    private boolean isDescriptionValid(String description) {
        if (description == null || description.isBlank() || description.isBlank())
            return false;

        return true;
    }

    private void checkJobTitle(String jobTitle) {
        if (!isJobTitleValid(jobTitle))
            throw new IllegalArgumentException("Invalid First Name");
    }

    private boolean isJobTitleValid(String jobTitle) {
        if (jobTitle == null || jobTitle.isBlank() || jobTitle.isBlank())
            return false;

        return true;
    }

    private void checkEmail(String email) {
        if (!isEmailValid(email))
            throw new IllegalArgumentException("Invalid First Name");
    }

    private boolean isEmailValid(String email) {
        if (email == null || email.isBlank() || email.isBlank())
            return false;

        return true;
    }

[...]
```

### 3.5. Commiting Changes

With each new development step, commits were performed, to be saved snapshots of each version.

First, add the files we want to commit to the staging area:

#### Adding changes to staging area

```
$ git add <file_name>
```

To add all modified files:
```
$ git add .
```

Then, make the commit:

#### Commiting changes

```
$ git commit -m "<commit_message>"
``` 

OR: add to stage, already tracked files, and commit:

```
$ git commit -a -m "<commit_message>"
```

### 3.6. Merging branches and pushing to remote repository

After the development of the new functionality in a separate branch, it is necessary to merge with the master branch and put the new feature in the remote repository.

First, we must checkout to the local master branch:

#### Checkout to master

```
$ git checkout master
```

Then we must pull changes from remote master, as there may be changes in the remote that are not on the local machine:

#### Pull changes from remote

```
$ git pull origin <branch_name>
```

Then the merge is done in the master on the local machine with the branch that is intended, in this case, with the email-field branch:

#### Merge another branch with current one

```
$ git merge <branch_name>
```

Finally, send the changes to the remote repository, create a new tag with the new version, also sends the new tag to the remote repository

#### Push to remote repository

```
$ git push origin master
```

#### Create new tag

```
$ git tag -a v1.3.0 -m "Version 1.3.0."
```

#### Push tag to remote repository

```
$ git push origin v1.3.0
```

### 3.7. Bug-Fixing

A bug was discovered in production. The email field only made validations of null, empty or blank, not making validation if the entered email was in a valid email format.

- For the bug fixing, the following steps were performed:
    1. A new branch was created: fix-invalid-email;
    2. Checkout was made for the new branch;
    3. With each change iteration were commited the altered files;
    4. Upon completion of the changes, checkout was made to the local master branch;
    5. Merged fix-invalid-email into master;
    6. Finally, changes were sent to the remote repository, a new tag was created with the new version (v.1.3.1), and the new tag was sent to the remote repository.

## 4. Analysis of the alternative - **Fossil**

The alternative chosen was the **[Fossil](https://fossil-scm.org/)** version control system.

### 4.1. What is?

Fossil is a distributed version control system, like Git, Mercurial and Bazaar.

- Has a **Built-in Web Interface**, that runs in a instance of Fossil. The Web Interface is themeable, extensible and intuitive and has:
    -  Ticketing;
    -  Bug tracking;
    -  Wiki;
    -  On-line documentation;
    -  Technical notes;
    -  Forum;
    -  Chatroom;
    -  Timelines;
    -  Full text search;
    -  Graphs of revision and branching history;
    -  File and version lists and differences;
    -  Historical change data;
    -  Add and remove tags on check-ins;
    -  Move check-ins between branches;
    -  Revise check-in comments;
    -  Manage user credentials and access permissions;
    -  And more...

- Is a **All-in-one** single self-contained, stand-alone executable.

- Fossil is **Self-host Friendly**, most projects can be hosted on a virtual private server or even on a Raspberry Pi.

- Supports **Autosync** mode, in which automatically keeps your changes in synchronization with your co-workers through the use of a central server.

- Is **Robust and Reliable**, transactions are atomic, even if interrupted by a power loss or system crash. Automatic self-checks verify that all aspects of the repository are consistent prior to each commit.

- The last, but not the least: it's **Free and Open-Source**!

Reference: [Fossil/Home](https://fossil-scm.org/)

### 4.2. Differences Between Fossil And Git

A short summary of the differences between Git and Fossil:

| **Git** | **Fossil** |
|:---:|:---:|
| File versioning only | VCS, tickets, wiki, docs, notes, forum, chat, UI |
| A federation of many small programs | One self-contained, stand-alone executable |
| Custom key/value data store | SQLite |
| Runs natively on POSIX systems | Runs natively on both POSIX and Windows |
| [Bazaar-style](https://www.computerworld.com/article/2534926/which-platform--cathedral-or-bazaar-.html) development | [Cathedral-style](https://www.computerworld.com/article/2534926/which-platform--cathedral-or-bazaar-.html) development |
| Designed for Linux kernel development | Designed for SQLite development |
| Many contributors | Select contributors |
| Focus on individual branches | Focus on the entire tree of changes |
| One check-out per repository | Many check-outs per repository |
| Remembers what you should have done | Remembers what you actually did |
| Commit first | Test first |

*Adapted from: [Fossil/Fossil Versus Git](https://fossil-scm.org/home/doc/trunk/www/fossil-v-git.wiki)*

#### 4.2.1. Featureful

>"Fossil adds an integrated wiki, ticketing & bug tracking, embedded documentation, technical notes, a web forum, and a chat service, all within a single web UI, protected by a fine-grained role-based access control system."

>"Fossil can do operations over all local repo clones and check-out directories with a single command. For example, Fossil lets you say "fossil all sync" on a laptop prior to taking it off the network hosting those repos."

>"Fossil is small, complete, and self-contained. If you clone Git's self-hosting repository, you get just Git's source code. If you clone Fossil's self-hosting repository, you get the entire Fossil website — source code, documentation, ticket history, and so forth."

>"For developers who choose to self-host projects (rather than using a 3rd-party service such as GitHub) Fossil is much easier to set up, since the stand-alone Fossil executable together with a 2-line CGI script suffice to instantiate a full-featured developer website."

#### 4.2.2. Self Contained

>"Fossil is a single self-contained stand-alone executable which by default depends only on common platform libraries."

#### 4.2.3. Development Organization

The Fossil development mode is Cathedral style. Fossil places a lot of emphasis on synchronizing all developers, so that everyone has a real vision of what is happening in the project.

#### 4.2.4. What you should have done vs. What you actually did

>"Git puts a lot of emphasis on maintaining a "clean" check-in history. Extraneous and experimental branches by individual developers often never make it into the main repository. Branches may be rebased before being pushed to make it appear as if development had been linear, or "squashed" to make it appear that multiple commits were made as a single commit."

>"Fossil, in contrast, puts more emphasis on recording exactly what happened, including all of the messy errors, dead-ends, experimental branches, and so forth. One might argue that this makes the history of a Fossil project "messy," but another point of view is that this makes the history "accurate." In actual practice, the superior reporting tools available in Fossil mean that the added "mess" is not a factor."

#### 4.2.5. Test Before Commit

>"One of the things that falls out of Git's default separation of commit from push is that there are several Git sub-commands that jump straight to the commit step before a change could possibly be tested. Fossil, by contrast, makes the equivalent change to the local working check-out only, requiring a separate check-in step to commit the change. This design difference falls naturally out of Fossil's default-enabled autosync feature and its philosophy of not offering history rewriting features."

Reference: [Fossil/Fossil Versus Git](https://fossil-scm.org/home/doc/trunk/www/fossil-v-git.wiki)

### 4.3. Why Fossil over Git?

#### 4.3.1. Git does not provide good situational awareness

Using Fossil as VCS in a project, to know the status of the entire project, just go to the timeline, and in a single screen you can see a summary of the latest changes to the project, in all branches. Using Git, it is necessary to use third-party graphical viewers in order to have the detail and ease of visualization.

#### 4.3.2. Git makes it difficult to find successors (descendents) of a check-in

>"Git lets you look backwards in time, but not forwards. Given some historical check-in, you can see what came before, but it is challenging see what came next."

It is not impossible, but it is extremely difficult to find descendants using Git.

In contrast, Fossil has the option to display all check-ins that are derived, for example, from the last release.

#### 4.3.3. The mental model for Git is needlessly complex

>"The complexity of Git distracts attention from the software under development. A user of Git needs to keep all of the following in mind:
   - The working directory:
   - The "index" or staging area
   - The local head
   - The local copy of the remote head
   - The actual remote head"
  
>"Git has commands (and/or options on commands) for moving and comparing content between all of these locations."

>"In contrast, Fossil users only need to think about their working directory and the check-in they are working on. That is 60% less distraction. Every developer has a finite number of brain-cycles. Fossil requires fewer brain-cycles to operate, thus freeing up intellectual resources to focus on the software under development."

#### 4.3.4. Git does not track historical branch names

Fossil is able to clearly show the history that happened in old branches, where it started, the merges and the relevant information. Git, using third-party GUIs, is unable to clearly show what happened in the past.

#### 4.3.5. Git requires more administrative support

>"Git is complex software. One needs an installer of some kind to put Git on a developer workstation, or to upgrade to a newer version of Git. Standing up a Git server is non-trivial, and so most developers use a third-party service such as GitHub or GitLab, and thus introduce additional dependencies."

In turn, Fossil can be installed just by placing the binary in the $PATH. With just one binary, Fossil has the functionality of Git and GitHub/GitLab.

Regarding the hardware needed to run a Fossil instance, a free (or cheap) virtual private server or a Raspberry Pi can be used, whereas GitLab and similar require better hardware.

#### 4.3.6. Git provides a poor user experience

![Git](../Ca1/assets/git.png)

Image from: [xkcd.com](https://xkcd.com/1597/)

>"Designing software is hard. It takes a lot of focus. A good version control system should provide the developer with assistance, not frustration. Git has gotten better in this regard over the past decade, but it still has a long way to go."

Reference: [SQLite/Why SQLite Does Not Use Git](https://www.sqlite.org/whynotgit.html)

## 5. Implementation of the alternative

Now, the implementation will be demonstrated using Fossil as a version control system.

### 5.1. Remote Repository Set-up

A Raspberry Pi was used to host the remote repository, being accessed through the local network.

The operating system running on the Raspberry Pi is Ubuntu Server 20.04 LTS, previously configured to access the local network and with openssh-server installed so that it can be accessed by another machine.

#### ssh into server

To access the server, the personal computer must be in same network as the server.

My personal computer is a Macbook, so, just need to open the terminal without having to install third-party software and ssh into server:

```
$ ssh <user>@<ip_address_of_server>
```

On the ubuntu server, to know the IP address just enter the following command:

```
$ hostname -i
```

#### Fossil installation

After logging into the server, it is necessary to install Fossil. The chosen way of installation was through the following command:

```
$ sudo apt install fossil
```

To confirm that the installation was successful we can see the version of the fossil that is being used.

```
$ fossil version

This is fossil version 2.12.1
```

#### Creating new project

A new folder was created in the user's home directory with the name "devops", to house the repository. The current directory was moved to this new folder to start the repository.

```
$ mkdir devops
$ cd devops/
```

So let's start the Fossil repository!

```
$ fossil init <repository_name>
```

The name of the repository used was: devops.fossil.

So command used was:

```
$ fossil init devops.fossil
```

The repository can have any name, but the extension .fossil is used traditionally. As we are going to use this repository as a remote server, the .fossil extension is mandatory.

After the comand, project-id, server-id, admin user and initial password will be displayed.

Then, we must checkout a Local Tree:

```
$ fossil open <repository_name>
```

If the directory isn't empty, force flag must be used:

```
$ fossil open <repository_name> --force
```

Keep in mind in what's displayed in terminal, we will need the repository path.

To serve this repository, we need to make some configuration on the UI, to init the web server:

```
$ fossil serve <repository_path>

Listening for HTTP requests on TCP port 8080
```

Then, on web browser we go to server ip address plus port, in this case 8080, like:

- <ip_address>:8080

Log with credentials showed before and set Project Name to: DevOps, then hit Apply Changes.

![project_name](../Ca1/assets/project_name.png)

As Fossil uses a cathedral-style development method, we have to create a user for each employee. We will create a user so that we can later clone the repository to the personal computer.

Go to the "Admin" tab, select "Users", then hit "Add". We must then fill in the requested fields and, for this purpose, make the new user Admin.

![add_new_user](../Ca1/assets/add_new_user.png)

To finish what we need to do on the server, we go back to the terminal and put the job to run in the background:

Press: ctrl + z to stop and then make it run on background.

```
$ bg
```

To avoid doing this step, when starting the server, you can add the "&" at the end to put it running in the background.

```
$ fossil serve <repository_path> &
```

Now, it's time to work on the personal computer!

### 5.2. Install Fossil and clone repository to local machine

#### Fossil Installation

The Homebrew package manager was used to install Fossil on the MacOs operating system.

```
$ brew install fossil
```

A folder was created to house the project on the local machine. The repository was then cloned into that folder.

The HTTP protocol was used to access the remote repository, using the following command:

```
$ fossil clone http://<username>@<ip_address>:<port> <repository-filename>
```

In this case:

```
$ fossil clone http://1201765@<ip_address>:8080 devops.fossil
```

Enter the password setted before, and the clone will succeed.

Now, we have to put a copy of the initial project inside the repository folder to do the implementation using Fossil.

#### Push the base project into remote

Open local tree, with force flag, directory already have initial tut-basic source code:

```
$ fossil open devops.fossil -f
```

Now, add all files to be commited:

```
$ fossil add .
```

Oh no! Files of /target/ and /node_modules/ have been added...

Anyway, we must reset the added files, create a file to ignore files and add again:

#### Reset added files

```
$ fossil add --reset
```

#### Ignoring files - ignore-glob

At the root of the project a directory with name: .fossil-settings

```
$ mkdir .fossil-settings
$ cd .fossil-settings
```

Inside the new folder create a file named ignore-glob, and per line put the glob that we want to ignore:

```
$ nano ignore-glob
```

![ignore-glob](../Ca1/assets/ignore-glob.png)

Now add files again, you will see that the ignored directories will not be added

![added-files](../Ca1/assets/added-files.png)

#### Commiting

To commit type the following comand to commit:

```
$ fossil commit
```

Default text editor will open to introduce commit message, like:

![commit-message](../Ca1/assets/commit-message.png)

Here we can see demonstrated one of Fossil's capabilities, as autosync by default is active, when a commit is made, the remote repository is automatically pulled (to download possible changes in remote), also automatically pushes to the remote with the contents of the commit.

![autosync](../Ca1/assets/autosync.png)

![check-ins](../Ca1/assets/check-ins.png)

![files-tree](../Ca1/assets/files-tree.png)