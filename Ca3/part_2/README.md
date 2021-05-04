# Ca3 - Part2 - Vagrant

## 1. Initial Setup

Copy the project of Ca2 - part 2 to a new folder (Ca2/part_2/tut-basic-gradle).

At Ca2/part_2/ create a folder called virtualbox and inside create a file called Vagrantfile, without extension. The Vagrantfile content can be copy here:

[https://bitbucket.org/atb/vagrant-multi-spring-tut-demo/](https://bitbucket.org/atb/vagrant-multi-spring-tut-demo/)

## 2. Vagrantfile

### 2.1. Analysis

We can define which box we want to use using:

```
Vagrant.configure("2") do |config|
    config.vm.box = <box_name>
```

A list of box can be found here:

[boxes](https://app.vagrantup.com/boxes/search)

To use same shell commands in multiple VMs we can use:

```
    config.vm.provision "shell", inline: <<-SHELL
        <shell_commands>
    SHELL
```

We can define a VM by:

```
    config.vm.define "<vm_name>" do |<vm_name>|
        <vm_name>.vm.<config> = "<atributte>"
        [...]
    end    
```

A multiple configs can be used, like:

- box : choose box
- hostname: select hostname
- network "<network-name>", ip: <ip-addr>: network name and ip address
- networ "forwarded_port", guest: <guest-port>, host: <host-port>: port forwarding

and more...

### 2.2. How it can be used to create and provision Two Virtual Machines

Like in this example we can configure multiple VMs with one Vagrantfile, this can be used when we want to have distinct 
apps on each VM (frontend runnig on one, and database on another VM).

### 2.3. Update Vagrantfile to use Ca2 - part 2 tut-basic-gradle

In the Vagrantfile we must do some changes to use our projecto from Ca2 - part 2.

We must change the git clone command to:

```
git clone https://joaoswitch@bitbucket.org/Joao_Pinto_1201765/devops-20-21-1201765.git
```

And the change directory command:

```
cd devops-20-21-1201765/Ca3/part_2/tut-basic-gradle/
```

## 3. Update tut-basic-gradle

## 4. Analysis of Alternative - Parallels

## 5. Implementation of Alternative

## 6. References
