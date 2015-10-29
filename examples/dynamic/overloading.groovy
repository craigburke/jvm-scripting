assert 1 + 1 == 2

Integer.metaClass.plus = { Integer b -> 3 }
assert 1 + 1 == 3
