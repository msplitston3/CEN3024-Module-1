import java.util.Scanner;
import static java.lang.System.out;

//Author Name: Michelle Splitstone
//Date: 05/13/2022
//Program Name: Splitstone_Drone
//Program Purpose: Drone Simulation With Buttons On X,Y,Z Axis. 
public class SplitstoneDroneApp {

	public static void main(String[] args) {
		//Initialize keyboard input
		Scanner keyboard = new Scanner(System.in);
		//Initialize new drone
		Drone newDrone = new Drone();
		out.println("Welcome\nPlease Select an option:");
		//User direction select menu that while run until option 8 
		//is selected which will break loop.
		while (true) {
			out.println("Option    Direction\n   1   || Up\n   2   || Down\n   3   || Left"
					+ "\n   4   || Right\n   5   || Forward\n   6   || Backwards"
					+ "\n   7   || Display Current Location\n   8   || Exit");
			int choice = 0;
			try {
				choice = Integer.parseInt(keyboard.nextLine());
			} catch (Exception e) {
				//Leave empty, error message will output via switch case.
			}

			if (choice > 0 && choice < 7) {
				newDrone.moveDrone(choice);
			} else if (choice == 7) {
				newDrone.showCurrentLocation();
			} else if (choice == 8) {
				out.print("Goodbye");
				break;
			} else {
				out.println("Invalid Selection. Enter Valid Selection Between 1 and 8");
			}
		}
	}
}

class Drone {
	//Drone location. Always starts at 0.
	int x = 0;
	int y = 0;
	int z = 0;

	
	//Moves drone location based on user choice input.
	void moveDrone(int direction) {
		switch(direction){
			case 1: y++;
				out.print("You have moved up\n");
				break;
			case 2: y--;
				out.println("You have moved down\n");
				break;
			case 3: x--;
				out.println("You have moved left\n");
				break;
			case 4: x++;
				out.println("You have moved right\n");
				break;
			case 5: z++;
				out.println("You have moved forwards\n");
				break;
			case 6: z--;
				out.println("You have moved backwards\n");
				break;
			default: 
				out.println("Invalid Selection\n");
				break;
		}
	}
	//Will output the current location of the drone
	void showCurrentLocation() {
		out.printf("The Current Location is [X: %d] | [Y: %d] | [Z: %d]\n",x,y,z);
	}
}