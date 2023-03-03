insert into account(name, email, password, role, version) values ('Admin User', 'admin@gmail.com', 'admin', 0, 0);
insert into account(name, email, password, role, version) values ('Thaw Thaw', 'thaw@gmail.com', 'member', 1, 0);

insert into profile(account_code, version, dob, image) values (1, 0, '1999-01-11', 'profile.jpg');
insert into address(version, type, building, street, zipcode) values (0, 0, 'No 38', '106-C street', '1111');