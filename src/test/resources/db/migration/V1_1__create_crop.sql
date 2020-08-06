DROP table if exists crop;
create table crop
(
    id     varchar(50)  null
        primary key,
    name   varchar(100) null,
    weight varchar(100) null
);
