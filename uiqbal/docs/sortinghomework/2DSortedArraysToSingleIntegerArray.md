#Input 2D Integer Array
PQ
sizeofallelements
init()
	Create PriorityQueue<Pair<Integer,Iterator>>  *Pair comparator is based on integer(left of pair ) , comparator will decide asc or desc*
	for each array in 2d 
		create ArrayIterator with array at index
		if( iterator.hasNext)
			put item in PQ.put(new Pair(iterator.next(),iterator) )
		fi
		sizeofallelements+=array.length
	end for


sort()
	create result array of sizeofallelements
	int counter=0;
	while(!PQ.isEmpty)
		pair = PQ.pull
		result[counter]=pair.left
		counter++
		if(pair.right.hasnext)
			put item in PQ.put(new Pair(pair.right.next(),iterator) )

	end while

