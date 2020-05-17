create table contact
(
   id INT AUTO_INCREMENT not null,
   first_name varchar(25) not null,
   last_name varchar(25) not null,
   email varchar(255) not null,
   phone_number varchar(10) not null,
   status varchar(10) DEFAULT 'Active',
   primary key(id)
);