-- The main 'geoname' table has the following fields :
---------------------------------------------------
-- geonameid         : integer id of record in geonames database
-- name              : name of geographical point (utf8) varchar(200)
-- asciiname         : name of geographical point in plain ascii characters, varchar(200)
-- alternatenames    : alternatenames, comma separated, ascii names automatically transliterated, convenience attribute from alternatename table varchar(8000)
-- latitude          : latitude in decimal degrees (wgs84)
-- longitude         : longitude in decimal degrees (wgs84)
-- feature class     : see http://www.geonames.org/export/codes.html, char(1)
-- feature code      : see http://www.geonames.org/export/codes.html, varchar(10)
-- country code      : ISO-3166 2-letter country code, 2 characters
-- cc2               : alternate country codes, comma separated, ISO-3166 2-letter country code, 60 characters
-- admin1 code       : fipscode (subject to change to iso code), see exceptions below, see file admin1Codes.txt for display names of this code; varchar(20)
-- admin2 code       : code for the second administrative division, a county in the US, see file admin2Codes.txt; varchar(80) 
-- admin3 code       : code for third level administrative division, varchar(20)
-- admin4 code       : code for fourth level administrative division, varchar(20)
-- population        : bigint (8 byte int) 
-- elevation         : in meters, integer
-- dem               : digital elevation model, srtm3 or gtopo30, average elevation of 3''x3'' (ca 90mx90m) or 30''x30'' (ca 900mx900m) area in meters, integer. srtm processed by cgiar/ciat.
-- timezone          : the timezone id (see file timeZone.txt) varchar(40)
-- modification date : date of last modification in yyyy-MM-dd format

create table geonames.geoname (
	geonameid integer null,
	name varchar(200) null,
	asciiname varchar(200) null,
	alternatenames varchar(8000) null,
	latitude decimal(20, 2) null,
	longitude decimal(20, 2) null,
	feature_class varchar(1) null,
	feature_code varchar(10) null,
	country_code varchar(2) null,
	cc2 varchar(60) null,
	admin1_code varchar(20) null,
	admin2 code varchar(80) null,
	admin3_code varchar(20) null,
	admin4_code varchar(20) null,
	population bigint null,
	elevation integer null,
	dem integer null,
	timezone varchar(40) null,
	modification_date date null
);
