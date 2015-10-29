// findAll
List list = [1,2,3,10,100]
List list2 = list.findAll { it > 2 }
assert list == [1,2,3,10,100]
assert list2 == [3,10,100]

// collect
List list3 = list.collect { it + 1 }
assert list == [1,2,3,10,100]
assert list3 == [2,3,4,11,101]

// inject
int total = list.inject(0) { int total, int number ->
    total + number
}
assert list == [1,2,3,10,100]
assert total == 116