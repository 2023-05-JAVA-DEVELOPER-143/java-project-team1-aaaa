insert into product values(product_p_no_SEQ.nextval, '안녕하세요', 10000, null, null);
insert into product values(product_p_no_SEQ.nextval, '감사해요', 15000, null, null);
insert into product values(product_p_no_SEQ.nextval, '잘있어요', 20000, null, null);
insert into product values(product_p_no_SEQ.nextval, '다시만나요', 25000, null, null);

update product set p_name = '안만나', p_price = 30000, p_image = '이미지', p_desc = '상세설명' where p_no = 4;

delete from product where p_no = 3;

select * from product where p_no = 4;

select * from product;

commit;