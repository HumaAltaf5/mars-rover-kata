
Mars Rover Kata

Task:
Program to move rovers around the surface of Mars

Assumption:
The Plateau is a square/rectangular grid for the purpose of  this task.
In this solution we assume that there might be Obstacles on the Plateau.
If the Rover finds an Obstacle at a particular location eg. 2,5 and can't move forward, the Rover should move up to 2,4 and stop.

Representation of a Rover’s Position on the Plateau:
The Plateau is divided into a grid. A Rover’s position is represented by x and y co-ordinates and the letters N, S, W, E to represent North,
South, West, East respectively.

Movement Rules:
Rovers move sequentially, this means that the first Rover needs to finish moving first before the next one can move.

Inputs into the Program :
1.First Line of Input to the Program
The first line inputted into the program represents the upper-right coordinates of the Plateau.
eg. 5 5
This Plateau has maximum (x, y) co-ordinates of (5, 5).

2.Subsequent Lines of Input to Rovers
a.First Line 
The Rover’s position is represented by two integers representing the X and Y coordinates and a letter representing where the Rover is facing 
 eg. 1 2 N

b.Second Line - A string of letters representing the instructions to move the Rover around the Plateau.
R for Rotate right 90 degrees
L for Rotate left 90 degrees
M for move forward 

Output:
For each Rover, the output represents its final position (final coordinates and where it is facing).
eg. 3 6 W


