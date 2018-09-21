CREATE TABLE tbl_reply (
 rno INT NOT NULL AUTO_INCREMENT,
 bno INT NOT NULL default 0,
 replytext VARCHAR(1000) NOT NULL,
 reply VARCHAR(100) NOT NULL,   
 regdate TIMESTAMP NOT NULL DEFAULT now(),
 updatedate TIMESTAMP ,
 PRIMARY KEY(rno)
);

ALTER TABLE tbl_reply add CONSTRAINT fk_board
FOREIGN KEY (bno) REFERENCES tbl_board(bno);