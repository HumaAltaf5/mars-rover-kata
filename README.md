
## <p align="center">Mars Rover Kata</p>

### Task:
- Program to move rovers around the surface of Mars

### Assumption:
- The Plateau is a square/rectangular grid for the purpose of  this task.\
In this solution we assume that there might be Obstacles on the Plateau.\
If the Rover finds an Obstacle at a particular location eg. 2,5 and can't move forward, the Rover should move up to 2,4 and stop.

### Representation of a Rover’s Position on the Plateau:
- The Plateau is divided into a grid.
- A Rover’s position is represented by x and y co-ordinates and the letters N, S, W, E to represent North,
South, West, East respectively.

### Movement Rules:
- Rovers move sequentially, this means that the first Rover needs to finish moving first before the next one can move.

### Inputs into the Program :
- #### _First Line of Input to the Program_ :
  1.The first line inputted into the program represents the upper-right coordinates of the Plateau.
   \
  eg. 5,5 means this Plateau has maximum (x, y) co-ordinates of (5, 5).
- #### _Subsequent Lines of Input to Rovers_ :
  1.First Line : \
  The Rover’s position is represented by two integers representing the X and Y coordinates and a letter representing where the Rover is facing 
   eg. 1 2 N. 
  
  2.Second Line - A string of letters representing the instructions to move the Rover around the Plateau.
- R for Rotate right 90 degrees.
- L for Rotate left 90 degrees.
- M for move forward. 

### Output:
For each Rover, the output represents its final position (final coordinates and where it is facing).\
- eg. 3 6 W means rover is at (3,6) facing West.

### Instructions to run the program:
1.Run src/main/java/com/huma/rover/Main.java\
2.Follow the instructions to:
- Input x and y coordinates for Plateau size eg. 10,10.
- Input the x and y coordinates for Rover's current position eg. 5,8
- Input the direction Rover is facing eg. N
- Input the commands to Move or Rotate the Rover Right or Left eg. RLM

### Run Unit Tests
1.Run the unit tests in IntelliJ, or 
2.Go to the terminal and inside the root of this directory, run `mvn test`

### What Next?
This program can be extended to:
- Have Different Types of Plateaus eg Spehere.
- Have different types of Vehicles eg Truck.



