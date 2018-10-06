# byteland

Approach
1- Make connections with given roads. If a city has a connection, appent to it to parent city.
An example of inputs 4 and 0 1 2 is:  
City0 has City1
City1 has City2
City2 has City3
City3 has no connection.
2- Iterate through cities, unite city with a city which has the lowest possible connection.
Apply unification process by removing city from its parent. 
However, if removed(united) city has any connections, append them to parent city.
For example, In the first step, City0 has only one connection which is City1. That's why, remove 
City1 from connections of City0 and append connections of City1 to City0. From now on, City0 has City2 as a connection because City2 is connection of City1. 
3- Flag United(removed) cities as unified. Do not try to unite them ongoing step. Once united cities is flagged, they need to be removed from actual iteration. 
4- When there is no city to unite which means last remaining city has no connection in iteration, process ends. Count each step for an iteration. 
