DROP TABLE Product CASCADE CONSTRAINTS;

CREATE TABLE Product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(100)		 NULL ,
		p_price                       		NUMBER(20)		 NULL ,
		p_desc                        		VARCHAR2(1000)		 NULL ,
		p_image                       		VARCHAR2(100)		 DEFAULT 'images/no_image.jpg'		 NULL 
);

DROP SEQUENCE Product_p_no_SEQ;

CREATE SEQUENCE Product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




ALTER TABLE Product ADD CONSTRAINT IDX_Product_PK PRIMARY KEY (p_no);

