## Exercise \#1
What is the difference between a ```KeyListener``` and a ```KeyAdapter```?
A keyAdapter makes the keyboard presses something that can be used by java, and a keylistener listens for changes that happen to the keyboard through the keyAdapter. Keyadapter is an interface, while Keylistener is a class.


## Exercise \#2
What is the difference between a ```MouseListener``` and a ```MouseMotionListener```.
A ```MouseListener``` is an action listener that listens for mouse clicks or other buttons on the mouse, but does not monitor the cursor's position. A ```MouseMotionListener``` only tracks the cursor's position, and also if it is being dragged or just moved.

## Exercise \#3
Given a ```MouseEvent```, Java has the ```getButton``` and ```getModifiersEx``` methods for determining which mouse buttons are pressed. Are both methods really needed, that is, do they differ in any way? Yes, both are needed. ```getButton``` returns the button push associated with the MouseEvent, and ```getModifiersEx``` returns the full state of the mouse, i.e. what other buttons were also being held down while the button associated with the MouseEvent was pressed.

## Exercise \#4
What is meant by an event source, event listener, and event object?
Event source is any item (i/o, timer, etc.) that does an action (timer ticking, mouse moving, keyboard press). So, if we have a timer we can write a timerListener that listens for any action in the timer. If the timer ticks, then the listener runs with data available from the event source as an event object.
The event object contains the details of the event source, such as a point where the cursor is, or a key that is pressed.


## Exercise \#5
What is the purpose of an anonymous inner class? What would one use an anonymous inner class for?
Anonymous inner classes are helpful when we want to make a single instance of a class that has a few extra items instead of writing up an entirely new subclass for it. i.e. We only have to listen to one mouse, so we make a listener that does all of the things an actionListener does, but it also has the ability to get data from the mouse. They are great for implementing functionality for an instance without needing to write up an entire class.
