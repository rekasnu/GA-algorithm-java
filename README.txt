--------------------------------------------------
How to compile-and-run the code
--------------------------------------------------

--------------------------------------------------
Brief explanation of the output and what it shows
--------------------------------------------------

Added distance and the name of the town to the final outcome.

Initial distance: 1996
Finished
Final distance: 940
Solution:
|60, 200|20, 160|40, 120|60, 80|20, 40|20, 20|60, 20|100, 40|160, 20|200, 40|180, 60|120, 80|140, 140|180, 100|200, 160|180, 200|140, 180|100, 120|100, 160|80, 180|

As you can see in just 100 generations we were able to find a route just over twice as good as our original and probably pretty close to optimum.
Every location is included at least once and only once. If a route contain a single location more than once,
or missed a location out completely it wouldn't be valid and we would be valuable computation time calculating it's distance.

--------------------------------------------------
Justification for choice of factory pattern
--------------------------------------------------

clearly stating the trade-offs (costs and benefits) of applying the pattern
("on the one-hand the choice of Factory is good because...but on the other it has the negative/drawback that...with respect to the alternatives").
