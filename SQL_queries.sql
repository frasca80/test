-- following statements refer to Oracle SQL

-- task A
SELECT  cust.Name, prod.Name, SUM(item.Amount) AS Pieces
FROM    Sales sal 	INNER JOIN SalesItem item ON sal.TranID = item.TranID
				INNER JOIN Customer cust ON cust.CustomerID = sal.CustomerID
				INNER JOIN Products prod ON prod.ProductID = sal.ProductID
WHERE	EXTRACT(year FROM sal.DateTime) = 2015
GROUP BY cust.Name, prod.Name
HAVING SUM(item.Amount) >= 10

-- task B
SELECT  prod.Name, SUM(NVL(item.Amount, 0)) AS Pieces
FROM    Sales sal 	INNER JOIN SalesItem item ON sal.TranID = item.TranID
				INNER JOIN Customer cust ON cust.CustomerID = sal.CustomerID
				RIGHT JOIN Products prod ON prod.ProductID = sal.ProductID
WHERE	sal.DateTime IS NULL OR (EXTRACT(year FROM sal.DateTime) <= 2015 AND EXTRACT(year FROM sal.DateTime) >= 2010)
GROUP BY prod.Name
ORDER BY SUM(NVL(item.Amount, 0)) DESC, prod.Name

-- task C
SELECT  cust.CustomerID, cust.Name, SUM(sal.Amount * price.Price) AS Total
FROM    Sales sal 	INNER JOIN SalesItem item ON sal.TranID = item.TranID
				INNER JOIN Customer cust ON cust.CustomerID = sal.CustomerID
				INNER JOIN Products prod ON prod.ProductID = sal.ProductID
				INNER JOIN ProductPrices price ON price.ProductID = prod.ProductID
WHERE	TO_DATE(price.ValidFrom, 'YYYY-MM-DD') <= sal.DateTime AND NOT EXISTS (SELECT * FROM ProductPrices WHERE ProductID = prod.ProductID AND TO_DATE(price.ValidFrom, 'YYYY-MM-DD') <= sal.DateTime AND ValidFrom > price.ValidFrom )
GROUP BY cust.CustomerID, cust.Name
ORDER BY cust.Name

-- task D
SELECT Year, MAX(Name) KEEP (DENSE_RANK FIRST ORDER BY Pieces DESC, DistinctCustomer DESC) AS Product, MAX(Pieces)
FROM (
	SELECT  EXTRACT(year FROM sal.DateTime) AS Year, prod.Name, SUM(item.Amount) AS Pieces, COUNT(DISTINCT cust.CustomerID) AS DistinctCustomer
	FROM    Sales sal 	INNER JOIN SalesItem item ON sal.TranID = item.TranID
					INNER JOIN Customer cust ON cust.CustomerID = sal.CustomerID
					INNER JOIN Products prod ON prod.ProductID = sal.ProductID
	GROUP BY EXTRACT(year FROM sal.DateTime), prod.Name
	)
GROUP BY Year