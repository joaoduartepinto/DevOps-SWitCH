create sequence hibernate_sequence start with 1 increment by 1;
create table employee (id bigint not null, description varchar(255), email varchar(255), first_name varchar(255), job_title varchar(255), last_name varchar(255), primary key (id));
