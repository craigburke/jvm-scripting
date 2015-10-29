class Foo {
    static void execute(Closure closure) {
        println "Setup"
        closure()
        println "CLEANUP"
    }

}

Foo.execute { 
    println "Execute"
}