package c3;

/**
*   This class handles our genetic algorithm so it can evolve a
*	population which is a group of possible interchangeable solutions to the travelling salesman problem
*	<p>
*	(represented by a set of chromosomes - inspired by Darwin's theory about evolution)
*
*   @author Ermins Dreimanis, David Sullivan, Moroof Shobowale
*   @version 1
*/


public class GeneticAlgorithm {

    /**
	*   Parameters for the genetic algorithm
	*/
    private final int sizeOfPool = 5;
    private final double percentageMutationRatio = 0.015;
    private final boolean processOfElitism = true;

    /**
	*   A population of solutions is evolved over one generation (particular set of new solutions created by copying attributes from
	*	each parent chromosome to form new offspring i.e. new solution to the problem).
	*	<p>
	*	One crosover point is used here (up to a point permutation is copied from the first parent, after this point
	*	permutation is copied from the second parent - if the city is not yet in the offspring's tour/route it is added).
	*/
    Chromosome_pop pop_evolve_1(Chromosome_pop p) {
        Chromosome_pop newChromosome_pop = new Chromosome_pop(p.Chromosome_pop_Size());

        /**
		*   Since elitism occurs in which at least one best solution is copied without changes to a new population
		*	(so the best solution found can survive to end of run) our best individual i.e. solution is kept hoping
		*	it will be better than other individuals.
		*/

  //      System.out.println(p);
        int solution_best = 0;
        if (processOfElitism) {
            newChromosome_pop.storeRoute(0, p.getBest());
            solution_best = 1;
        }

        newChromosome_pop = 1_Chromosome_pop(solution_best, newChromosome_pop,p);

        /**
		*   The new population is mutated to add some new "genetic material"
		*	and individuality to the solution.
		*
		*	@return New population which was mutated
		*/
        for (int a = solution_best; a < newChromosome_pop.Chromosome_pop_Size(); a++) {
            processOfMutation(newChromosome_pop.getRoute(a));
        }

        return newChromosome_pop;
    }

    /**
	*   A two point cros over is used here to evolve a population over one generation
	*	(i.e. from beginning of the chromosome to the first crossover point is copied from one parent,
	*	the part from the first to the second crossover point
	*	is then copied from the second parent and the rest is copied from the first parent).
	*/
    Chromosome_pop pop_evolve_2(Chromosome_pop p) {
        Chromosome_pop newChromosome_pop = new Chromosome_pop(p.Chromosome_pop_Size());

        /**
		*   Again elitism occurs in which at least one best solution is copied without changes to a new population.
		*	Our best individual i.e. solution is kept hoping
		*	it will be better than other individuals.
		*/
        int solution_best = 0;
        if (processOfElitism) {
            newChromosome_pop.storeRoute(0, p.getBest());
            solution_best = 1;
        }
        newChromosome_pop = 2_Chromosome_pop(solution_best, newChromosome_pop,p);

        /**
		*   Again the new population is mutated
		*	to add some new "genetic material" and individuality to the solution.
		*
		*	@return New population which was mutated
		*/
        for (int a = solution_best; a < newChromosome_pop.Chromosome_pop_Size(); a++) {
            processOfMutation(newChromosome_pop.getRoute(a));
        }

        return newChromosome_pop;
    }

    /**
	*   Construct new individuals/solutions by
	*	looping over the current population.
	*
	*	@return New population created
	*/
    Chromosome_pop 2_Chromosome_pop(int solution_best, Chromosome_pop newChromosome_pop, Chromosome_pop p){
        for (int a = solution_best; a < newChromosome_pop.Chromosome_pop_Size(); a++) {
            /**
			*   Select both chromosome parents from a population
			*/
            Route first_parent = selectCandidate(p);
            Route second_parent = selectCandidate(p);
            /**
			*   Cross over the parents to form a new offspring using a two point crossover probability
			*/
            Route offspring = 2Pointcrossover(first_parent, second_parent);
            /**
			*   Place new offspring in a new population
			*/
            newChromosome_pop.storeRoute(a, offspring);
        }
    	return newChromosome_pop;
    }

   	/**
   	*   Cross over the population using a one point crossover probability
	*/
    Chromosome_pop 1_Chromosome_pop(int solution_best, Chromosome_pop newChromosome_pop, Chromosome_pop p){
        for (int a = solution_best; a < newChromosome_pop.Chromosome_pop_Size(); a++) {
            /**
			*   Select both chromosome parents from a population
			*/
            Route first_parent = selectCandidate(p);
            Route second_parent = selectCandidate(p);
            /**
			*   Cross over the parents to form a new offspring using a two point crossover probability
			*/
            Route offspring = 1Pointcrossover(first_parent, second_parent);
            /**
			*   Place new offspring in a new population
			*/
            newChromosome_pop.storeRoute(a, offspring);
        }
    	return newChromosome_pop;
    }


    /**
	*   Applies a two point cros over to a pair of chromosomes i.e. the parents and creates a child from them
	*/
    Route 2Pointcrossover(Route first_parent, Route second_parent) {
        /**
		*   This creates a new child tour i.e. route
		*/
        Route offspring = new ChildTour(first_parent.childTourSize());

        /**
		*   Finds the start and end positions for this sub route
		*	in relation to the first parent's tour
		*/
        int subRouteStart = (int) (Math.random() * first_parent.childTourSize());
        int subRouteEnd = (int) (Math.random() * first_parent.childTourSize());

        /**
		*   Adds this sub tour (route) to the offspring using a for loop
		*/
        for (int a = 0; a < offspring.childTourSize(); a++) {
            /**
			*   Start position is less than the end position
			*/
            if (subRouteStart < subRouteEnd && a > subRouteStart && a < subRouteEnd) {
                offspring.setLocation(a, first_parent.getLocation(a));
            }
            /**
			*   Else start position is greater than the end position
			*/
            else if (subRouteStart > subRouteEnd) {
                if (!(a < subRouteStart && a > subRouteEnd)) {
                    offspring.setLocation(a, first_parent.getLocation(a));
                }
            }
        }

        /**
		*   Loop through the second parent's route
		*	@return Offspring with city contained in its tour i.e. route
		*/
        for (int a = 0; a < second_parent.childTourSize(); a++) {
            /**
			*   Add the city to the offspring's route if route doesn't contain the city
			*/
            if (!offspring.includesLocation(second_parent.getLocation(a))) {
                /**
				*   Loop and get slot in the offspring's tour and add the city
				*/
                for (int aa = 0; aa < offspring.childTourSize(); aa++) {
                    if (offspring.getLocation(aa) == null) {
                        offspring.setLocation(aa, second_parent.getLocation(a));
                        break;
                    }
                }
            }
        }
        return offspring;
    }

    Route 1Pointcrossover(Route first_parent, Route second_parent) {
        /**
		*   Creates a new child tour
		*/
        Route offspring = new ChildTour(first_parent.r);
        int point = (int) (Math.random() * first_parent.childTourSize());
        /**
		*   Loop through the tour and add part to the offspring's tour
		*/
        for (int a = 0; a < offspring.childTourSize(); a++) {
            /**
			*   Get cities from the first parent up to the crossover point and copy them into the child's tour
			*/
            if (a<=point) {
                offspring.setLocation(a, first_parent.getLocation(a));
            }
        }

        /**
		*   Then add any missing cities from the second parent's tour/route
		*/
        for (int a = 0; a < second_parent.childTourSize(); a++) {
            /**
			*   Add the city to the offspring's route if route doesn't contain the city
			*/
            if (!offspring.includesLocation(second_parent.getLocation(a))) {
                /**
				*   Loop and get slot in the offspring's tour and add the city
				*/
                for (int aa = 0; aa < offspring.childTourSize(); aa++) {
                    if (offspring.getLocation(aa) == null) {
                        offspring.setLocation(aa, second_parent.getLocation(a));
                        break;
                    }
                }
            }
        }
        return offspring;
    }

    /**
	*   Swap mutation is used to mutate the route
	*	i.e. two locations in the route are selected at random and their positions are swapped.
	*	<p>
	* 	This method is only capable of shuffling the route, not
	*	adding or removing a location from the route, otherwise it would risk creating an invalid solution.
	*	It will never create a list which has missing or duplicate values when compared to the original.
	*/
    private void processOfMutation(Route r) {
        /**
		*   Loop through the cities in the route/tour
		*/
        for(int Route_1=0; Route_1 < r.childTourSize(); Route_1++){
            /**
			*   Apply the mutation rate and randomly find the second location in the tour
			*/
            if(Math.random() < percentageMutationRatio){
                int Route_2 = (int) (r.childTourSize() * Math.random());

                /**
				*   Find the two cities and swap their positions
				*/
                Location location_1 = r.getLocation(Route_1);
                Location location_2 = r.getLocation(Route_2);
                r.setLocation(Route_2, location_1);
                r.setLocation(Route_1, location_2);
            }
        }
    }

    /**
	*   Tour is chosen for crossover
	*/
    private Route selectCandidate(Chromosome_pop p) {
        /**
		*   A few individuals are chosen at random from the population for a "pool" or "tournament"
		*	to determine which has the best fitness for crossover
		*/
        Chromosome_pop pool = new Chromosome_pop(sizeOfPool);
        /**
		*   Now find a random tour and add it
		*/
        for (int a = 0; a < sizeOfPool; a++) {
            int randomId = (int) (Math.random() * p.Chromosome_pop_Size());
            pool.storeRoute(a, p.getRoute(randomId));
        }
        /**
		*   Find the "fittest"
		*	@return Which route/tour is the best/most valuable solution to this particular problem
		*/
        Route best_solution = pool.getBest();
        return best_solution;
    }
}

