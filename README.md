# mars-rover-1
add obstacles detecation





I wanted to implement my code in a clean and intuitive way, hence I have chosen to go against heavily commenting my code, and rather opting to name my tests, methods and variables in an intuitive way that anybody can follow. I have aimed to make the code as small and concise as possible.

I began by identifying the Objects and Interfaces I would need, the Plateau, Rover, Direction, Command. I implemented these as the very basic POJO's, as well as this I also created an empty MarsRover entry class and a InputUtil utility class for reading in the input. I then began looking at using Design Patterns and Test Driven Development.

I wanted to demonstrate, as per the specification, that I could use strong Object Oriented (OO) programming concepts, so I have attempted to implement two Design Patterns that I studied for this task. Firstly I studied and implemented the State design pattern to represent the different Directions a Rover can have as States, as there was a need for different functionality on the behaviours of the Rover dependent on which Direction (State) it was in. Secondly I studied and implemented the Command design pattern for sending and executing the various Commands the Rover needed to execute. This is my first solo delve into these Design Patterns and so I appreciate this may not be a completely accurate implementation of them.

I come from a non TDD background, so I have researched this and attempted to complete this problem using only a TDD approach. I followed the Red, Green, Refactor approach, as such all of my test were written first, then ran and broken (Red), then I implemented the code / logic (Green) and finally any refactoring that was needed. I have implemented all of my tests using JUnit and have included a Test Suite class to enable them to all be run at once. Again, this is my first real delve into TDD solo, so I may be lacking test coverage in some areas and have over tested in others.

In conclusion I'd love the opportunity to discuss both the Design Pattern implementations and TDD approach further with your developers, as I'm sure there's a lot I can learn and improve in these aspects.






Description

Develop an api that moves a rover around on a grid.

You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
The rover receives a character array of commands.
Implement commands that move the rover forward/backward (f,b).
Implement commands that turn the rover left/right (l,r).
Implement wrapping from one edge of the grid to another. (planets are spheres after all)
Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.
