DROP TABLE IF EXISTS tg_order CASCADE;
DROP TABLE IF EXISTS tg_client CASCADE;

create table tg_client
(
    id serial,
    name varchar(100) not null,
    comment varchar(100),
    primary key (id)
);

create table tg_order
(
    id serial,
    createDate date not null,
    client integer  not null,
    price integer not null default 0,
    comment varchar(100),
    condition varchar(100) not null default 1,
    primary key (id),
    foreign key (client) references tg_client(id) on delete restrict
);