DROP TABLE IF EXISTS tg_client CASCADE;
DROP TABLE IF EXISTS tg_order CASCADE;

create table tg_client
(
    client_id serial,
    client_name varchar(100) not null,
    client_comment varchar(100),
    primary key (client_id)
);

create table tg_order
(
    order_id serial,
    order_createDate date not null default 23-10-2019,
    order_client integer  not null default 1,
    order_price integer not null default 1000,
    order_comment varchar(100),
    order_paid boolean default false not null,
    primary key (order_id),
    foreign key (order_client) references tg_client(client_id) on delete restrict
);