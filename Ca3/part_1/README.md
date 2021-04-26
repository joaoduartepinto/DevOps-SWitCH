# Ca3 - Part1 - Virtualization

## 1. Set up the Virtual Machine 

The VM setup is described in the [support material](./assets/devops_ca3-part1.pdf) provided by the teacher.

## 2. Clone repository to VM

Through the host machine, we will ssh the VM through a terminal:

```
$ ssh <user>@<ip_address>
```

We must introduce the password setted in point 1..

Prior to the clone, we have to install git on the VM:

```
$ sudo apt install git
```

Now we must clone the remote repository:

```
$ git clone https://<bitbucket_credential>@bitbucket.org/Joao_Pinto_1201765/devops-20-21-1201765.git
```

## 3. Build

To build each project, we must be within the root of the project we intend to build. For example, for the demo-gradle:

```
$ cd devops-20-21-1201765/Ca2/part_1/demo-gradle
```

## 3.1


## 4. Make it run!


## 5. Why we must run the client on Host machine?
https://qastack.com.br/programming/17223536/failed-to-execute-goal-org-apache-maven-pluginsmaven-compiler-plugin2-3-2comp
