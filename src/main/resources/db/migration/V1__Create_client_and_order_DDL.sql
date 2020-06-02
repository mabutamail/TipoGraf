CREATE TABLE public.hibernate_sequence (
	next_val numeric NULL
);

CREATE TABLE public.tg_client (
	client_id numeric NOT NULL,
	client_name varchar(40) NOT NULL,
	client_comment varchar(40) NOT NULL,
	CONSTRAINT tg_client_pkey PRIMARY KEY (client_id),
	CONSTRAINT uk_nc46jboe134jpg053ulttsy4u UNIQUE (client_name)
);

CREATE TABLE public.tg_order (
	order_id numeric NOT NULL,
	"date" timestamp NOT NULL,
	"comment" varchar(255) NULL,
	price numeric NULL,
	"condition" varchar(255) NOT NULL,
	client_id numeric NOT NULL,
	CONSTRAINT tg_order_pkey PRIMARY KEY (order_id),
	CONSTRAINT uk_eqa9vtbnd6a3dfk1m4o5afm7j UNIQUE (date)
);
