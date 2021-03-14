create database web_day8;

use web_day8;


create table student(
	id bigint not null auto_increment,
	identity_number varchar(20) not null,
    name varchar(50) not null, 
    dob date,
    gender varchar(6),
    primary key ( id )
);

insert into student (identity_number, name, dob, gender) values
    ('000000001', 'Nguyen Van A', '2000/12/31', 'MALE'),
    ('000000002', 'Nguyen Van B', '2000/11/30', 'MALE'),
    ('000000003', 'Tran Quang C', '2000/10/31', 'MALE'),
    ('000000004', 'Truong Thi D', '2000/9/30', 'FEMALE'),
    ('000000005', 'Do Quang E', '2000/8/31', 'MALE'),
    ('000000006', 'Ngo Thi F', '2000/7/31', 'FEMALE'),
    ('000000007', 'Bui Van G', '2000/6/30', 'MALE'),
    ('000000008', 'Pham Thi H', '2000/5/31', 'FEMALE'),
    ('000000009', 'Duong Van I', '2000/4/30', 'MALE');

select * from student;
