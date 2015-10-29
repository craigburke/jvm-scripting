class ClosureContainer {
    Closure simpleClosure = {
        println "this: ${this.getClass().name}"
        println "owner: ${owner.getClass().name}"
        println "delegate: ${delegate.getClass().name}"
    } 
    
    Closure nestedClosure = {
        def inner = {
            println "this: ${this.getClass().name}"
            println "owner: ${owner.getClass().name}"
            println "delegate: ${delegate.getClass().name}"
        }
        inner()
    }
}

class Foo { }

def container = new ClosureContainer()

println '--Simple Closure--'
Closure simpleClosure = container.simpleClosure
simpleClosure()

println '\n--Nested Closure--'
Closure nestedClosure = container.nestedClosure
nestedClosure()

println '\n--Simple with Reassigned Delegate--'
simpleClosure.delegate = new Foo()
simpleClosure()