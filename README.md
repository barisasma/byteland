# byteland

My Approach<br />
1- Make connections with given roads. If a city has a connection, appent to it to parent city.<br />
An example of inputs 4 and 0 1 2 is:  <br />
City0 has City1<br />
City1 has City2<br />
City2 has City3<br />
City3 has no connection.<br />
2- Iterate through cities, unite city with a city which has the lowest possible connection.<br />
Apply unification process by removing city from its parent. <br />
However, if removed(united) city has any connections, append them to parent city.<br />
For example, In the first step, City0 has only one connection which is City1. That's why, remove <br />
City1 from connections of City0 and append connections of City1 to City0. From now on, City0 has City2 as a connection because City2 is connection of City1. <br />
3- Flag United(removed) cities as unified. Do not try to unite them ongoing step. Once united cities is flagged, they need to be removed from actual iteration. <br />
4- When there is no city to unite which means last remaining city has no connection in iteration, process ends. Count each step for an iteration. <br />
