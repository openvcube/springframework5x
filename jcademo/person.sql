create table person
(
    person_id         INT not null,
    person_last_name  VARCHAR(255) not null,
    person_first_name VARCHAR(255) not null,
    constraint pk_person primary key (PERSON_ID)
);

delete from person;
insert into person values(1,'dragon','spring');
update person set person_last_name='dragon', person_first_name='spring' where person_id=1;