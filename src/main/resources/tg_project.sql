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
    order_createDate date not null,
    order_client integer  not null,
    order_price integer not null default 0,
    order_comment varchar(100),
    order_paid boolean default false not null,
    primary key (order_id),
    foreign key (order_client) references tg_client(client_id) on delete restrict
);

INSERT INTO tg_client (client_id, client_name, client_comment) VALUES
(1, 'Уралвагонзавод', ''),
(2, 'IBM', ''),
(3, 'MORDOR inc', ''),
(4, '24 print', ''),
(5, 'Из рук в руки', '');

INSERT INTO tg_order (order_id, order_createDate, order_client, order_price, order_comment) VALUES
(1, '23/10/19', 1, 123456, 'комментарий'),
(2, '23/10/19', 2, 223456, 'комментарий'),
(3, '23/10/19', 2, 223456, 'комментарий'),
(4, '23-10-19', 3, 4123456, 'комментарий'),
(5, '23.10.19', 3, 4123456, 'комментарий');