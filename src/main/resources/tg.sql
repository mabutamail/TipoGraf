DROP TABLE IF EXISTS tg_client;
DROP TABLE IF EXISTS tg_order;

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
    order_createDate date not null,
    order_client integer  not null,
    order_price integer not null,
    order_comment varchar(100),
    primary key (order_id),
    foreign key (order_client) references tg_client (client_id) on delete restrict
);
