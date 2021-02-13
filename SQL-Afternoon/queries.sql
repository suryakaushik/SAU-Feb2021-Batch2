 Q.2: Write a query to retrieve the most sold product per day in a specific location. You can pick the location of your choice.
 
SELECT 
    p.pcode, p.pname, s.dop, COUNT(*) AS total_sold
FROM
    purchases s
        JOIN
    customer c ON s.cid = c.cid
        JOIN
    product p ON p.pcode = s.pcode
WHERE
    c.lcode = 501
GROUP BY p.pcode , s.dop
ORDER BY COUNT(*) DESC;
 
 Q.3: Write a query to list all the salesperson's details along with the count of products sold by them (if any) till the current date.
 
select * from product b join (select SUM(n.noofunits) as No_of_Products_Sold,n.pcode,x.sid,x.sname,x.sdob,x.sgender from customer m join purchases n on  m.cid=n.cid  
join location l on l.lcode=m.lcode join 
salesexecutive  x   on x.lcode=m.lcode) as a
on b.pcode=a.pcode
GROUP BY salesexecutive.sid
ORDER BY No_of_Products_Sold DESC;
