# AI1b-N-Queens

This is a university AI programming assignment to solve the n-Queens problem using the hill climbing algorithm

COMPILE:  
      `javac -sourcepath <directory>/ <directory>/*.java`

e.g.  
    `javac -sourcepath ./src/ ./src/*.java`  
    `javac -sourcepath src/ src/*.java`  
    `javac *.java` (if already in src directory)  
  
RUN:  
    `java -cp <directory> Main <arguments>`  
    `java Main <arguments>` (if already in src directory)  
    
Arguments:  
	    - int N(dimensions and number of Queens)  
	    - int k(number of nodes for beam search to consider)  
	    - int maxIterations(maximum number of iterations for beam search to complete)  
	    - anytime add as last argument (useRR) : "true" (use beam search with restart if stuck in local minima)  
	    - without arguments defaults: N = 8, k = 20, maxIterations = 500, useRR = false  
      
e.g.  
`java -cp ./src Main`  
		 	    results in (default N = 8, k = 20, maxIterations = 500, useRR = false)  
		 `java -cp ./src Main true`  
		 	    results in (default N = 8, k = 20, maxIterations = 500, BUT useRR = true)  
		 `java -cp ./src Main 20 true`  
		 	    results in (default k = 20, maxIterations = 500, BUT N = 20, useRR = true)  
		 `java -cp ./src Main 30 150`  
			     results in (default maxIterations = 500, useRR = false, BUT N = 30, k = 150)  
		 `java -cp ./src Main 15 30 100`  
		 	    results in (default useRR = false, BUT N = 15, k = 30, maxIterations = 100)  
		 `java -cp ./src Main 40 25 400 true`  
			     results in (N = 40, k = 25, maxIterations = 400, useRR = true)
