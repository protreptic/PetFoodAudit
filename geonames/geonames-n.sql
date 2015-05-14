drop schema if exists geonames cascade;
create schema geonames;

comment on schema geonames is 'Схема для размещения текущей копии базы данных geonames.org';

/* GEONAME DB */
create table geonames.geoname (
	geoname_id 		varchar(200),	-- integer id of record in geonames database
	"name" 			varchar(200),	-- name of geographical point (utf8) varchar(200)
	ascii_name 		varchar(200),	-- name of geographical point in plain ascii characters, 
	alternate_names 	varchar(5000),	-- alternatenames, comma separated varchar(5000)
	latitude 			decimal,		-- latitude in decimal degrees (wgs84)
	longitude 		decimal,		-- longitude in decimal degrees (wgs84)
	feature 			varchar(1),	-- see http://www.geonames.org/export/codes.html, char(1)
	feature_code 		varchar(10),	-- see http://www.geonames.org/export/codes.html, varchar(10)
	country_code 		varchar(2),	-- ISO-3166 2-letter country code, 2 characters
	cc2 				varchar(60),	-- alternate country codes, comma separated, ISO-3166 2-letter country code, 60 characters
	admin1_code 		varchar(20),	-- fipscode (subject to change to iso code), see exceptions below, see file admin1Codes.txt for display names of this code; varchar(20)
	admin2_code 		varchar(80),	-- code for the second administrative division, a county in the US, see file admin2Codes.txt; varchar(80) 
	admin3_code 		varchar(20),	-- code for third level administrative division, varchar(20)
	admin4_code 		varchar(20),	-- code for fourth level administrative division, varchar(20)
	population 		bigint,		-- bigint (8 byte int) 
	elevation 		integer,		-- in meters, integer
	dem 				integer,		-- digital elevation model, srtm3 or gtopo30, average elevation of 3''x3'' (ca 90mx90m) or 30''x30'' (ca 900mx900m) area in meters, integer. srtm processed by cgiar/ciat.
	timezone 			varchar(40),	-- the timezone id (see file timeZone.txt) varchar(40)
	modification 		date,		-- date of last modification in yyyy-MM-dd format
	
	constraint geoname_pkey primary key (geoname_id)
);

create table geonames.alternate_names (
	alternate_name_id 	integer,
	geoname_id 		integer,
	iso_language 		varchar(7),
	alternate_name 	varchar,
	is_preferred_name 	boolean,
	is_short_name 		boolean,
	is_colloquial 		boolean,
	is_historical 		boolean,
	
	constraint alternate_names_pkey primary key (alternate_name_id)
);

create table geonames.iso_language_codes (
	iso_639_3 	varchar(3),
	iso_639_2 	varchar(10),
	iso_639_1 	varchar(2),
	language_name 	varchar(64)
);

create table geonames.options (
	option_label 	varchar(200),
	option_value 	varchar
);

insert into geonames.options values ('data_url', 'http://download.geonames.org/export/dump/');
insert into geonames.options values ('last_update_date', now());

create or replace function geonames.load() returns void as
$body$
declare
begin
	copy geonames.geoname 			from '/srv/ftp/sip/photos/geonames/RU/RU.txt' 			with delimiter E'\t' csv encoding 'utf8' quote as '*' escape as E'\t'; 
	copy geonames.alternate_names 	from '/srv/ftp/sip/photos/geonames/alternateNames.txt' 	with delimiter E'\t' csv encoding 'utf8' quote as '*' escape as E'\t'; 
	copy geonames.iso_language_codes 	from '/srv/ftp/sip/photos/geonames/iso-languagecodes.txt' 	with delimiter E'\t' csv encoding 'utf8' quote as '"' escape as E'\t' header; 
end
$body$
language plpgsql volatile;

select geonames.load();