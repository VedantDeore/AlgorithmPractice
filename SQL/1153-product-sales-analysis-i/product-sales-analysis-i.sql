# Write your MySQL query statement below

select p2.product_name , p1.year, p1.price from sales as p1 join product as p2 on p1.product_id = p2.product_id;