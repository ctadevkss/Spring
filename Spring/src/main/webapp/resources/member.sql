CREATE TABLE tbl_member (
userid VARCHAR(50) NOT NULL,
userpw VARCHAR(50) NOT NULL,
username VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
regdate TIMESTAMP DEFAULT now(),
updatedate TIMESTAMP ,
PRIMARY KEY (userid)
);