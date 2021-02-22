create database truyum_sql;
use truYum_sql;

/*1. View Menu Item List Admin (TYUC001)
a. Frame insert scripts to add data into menu_item table. Refer View Menu
Item List Admin screen below for sample data.
b. Frame SQL query to get all menu items*/

create table Menu_Items(id int primary key,Name varchar(30),Price int,Active varchar(10),Date_of_Launch date,Category varchar(30),Free_Delivery varchar(10));
insert into Menu_Items(id,Name,Price,Active,Date_of_Launch,Category,Free_Delivery)
values(1,"Sandwich",99,"Yes","2017-03-15","Main Course","Yes"),
(2,"Burger",129,"Yes","2017-12-23","Main Course","No"),
(3,"Pizza",149,"Yes","2017-08-21","Main Course","No"),
(4,"French Fries",57,"No","2017-07-02","Starters","Yes"),
(5,"Chocolate Brownie",32,"Yes","2022-11-02","Dessert","Yes");
select * from Menu_Items;

/*2. View Menu Item List Customer (TYUC002)
a. Frame SQL query to get all menu items which after launch date and is
active.*/

select * from Menu_Items 
where  Active="Yes" && year(Date_of_Launch)>2018 ;
/*3. Edit Menu Item (TYUC003)
a. Frame SQL query to get a menu items based on Menu Item Id
b. Frame update SQL menu_items table to update all the columns values
based on Menu Item Id
*/

select * from Menu_Items 
where  id=4 ;

update Menu_Items
set Name="briyani",price=200,Active="Yes",Date_of_Launch="2019-06-28",Category="Main Course",Free_Delivery="No"
where id=1;

/*4. Add to Cart (TYUC004)
a. Frame insert scripts for adding data into user and cart tables.In user table
create two users. Once user will not have any entries in cart, while the
other will have at least 3 items in the cart.*/

create table users(user_id INT AUTO_INCREMENT Primary key,
first_name VARCHAR(20),
last_name VARCHAR(20),
address VARCHAR(60));

INSERT INTO  users(first_name,last_name,address)
VALUES('Kingsly','Samuvel','Tiruppur'),('Suresh','Kumar','Cuddalore');

CREATE TABLE cart(
cart_id int  AUTO_INCREMENT PRIMARY KEY ,
user_id int,
id int,
order_date date,
FOREIGN KEY(user_id) REFERENCES users(user_id),
FOREIGN KEY(id) REFERENCES Menu_Items(id)
);

INSERT INTO cart(user_id,id,order_date)values(1,1,"2019-06-28"),(1,3,"2017-08-21"),(1,5,"2022-11-02");


/*5. View Cart (TYUC005)
a. Frame SQL query to get all menu items in a particular user’s cart
b. Frame SQL query to get the total price of all menu items in a particular
user’s cart*/

SELECT m.name,m.active,m.price,m.free_delivery,c.order_date FROM menu_items m
JOIN cart c
ON m.id=c.id join users u on c.user_id=u.user_id
WHERE u.user_id=1;

SELECT SUM(price) Total_Price FROM Menu_Items m
JOIN cart c
ON m.id=c.id
where c.user_id=1;

/*6. Remove Item from Cart (TYUC006)
a. Frame SQL query to remove a menu items from Cart based on User Id
and Menu Item Id*/

delete from cart where user_id=1 and id=1;

