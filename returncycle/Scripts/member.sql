CREATE TABLE SHIPMENT
(
    s_idx             NUMBER(5)           NOT NULL, 
    u_idx             NUMBER(5)           NOT NULL, 
    s_deliver_date    DATE             NOT NULL, 
    s_collect_date    DATE             NOT NULL, 
    s_c_message       VARCHAR2(100)    NULL, 
    s_d_message       VARCHAR2(100)    NULL, 
    d_idx             NUMBER(5)           NOT NULL, 
    CONSTRAINT SHIPMENT_PK PRIMARY KEY (s_idx)
);
  
CREATE TABLE QUESTION
(
    q_idx        NUMBER(5)           NOT NULL, 
    u_idx        NUMBER(5)     	  NOT NULL, 
    q_title      VARCHAR2(30)     NOT NULL, 
    q_content    VARCHAR2(500)    NOT NULL, 
    q_date       DATE             NOT NULL, 
    q_status     VARCHAR2(20)     NULL, 
    CONSTRAINT QUESTION_PK PRIMARY KEY (q_idx)
);

CREATE TABLE NOTICE
(
    n_idx        NUMBER(5)           NOT NULL, 
    u_idx        NUMBER(5)           NOT NULL, 
    n_title      VARCHAR2(30)     NOT NULL, 
    n_content    VARCHAR2(500)    NOT NULL, 
    n_vcount     NUMBER(5)           NULL, 
    n_date       DATE             NOT NULL, 
    CONSTRAINT NOTICE_PK PRIMARY KEY (n_idx)
);

CREATE TABLE EVENT
(
    e_idx     NUMBER(5)          NOT NULL, 
    e_name    VARCHAR2(30)    NOT NULL, 
    u_idx     NUMBER(5)          NOT NULL, 
    CONSTRAINT EVENT_PK PRIMARY KEY (e_idx)
);

CREATE TABLE DRIVER
(
    d_idx      NUMBER(5)          NOT NULL, 
    d_name     VARCHAR2(20)    NOT NULL, 
    d_phone    VARCHAR2(20)    NOT NULL, 
    CONSTRAINT DRIVER_PK PRIMARY KEY (d_idx)
);

CREATE TABLE USER_PROFILE
(
    u_idx           NUMBER(5)           NOT NULL, 
    u_id            VARCHAR2(20)     NOT NULL, 
    u_pwd           VARCHAR2(20)     NOT NULL, 
    u_last_name     VARCHAR2(10)     NULL, 
    u_first_name    VARCHAR2(20)     NULL, 
    u_phone         VARCHAR2(20)     NOT NULL, 
    u_email         VARCHAR2(30)     NOT NULL, 
    u_age           NUMBER(3)        NULL, 
    u_gender        VARCHAR2(5)      NULL, 
    u_zipcode     	VARCHAR2(100)    NOT NULL, 
    u_address     	VARCHAR2(100)    NOT NULL, 
    u_address_detail VARCHAR2(100)    NOT NULL, 
    admin           NUMBER(5)           NULL, 
    u_pwd_q         VARCHAR2(100)	NOT NULL,
    u_pwd_a			VARCHAR2(100)	NOT NULL,
    u_point			NUMBER(10)         NULL,
    CONSTRAINT USERPROFILE_PK PRIMARY KEY (u_idx)
);


CREATE TABLE VERIFY
(
    v_idx    NUMBER(5)    NOT NULL, 
    u_idx    NUMBER(5)    NOT NULL, 
    d_idx    NUMBER(5)    NOT NULL, 
    e_idx    NUMBER(5)    NOT NULL, 
    CONSTRAINT VERIFY_PK PRIMARY KEY (v_idx)
);

CREATE TABLE POST
(
    p_idx       NUMBER(5)           NOT NULL, 
    u_idx       NUMBER(5)           NOT NULL, 
    p_title     VARCHAR2(30)     NOT NULL, 
    p_text      VARCHAR2(500)    NOT NULL, 
    p_date      DATE             NULL, 
    p_vcount    NUMBER(5)           NULL, 
    CONSTRAINT POST_PK PRIMARY KEY (p_idx)
);

CREATE TABLE REPLY
(
    r_idx        NUMBER(5)           NOT NULL, 
    p_idx        NUMBER(5)           NOT NULL, 
    r_content    VARCHAR2(100)    NULL, 
    r_date       DATE             NULL, 
    u_idx        NUMBER(5)           NOT NULL, 
    CONSTRAINT REPLY_PK PRIMARY KEY (r_idx)
);

CREATE TABLE OBJECTS
(
    o_idx      NUMBER(5)          NOT NULL, 
    o_title    VARCHAR2(20)    NULL, 
    o_cost     NUMBER(5)          NULL, 
    u_idx      NUMBER(5)          NOT NULL, 
    CONSTRAINT OBJECT_PK PRIMARY KEY (o_idx)
);

ALTER TABLE SHIPMENT
    ADD CONSTRAINT SHIPMENT_FK_d_idx FOREIGN KEY (d_idx)
        REFERENCES DRIVER (d_idx);

ALTER TABLE SHIPMENT
    ADD CONSTRAINT SHIPMENT_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);

ALTER TABLE QUESTION
    ADD CONSTRAINT QUESTION_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);
       
ALTER TABLE NOTICE
    ADD CONSTRAINT NOTICE_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);

ALTER TABLE EVENT
    ADD CONSTRAINT EVENT_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);

ALTER TABLE VERIFY
    ADD CONSTRAINT VERIFY_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);

ALTER TABLE VERIFY
    ADD CONSTRAINT VERIFY_FK_d_idx FOREIGN KEY (d_idx)
        REFERENCES DRIVER (d_idx);

ALTER TABLE VERIFY
    ADD CONSTRAINT VERIFY_FK_e_idx FOREIGN KEY (e_idx)
        REFERENCES EVENT (e_idx);
       
ALTER TABLE POST
    ADD CONSTRAINT POST_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);
      
ALTER TABLE REPLY
    ADD CONSTRAINT REPLY_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);

ALTER TABLE REPLY
    ADD CONSTRAINT REPLY_FK_p_idx FOREIGN KEY (p_idx)
        REFERENCES POST (p_idx);

ALTER TABLE OBJECTS
    ADD CONSTRAINT OBJECT_FK_u_idx FOREIGN KEY (u_idx)
        REFERENCES USER_PROFILE (u_idx);

       
CREATE SEQUENCE USER_PROFILE_SEQ;


SELECT * FROM USER_PROFILE;

DROP TABLE SHIPMENT;
DROP TABLE QUESTION ;
DROP TABLE NOTICE ;
DROP TABLE EVENT ;
DROP TABLE DRIVER ;
DROP TABLE USER_PROFILE ;
DROP TABLE VERIFY ;
DROP TABLE POST ;
DROP TABLE REPLY ;
DROP TABLE OBJECTS ;

