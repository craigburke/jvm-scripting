List list1 = [1,5,3]
List list2 = list1.sort()
assert list1 == [1,3,5]
assert list2 == [1,3,5]

List list3 = [1,5,3]
List list4 = list1.sort(false)
assert list3 == [1,5,3]
assert list4 == [1,3,5]

try {
    List list5 = [1,5,3].asImmutable()
    List list6 = list5.sort()
}
catch(UnsupportedOperationException ex) {
    // Throws exception when not sorted without altering the original list
}

