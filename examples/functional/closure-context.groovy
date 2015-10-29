class ClosureGenerator {
    private static int count = 0
    
    static Closure generate() {
        return {
            count++
        }
    }
    
    static void printCount() {
        println count
    }
}

Closure closure = ClosureGenerator.generate()

5.times { 
    closure()
}

ClosureGenerator.printCount()