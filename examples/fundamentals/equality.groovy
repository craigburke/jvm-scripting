String string1 = 'Foo'
String string2 = 'Foo'

// Would be false in Java since they refer to different objects
assert string1 == string2


class Person {
    String name
    
    boolean equals(Person b) {
        this.name == b.name
    }
}

Person person1 = new Person(name: 'Craig Burke')
Person person2 = new Person(name: 'Craig Burke')
Person person3 = new Person(name: 'John Doe')

assert person1 == person2
assert person1 != person3