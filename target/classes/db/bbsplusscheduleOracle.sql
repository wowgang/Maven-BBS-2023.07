
/* Drop Triggers */

DROP TRIGGER TRI_anniversary_aid;
DROP TRIGGER TRI_reply_rid;
DROP TRIGGER TRI_schedule_sid;



/* Drop Tables */

DROP TABLE anniversary CASCADE CONSTRAINTS;
DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE schedule CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_anniversary_aid;
DROP SEQUENCE SEQ_reply_rid;
DROP SEQUENCE SEQ_schedule_sid;




/* Create Sequences */

CREATE SEQUENCE SEQ_anniversary_aid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_reply_rid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_schedule_sid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE anniversary
(
	aid number NOT NULL,
	aname varchar2(32) NOT NULL,
	adate char(8) NOT NULL,
	isHoliday number DEFAULT 0,
	PRIMARY KEY (aid)
);


CREATE TABLE board
(
	bid number(10,0) NOT NULL,
	"uid" varchar2(16) NOT NULL,
	title varchar2(128) NOT NULL,
	content varchar2(4000),
	modTime timestamp DEFAULT CURRENT_TIMESTAMP,
	viewCount number(10,0) DEFAULT 0,
	replyCount number(10,0) DEFAULT 0,
	isDeleted number(10,0) DEFAULT 0,
	files varchar2(400),
	PRIMARY KEY (bid)
);


CREATE TABLE reply
(
	rid number(10,0) NOT NULL,
	"comment" varchar2(128) NOT NULL,
	regTime timestamp DEFAULT CURRENT_TIMESTAMP,
	isMine number(10,0) DEFAULT 0,
	"uid" varchar2(16) NOT NULL,
	bid number(10,0) NOT NULL,
	PRIMARY KEY (rid)
);


CREATE TABLE schedule
(
	sid number NOT NULL,
	"uid" varchar2(16) NOT NULL,
	sdate char(8) NOT NULL,
	title varchar2(40) NOT NULL,
	place varchar2(40),
	startTime timestamp NOT NULL,
	endTime timestamp,
	isImportant number DEFAULT 0,
	memo varchar2(100),
	PRIMARY KEY (sid)
);


CREATE TABLE users
(
	"uid" varchar2(16) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar2(20) NOT NULL,
	email varchar2(32) NOT NULL,
	regDate date DEFAULT (CURRENT_DATE),
	isDeleted number(10,0) DEFAULT 0,
	"profile" varchar2(32),
	addr varchar2(32),
	PRIMARY KEY ("uid")
);



/* Create Foreign Keys */

ALTER TABLE reply
	ADD FOREIGN KEY (bid)
	REFERENCES board (bid)
;


ALTER TABLE board
	ADD FOREIGN KEY ("uid")
	REFERENCES users ("uid")
;


ALTER TABLE reply
	ADD FOREIGN KEY ("uid")
	REFERENCES users ("uid")
;


ALTER TABLE schedule
	ADD FOREIGN KEY ("uid")
	REFERENCES users ("uid")
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_anniversary_aid BEFORE INSERT ON anniversary
FOR EACH ROW
BEGIN
	SELECT SEQ_anniversary_aid.nextval
	INTO :new.aid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_reply_rid BEFORE INSERT ON reply
FOR EACH ROW
BEGIN
	SELECT SEQ_reply_rid.nextval
	INTO :new.rid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_schedule_sid BEFORE INSERT ON schedule
FOR EACH ROW
BEGIN
	SELECT SEQ_schedule_sid.nextval
	INTO :new.sid
	FROM dual;
END;

/




