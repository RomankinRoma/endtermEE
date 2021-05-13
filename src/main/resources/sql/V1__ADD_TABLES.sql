CREATE TABLE public.users( id serial,username varchar ,password varchar );
CREATE TABLE public.post( id serial, head varchar ,info varchar ,user_id numeric );
CREATE TABLE public.comment( id serial,username varchar ,comment varchar ,post_id numeric);