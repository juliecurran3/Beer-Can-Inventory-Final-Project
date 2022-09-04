select beer_id, beer_name from beer where beer_id = 2;
select * from brewery;
select * from beer;
select * from tub;
insert into beer (beer_id, beer_name)
values (1, 'Black Scauldron');
insert into brewery (brewery_id, beer_id, brewery_name)
values (1, 3, 'Adroit Theory');
insert into beer (beer_id, beer_name)
values (2,'Rebel');
insert into tub (beer_id, brewery_id, tub_id, tub_name, can_quantity)
values (1, 1, 3, 2, 3);

insert into beer (beer_id, beer_name)
values (5, 'Black Pup');
insert into brewery (brewery_id, beer_id, brewery_name)
values (7, 5,'Black Dog');
insert into beer (beer_id, beer_name)
values (4,'NeoBlast');
insert into tub (beer_id, brewery_id, tub_id, tub_name, can_quantity)
values (3, 2, 5, 5, 1);
insert into tub (beer_id, brewery_id, tub_id, tub_name, can_quantity)
values (3, 2, 6, 6, 1);
insert into tub (beer_id, brewery_id, tub_id, tub_name, can_quantity)
values(4, 2, 7, 6, 1);


UPDATE Tub SET can_quantity = 2 WHERE tub_id = 3;




