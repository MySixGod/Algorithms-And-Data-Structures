SELECT  product_id 
       ,round( (
SELECT  SUM(units * (
SELECT  price
FROM Prices
WHERE product_id = p.product_id 
AND u.purchase_date >= start_date 
AND u.purchase_date <= end_date)) 
FROM UnitsSold u
WHERE p.product_id = product_id) / ( 
SELECT  SUM(units)
FROM UnitsSold
WHERE product_id = p.product_id), 2) AS average_price 
FROM Prices p; 



# Write your MySQL query statement below

SELECT  s1.student_id
       ,s1.student_name
       ,s2.subject_name
       ,COUNT(e.subject_name)
FROM Students s1 , Subjects s2
LEFT JOIN Examinations e
GROUP BY  s1.student_id
         ,s2.subject_name
ORDER BY s1.student_id
         ,s2.subject_name;























