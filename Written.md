## Exercise \#1
What is the difference between a ```KeyListener``` and a ```KeyAdapter```?
A keyAdapter makes the keyboard presses something that can be used by java, and a keylistener listens for changes that happen to the keyboard through the keyAdapter.
Keyadapter is an interface. Keylistener is a class.


## Exercise \#2
What is the difference between a ```MouseListener``` and a ```MouseMotionListener```.

## Exercise \#3
Given a ```MouseEvent```, Java has the ```getButton``` and ```getModifiersEx``` methods for determining which mouse buttons are pressed. Are both methods really needed, that is, do they differ in any way?

## Exercise \#4
What is meant by an event source, event listener, and event object?
Event source is any value (i/o, timer, etc.)that changes or is "adapted" to be used in a program, the event listener is ran when the event source changes or triggers the listener.
The event object contains the details of the event source, such as a point where the cursor is, or a key is pressed.


## Exercise \#5
What is the purpose of an anonymous inner class? What would one use an anonymous inner class for?
