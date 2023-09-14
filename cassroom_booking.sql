create schema if not exists classroom_booking;

set search_path = classroom_booking, public;

--show search_path;

create table user_app(
	firstName text,
	lastName text,
	email text not null unique,
	telephone text,
	userName text primary key,
	pass text not null,
	active boolean,
	role_id text
);

insert into user_app values
('Aleksandar', 'Janković', 'aleksandar.jankovic95@yahoo.com', '060/59-xx-xxx', 'aca_janko', 'A', true, null, 'aca_janko', now(), null, null);

create table classroom_type (
	id numeric primary key,
	dsc text
);

create table classroom (
	id numeric primary key,
	dsc text,
	peopleCapacity numeric default 0,
	hasComputers boolean,
	computerCapacity numeric default 0,
	classRoom_type numeric,
	constraint fk_classroom_type foreign key(classRoom_type) references classroom_type(id)
);

create table reservation_type (
	id numeric primary key,
	dsc text
);

create table reservation_status (
	id numeric primary key,
	dsc text
);

create table reservation (
	id numeric primary key,
	classroom numeric not null,
	dsc text,
	reservation_type numeric not null,
	beginning_asked timestamp,
	end_asked timestamp,
	reservation_for_user text,
	status_id numeric,
	status_changed_by text,
	beginning_approved timestamp,
	end_approved timestamp
);

