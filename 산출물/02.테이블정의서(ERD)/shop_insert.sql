/**********************member insert************************/
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user1','1111','임범준','010-1234-4567','user1@naver.com','서울시 송파구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user2','1111','배종호','010-1111-2222','user2@naver.com','서울시 강남구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user3','1111','권경록','010-3333-4444','user3@naver.com','서울시 강서구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user4','1111','이동현','010-5555-6666','user4@naver.com','서울시 동작구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user5','1111','이다영','010-7777-8888','user5@naver.com','서울시 서초구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user6','1111','박근우','010-9999-0000','user6@naver.com','경기도 수원');

/**********************product insert************************/

insert into product values(product_p_no_SEQ.nextval, '나는너랑', 15700, '나는너랑.jpg','100만 부 ..', 0);
insert into product values(product_p_no_SEQ.nextval, '심플라이프', 15750, '심플라이프.jpg','‘정리의 힘’', 0);
insert into product values(product_p_no_SEQ.nextval, '도둑맞은집중력', 16920, '도둑집중.jpg','★아마존,★', 0);
insert into product values(product_p_no_SEQ.nextval, '꿀벌의예언1', 15120, '꿀벌예언.jpg','인류..', 0);
insert into product values(product_p_no_SEQ.nextval, '비가오면열리는상점', 15120, '비오상.jpg','전 세계 독자들..', 0);
insert into product values(product_p_no_SEQ.nextval, '김재우의영어회화100', 19800, '김재우영어.jpg','100일 후,...', 0);
insert into product values(product_p_no_SEQ.nextval, '해커스토익', 16920, '해커스토익.jpg','토익 점수,', 0);
insert into product values(product_p_no_SEQ.nextval, '다태유', 13500, '다태유.jpg','3대륙경험...', 0);


/**********************cart insert************************/
insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,'user1',1,2);
insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,'user1',2,1);

insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,'user2',3,4);
insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,'user2',4,2);
insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,'user2',1,1);


/**********************orders insert************************/
insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'나는너랑외1권',sysdate,50000,'user1');

insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'심플라이프외1권',sysdate-2,40000,'user1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'도둑맞은집중력외1권',sysdate-1,40000,'user2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);


insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'비가오면열리는상점외1권',sysdate,70000,'user2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,2);



insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'다태유외0권',sysdate-1,40000,'user2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'해커스토익외1권',sysdate,30000,'user1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);


commit;
desc order_item;


