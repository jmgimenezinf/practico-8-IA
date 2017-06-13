
/**
 * @author Mario Giacobini
 *
 * The problem must provide the following parameters:
 * 	  - variables: the number of variables of the problem
 *    - maxFitness: the optimum (or best known solution) of the problem
 *    - Target.maximize: set whether it is a maximization or minimization problem
 *    - minAllowedValues: Minimum allowed value for each gene  
 *    - maxAllowedValues: Maximum allowed value for each gene
 *
 * The problem: Minimum tardy task problem. Instance of 200 tasks
 * 
 */
 
package problems.Combinatorial;


import jcell.*; //Use jcell package

public class MTTP200 extends Problem
{
	public static final int longitCrom = 200; // Length of chromosomes
	public static final double maxFitness = 0.0025; // Maximum Fitness Value

	
	//max fitness 0.0025
    static int[] lengths = {3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15, 3, 6, 9, 12, 15};
    static int[] deadlines = {5, 10, 15, 20, 25, 29, 34, 39, 44, 49, 53, 58, 63, 68, 73, 77, 82, 87, 92, 97, 101, 106, 111, 116, 121, 125, 130, 135, 140, 145, 149, 154, 159, 164, 169, 173, 178, 183, 188, 193, 197, 202, 207, 212, 217, 221, 226, 231, 236, 241, 245, 250, 255, 260, 265, 269, 274, 279, 284, 289, 293, 298, 303, 308, 313, 317, 322, 327, 332, 337, 341, 346, 351, 356, 361, 365, 370, 375, 380, 385, 389, 394, 399, 404, 409, 413, 418, 423, 428, 433, 437, 442, 447, 452, 457, 461, 466, 471, 476, 481, 485, 490, 495, 500, 505, 509, 514, 519, 524, 529, 533, 538, 543, 548, 553, 557, 562, 567, 572, 577, 581, 586, 591, 596, 601, 605, 610, 615, 620, 625, 629, 634, 639, 644, 649, 653, 658, 663, 668, 673, 677, 682, 687, 692, 697, 701, 706, 711, 716, 721, 725, 730, 735, 740, 745, 749, 754, 759, 764, 769, 773, 778, 783, 788, 793, 797, 802, 807, 812, 817, 821, 826, 831, 836, 841, 845, 850, 855, 860, 865, 869, 874, 879, 884, 889, 893, 898, 903, 908, 913, 917, 922, 927, 932, 937, 941, 946, 951, 956, 961};
    static double[] weights = {60.0, 40.0, 7.0, 3.0, 50.0, 120.0, 80.0, 7.0, 3.0, 100.0, 180.0, 120.0, 7.0, 3.0, 150.0, 240.0, 160.0, 7.0, 3.0, 200.0, 300.0, 200.0, 7.0, 3.0, 250.0, 360.0, 240.0, 7.0, 3.0, 300.0, 420.0, 280.0, 7.0, 3.0, 350.0, 480.0, 320.0, 7.0, 3.0, 400.0, 540.0, 360.0, 7.0, 3.0, 450.0, 600.0, 400.0, 7.0, 3.0, 500.0, 660.0, 440.0, 7.0, 3.0, 550.0, 720.0, 480.0, 7.0, 3.0, 600.0, 780.0, 520.0, 7.0, 3.0, 650.0, 840.0, 560.0, 7.0, 3.0, 700.0, 900.0, 600.0, 7.0, 3.0, 750.0, 960.0, 640.0, 7.0, 3.0, 800.0, 1020.0, 680.0, 7.0, 3.0, 850.0, 1080.0, 720.0, 7.0, 3.0, 900.0, 1140.0, 760.0, 7.0, 3.0, 950.0, 1200.0, 800.0, 7.0, 3.0, 1000.0, 1260.0, 840.0, 7.0, 3.0, 1050.0, 1320.0, 880.0, 7.0, 3.0, 1100.0, 1380.0, 920.0, 7.0, 3.0, 1150.0, 1440.0, 960.0, 7.0, 3.0, 1200.0, 1500.0, 1000.0, 7.0, 3.0, 1250.0, 1560.0, 1040.0, 7.0, 3.0, 1300.0, 1620.0, 1080.0, 7.0, 3.0, 1350.0, 1680.0, 1120.0, 7.0, 3.0, 1400.0, 1740.0, 1160.0, 7.0, 3.0, 1450.0, 1800.0, 1200.0, 7.0, 3.0, 1500.0, 1860.0, 1240.0, 7.0, 3.0, 1550.0, 1920.0, 1280.0, 7.0, 3.0, 1600.0, 1980.0, 1320.0, 7.0, 3.0, 1650.0, 2040.0, 1360.0, 7.0, 3.0, 1700.0, 2100.0, 1400.0, 7.0, 3.0, 1750.0, 2160.0, 1440.0, 7.0, 3.0, 1800.0, 2220.0, 1480.0, 7.0, 3.0, 1850.0, 2280.0, 1520.0, 7.0, 3.0, 1900.0, 2340.0, 1560.0, 7.0, 3.0, 1950.0, 2400.0, 1600.0, 7.0, 3.0, 2000.0};

    int tasks = 200;


    public MTTP200()
    {
    	super();
		variables = longitCrom;
		super.maxFitness = maxFitness;
    	Target.maximize = true;
    }
    
    public Object eval(Individual ind)
    {
	BinaryIndividual bi = (BinaryIndividual)ind;
	double fitness = 0.0;
	boolean feasible = true;
	int time = 0;
	double penalty = 0.0;
	double first = 0.0;
	double second = 0.0;


	for (int i = 0; i < tasks; i++) {

	    if (bi.getBooleanAllele(i)) {
		if (time+lengths[i] > deadlines[i]) {      
		    feasible = false;
		    penalty += weights[i];
		} else {
		    time += lengths[i];
		}
	    }

	    if (!bi.getBooleanAllele(i)) {
		first += weights[i];
	    } 

	    second += weights[i];

	}

	if (feasible) {
	    fitness = 1.0 / (first + penalty);
	} else {
	    fitness = 1.0 / (first + second + penalty);
	}

	return new Double(fitness);
    }
}
