insert into supplier (name, reg_number, id)
values ('CocaColaInc', 54334512, '4e3c27be-76de-496a-bed2-fb2dcb71ab7a');
insert into contacts (address, contact_person, contractor_id, email, phone_number, id)
values ('Kyiv, Ukraine', 'Andrey Muzyka', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'andrey@cocacola.ua', '0954333050', '072f378d-a7a8-44db-856a-4044668dfbe3');
insert into contract (contractor_id, date, number, id)
values ('4e3c27be-76de-496a-bed2-fb2dcb71ab7a', '11/09/2020', 'SUP-43', 'e9072bc9-9402-45eb-8e9a-cc088692879c');

insert into supplier (name, reg_number, id)
values ('PepsiCo', 32233321, 'dd3dceac-6e6f-11ee-b962-0242ac120002');
insert into contacts (address, contact_person, contractor_id, email, phone_number, id)
values ('Odesa, Ukraine', 'Serhiy Pavlenko', 'dd3dceac-6e6f-11ee-b962-0242ac120002', 'serhiy@pepsi.co', '0934224322', '05bb910c-6e70-11ee-b962-0242ac120002');
insert into contract (contractor_id, date, number, id)
values ('dd3dceac-6e6f-11ee-b962-0242ac120002', '10/07/2021', 'SUP-11', '05bb9332-6e70-11ee-b962-0242ac120002');

insert into product (category, purchase_price, supplier_id, title, id)
values ('BEVERAGE', 12.60, '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta 6x0.33L Glass', 'b60b785c-77f2-11ee-b962-0242ac120002');
insert into product (category, purchase_price, supplier_id, title, id)
values ('BEVERAGE', 24.80, '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 4x2L Pet', 'b60b7e56-77f2-11ee-b962-0242ac120002');
insert into product (category, purchase_price, supplier_id, title, id)
values ('BEVERAGE', 24.40, 'dd3dceac-6e6f-11ee-b962-0242ac120002', 'Mirinda 6x1.5L Pet', 'b60b807c-77f2-11ee-b962-0242ac120002');
