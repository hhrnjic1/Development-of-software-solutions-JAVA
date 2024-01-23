
CREATE TABLE IF NOT EXISTS "grad" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"broj_stanovnika"	INTEGER,
	"drzava"	INTEGER,
	PRIMARY KEY("id"),
	FOREIGN KEY("drzava") REFERENCES "drzava"("id")
);
CREATE TABLE IF NOT EXISTS "drzava" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"glavni_grad"	INTEGER,
	PRIMARY KEY("id"),
	FOREIGN KEY("glavni_grad") REFERENCES "grad"("id")
);
INSERT INTO "grad" VALUES (1,'Beograd',1500000,2);
INSERT INTO "grad" VALUES (2,'Sarajevo',500000,1);
INSERT INTO "grad" VALUES (3,'Travnik',40000,1);
INSERT INTO "grad" VALUES (4,'Zagreb',1000000,3);
INSERT INTO "drzava" VALUES (1,'Bosna i Hercegovina',2);
INSERT INTO "drzava" VALUES (2,'Srbija',1);
INSERT INTO "drzava" VALUES (3,'Hrvatska',4);

