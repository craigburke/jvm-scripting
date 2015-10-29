class Foo { 
    int fooValue

    int plus(Bar bar) {
        fooValue + bar.barValue
    }
}

class Bar {
    int barValue
}

Foo foo = new Foo(fooValue: 2)
Bar bar = new Bar(barValue: 3)
assert foo + bar == 5