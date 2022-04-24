# Oracle test

## Question 1
Please check file SQL_queries.sql

## Question 2
Please check Java classes under com.fscandelli.syntaxtree package.

Final questions and answers:
[Q] Is it possible that in some cases calculation is not finite? 
[A] Yes, for example when symbol expressions refer each other in a circular dependency

[Q] If so, how would you adjust your code to avoid such a situation?
[A] By introducing a validation in ExpressionMap::setExpression to avoid the insertion of a symbol expression that introduces circular dependency
