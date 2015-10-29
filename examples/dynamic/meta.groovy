String.metaClass.shout = { 
    delegate.toUpperCase() 
}
assert 'hello everyone'.shout() == 'HELLO EVERYONE'

String instanceString = 'hello world'

instanceString.metaClass.shout = {
	delegate.toUpperCase() + '!!!'
}
assert instanceString.shout() == 'HELLO WORLD!!!'