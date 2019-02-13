package cs131.pa2.CarsTunnels;

import cs131.pa2.Abstract.Direction;
import cs131.pa2.Abstract.Tunnel;
import cs131.pa2.Abstract.Vehicle;

public class BasicTunnel extends Tunnel{
	
	protected int vehicleType; //1 for car, 2 for Sled， 3 for amb
	protected Direction direction;
	protected int capacity;
	protected Boolean sameT;
	private Boolean ambExist;
	
	public BasicTunnel(String name) {
		super(name);
		capacity = 0;
		sameT = true;
		ambExist = false;
	}

	@Override
	public synchronized boolean tryToEnterInner(Vehicle vehicle) {
		
		String[] info = vehicle.toString().split("\\s+");
		
		if (capacity == 0) { //case 1, the first vehicle defines this tunnel
			if (info[1].equals("CAR")){
				this.vehicleType = 1;
			}	
			else if(info[1].equals("SLED")){
				this.vehicleType = 2;
			}	
			else{
				this.vehicleType = 3;
			}	
			this.direction = vehicle.getDirection();
			capacity ++;
			return true;
		} else {// case 2, not the first car
			
			if (this.direction.equals(vehicle.getDirection())) {
				if (info[1].equals("CAR") && this.vehicleType==1 && !ambExist) { // case car
					if (capacity < 3) {
						capacity ++;
						return true;
					} 
					
				} else if (info[1].equals("SLED") && this.vehicleType==2 && !ambExist) { // case sled
					if (capacity < 1) {
						capacity ++;
						return true;
					} 
				} else if(vehicle instanceof Ambulance){
					ambExist = true;
					sameT = true;
					return true;
					
				}
			}
			
		}
		
		
		return false;
	}

	@Override
	public synchronized void exitTunnelInner(Vehicle vehicle) {
		capacity --;
	}
	
}
