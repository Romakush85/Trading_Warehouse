insert into supplier (name, reg_number, id)
values ('Coca-Cola HBC Ukraine Ltd', 54334512, '4e3c27be-76de-496a-bed2-fb2dcb71ab7a');
insert into contacts (address, contact_person, contractor_id, email, phone_number, id)
values ('Velyka Dymerka, Kyiv region, Ukraine, 07442', 'Andrey Muzyka', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'ccbu@cchellenic.com', '0444900707', '072f378d-a7a8-44db-856a-4044668dfbe3');
insert into contract (contractor_id, date, number, id)
values ('4e3c27be-76de-496a-bed2-fb2dcb71ab7a', '11/09/2020', 'SUP-43', 'e9072bc9-9402-45eb-8e9a-cc088692879c');

insert into supplier (name, reg_number, id)
values ('PepsiCo', 32233321, 'dd3dceac-6e6f-11ee-b962-0242ac120002');
insert into contacts (address, contact_person, contractor_id, email, phone_number, id)
values ('Odesa, Ukraine', 'Serhiy Pavlenko', 'dd3dceac-6e6f-11ee-b962-0242ac120002', 'serhiy@pepsi.co', '0934224322', '05bb910c-6e70-11ee-b962-0242ac120002');
insert into contract (contractor_id, date, number, id)
values ('dd3dceac-6e6f-11ee-b962-0242ac120002', '10/07/2021', 'SUP-11', '05bb9332-6e70-11ee-b962-0242ac120002');

insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 10.92, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Coca-Cola 250ml glass', 'b60b785c-77f2-11ee-b962-0242ac120002');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 7.32, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Coca-Cola 250ml, cans', 'b60b7e56-77f2-11ee-b962-0242ac120002');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 8.04, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Coca-Cola 330ml, cans', '76f2e126-78b2-11ee-b962-0242ac120002');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 9.78, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Coca-Cola 500ml, PET', 'b60b7e56-77f2-11ee-b962-0242ac120003');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 14.82, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Coca-Cola 1Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120004');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 18.00, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Coca-Cola 1.5Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120005');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 24.72, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Coca-Cola 2Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120006');

insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 10.92, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta Orange 250ml glass', 'b60b785c-77f2-11ee-b962-0242ac120007');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 7.32, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta Orange 250ml, cans', 'b60b7e56-77f2-11ee-b962-0242ac120008');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 8.04, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta Orange 330ml, cans', 'b60b7e56-77f2-11ee-b962-0242ac120009');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 9.78, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta Orange 500ml, PET', 'b60b7e56-77f2-11ee-b962-0242ac120010');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 13.08, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta Orange 1Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120011');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 15.96, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta Orange 1.5Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120012');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 21.18, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Fanta Orange 2Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120013');

insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 10.92, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 250ml glass', 'b60b785c-77f2-11ee-b962-0242ac120014');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 7.32, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 250ml, cans', 'b60b7e56-77f2-11ee-b962-0242ac120015');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 8.04, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 330ml, cans', 'b60b7e56-77f2-11ee-b962-0242ac120016');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 9.78, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 500ml, PET', 'b60b7e56-77f2-11ee-b962-0242ac120017');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 13.08, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 1Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120018');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 15.96, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 1.5Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120019');
insert into product (category, purchase_price, currency, supplier_id, title, id)
values ('BEVERAGE', 21.18, 'UAH', '4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'Sprite 2Lt, PET', 'b60b7e56-77f2-11ee-b962-0242ac120020');


