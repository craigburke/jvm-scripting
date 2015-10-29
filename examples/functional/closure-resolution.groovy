class Owner {
    String name
    
    void printName() {
        println "** ${name} | FROM: Owner class"
    }
    
    def myClosure = {
        name = 'FOO'
        printName()
    }
}

class MyDelegate {
    String name
    
    void printName() {
        println "-- ${name} | FROM: delegate class"
    }
}

def myOwner = new Owner()
def myDelegate = new MyDelegate()
Closure closure = myOwner.myClosure
closure.delegate = myDelegate

// default owner first strategy
closure()
assert myOwner.name == 'FOO'

// delegate first strategy
closure.resolveStrategy = Closure.DELEGATE_FIRST
closure()
assert myDelegate.name == 'FOO'
