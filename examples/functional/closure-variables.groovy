class Foo {
	static int count = 0
	
    static void execute(Closure closure) {
    	count++
		closure(count)
	}
}

5.times {
    Foo.execute { 
       println "Execution count: ${it}"
   }
}

5.times {
    Foo.execute { int executionCount -> 
        println "Execution count: ${executionCount}"
    }
}