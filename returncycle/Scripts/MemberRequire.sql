CREATE TABLE USER_PROFILE
( 
    u_id            VARCHAR2(20)     NOT NULL, 
    u_pwd           VARCHAR2(20)     NOT NULL, 
    u_pwd_q         VARCHAR2(100)	NOT NULL,
    u_pwd_a			VARCHAR2(100)	NOT NULL,
    u_last_name     VARCHAR2(10)     NULL, 
    u_first_name    VARCHAR2(20)     NULL,
    u_gender        VARCHAR2(10)      NULL, 
    u_email         VARCHAR2(30)     NOT NULL,
    u_phone         VARCHAR2(20)     NOT NULL, 
    u_zipcode     	VARCHAR2(100)    NOT NULL, 
    u_address     	VARCHAR2(100)    NOT NULL, 
    u_address_detail VARCHAR2(100)   NOT NULL, 
    admin			NUMBER(5)        NULL,
    u_point			NUMBER(30)         NULL,
    CONSTRAINT USER_PROFILE_PK PRIMARY KEY (u_id)
);
SELECT * FROM USER_PROFILE;

SELECT * FROM USER_PROFILE WHERE U_ID = 'eastgerm';

INSERT INTO USER_PROFILE
VALUES('eastgermad','1234','기억에 남는 추억의 장소는?','없다','김','동균','남자','eastgerm93@gmail.com','010-9082-0966','1234','1234','1234',1,10000);

DROP TABLE USER_PROFILE;

CREATE TABLE APPLY
(
	A_DATE				DATE,
	A_UID				VARCHAR2(200)		NOT NULL,
	A_ID				VARCHAR2(200)		NOT NULL,
	A_NAME 				VARCHAR2(200) 		NOT NULL,
	A_EMAIL				VARCHAR2(300)		NULL,
	A_PHONE				VARCHAR2(200)		NOT NULL,
	A_ZIPCODE			VARCHAR2(100)		NOT NULL,
	A_ADDRESS			VARCHAR2(100)		NOT NULL,
	A_ADDRESS_DETAIL	VARCHAR2(100)		NOT NULL,
	A_REQUEST			VARCHAR2(500)		NULL,
	A_WDATE				DATE,
	A_WTIME				VARCHAR2(200)		NULL,
	A_PLASTIC			NUMBER(20)			NOT NULL,
	A_VINYL				NUMBER(20)			NOT NULL,
	A_CAN				NUMBER(20)			NOT NULL,
	A_GLASS				NUMBER(20)			NOT NULL,
	A_PAPER				NUMBER(20)			NOT NULL,
	A_POINT				NUMBER(30)			NOT NULL,
	CONSTRAINT APPLY_PK PRIMARY KEY (A_UID),
	CONSTRAINT APPLY_FK FOREIGN KEY(A_ID) REFERENCES USER_PROFILE(u_id)
);

/*select TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')||dbms_random.string('U', 10) as A_UID from dual;*/
SELECT * FROM APPLY;


DROP TABLE APPLY;


/*deliver 테이블 생성, r_id USER_PROFILE의 u_id 상속 받았음*/
CREATE TABLE USER_RECYCLED
(
	R_DATE			DATE,
	R_UID			VARCHAR2(20)		NOT NULL,
	R_WDATE			VARCHAR2(300)	NULL,
	R_WTIME			VARCHAR2(200)	NULL,
	R_ID            VARCHAR2(20)    NOT NULL,
	R_NAME			VARCHAR2(20)	NOT NULL,
	R_PHONE			VARCHAR2(20)	NOT NULL,
	R_ADDRESS		VARCHAR2(200)	NOT NULL,
	R_PLASTIC		NUMBER(20)		NOT NULL,
	R_VINYL			NUMBER(20)		NOT NULL,
	R_CAN			NUMBER(20)		NOT NULL,
	R_GLASS			NUMBER(20)		NOT NULL,
	R_PAPER			NUMBER(20)		NOT NULL,
	R_POINT			NUMBER(30)		NOT NULL
);
ALTER TABLE USER_RECYCLED ADD CONSTRAINT USER_RECYCLED_FK FOREIGN KEY(r_id) REFERENCES USER_PROFILE(u_id);
SELECT * FROM USER_RECYCLED;
DROP TABLE USER_RECYCLED;

/*payback 테이블 생성, t_id USER_PROFILE의 t_id 상속 받았음*/
CREATE TABLE USER_PAYBACK
(
	p_id          		VARCHAR2(20)    NOT NULL,
	p_name				VARCHAR2(20)	NOT NULL,
	p_phone				VARCHAR2(20)	NOT NULL,
	p_email				VARCHAR2(20)	NOT NULL,
	p_zipcode     		VARCHAR2(100)   NOT NULL, 
    p_address     		VARCHAR2(100)   NOT NULL, 
    p_address_detail 	VARCHAR2(100)   NOT NULL,
    p_request 			VARCHAR2(100)   NOT NULL, 
	p_order				VARCHAR2(100)	NOT NULL,
	p_point				NUMBER(20)		NOT NULL
);
ALTER TABLE USER_PAYBACK ADD CONSTRAINT USER_PAYBACK_FK FOREIGN KEY(p_id) REFERENCES USER_PROFILE(u_id);
SELECT * FROM USER_PAYBACK;

ALTER TABLE USER_PAYBACK MODIFY(p_phone VARCHAR2(50));

DROP TABLE USER_PAYBACK;
/*인증번호 받기 위한 테이블 생성*/
CREATE TABLE CODE_TB
(
	c_phone 	VARCHAR2(20) NOT NULL,
	tempCode 	VARCHAR2(20) NOT NULL
);
SELECT * FROM code_tb;

DROP TABLE CODE_TB;



