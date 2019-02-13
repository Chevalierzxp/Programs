package cs131.pa2.CarsTunnels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import cs131.pa2.Abstract.Tunnel;
import cs131.pa2.Abstract.Vehicle;
import cs131.pa2.Abstract.Log.EventType;

public class PriorityScheduler extends Tunnel{

	private Collection<Tunnel> tunnels;
	//private ArrayBlockingQueue<LinkedBlockingQueue<Vehicle>> waitLine;
	private LinkedList<Vehicle> waitLine0;
	private LinkedList<Vehicle> waitLine1;
	private LinkedList<Vehicle> waitLine2;
	private LinkedList<Vehicle> waitLine3;
	private LinkedList<Vehicle> waitLine4;
	private HashMap<Vehicle, Tunnel> pairMap = new HashMap<Vehicle, Tunnel>();
//	private final Object lock;
	
	public PriorityScheduler(String name, Collection<Tunnel> Tunnels) {
		super(name);
		this.tunnels = Tunnels;
		/*waitLine = new ArrayBlockingQueue<LinkedBlockingQueue<Vehicle>>(100);
		for (int i = 0; i < 5; i++)
			waitLine.add(new LinkedBlockingQueue<Vehicle>());*/
		waitLine0 = new LinkedList<Vehicle>();
		waitLine1 = new LinkedList<Vehicle>();
		waitLine2 = new LinkedList<Vehicle>();
		waitLine3 = new LinkedList<Vehicle>();
		waitLine4 = new LinkedList<Vehicle>();
		
//		lock = new Object();
	}

	@Override
	public boolean tryToEnterInner(Vehicle vehicle) {
		
		
		int priority = this.sortPriority(vehicle);// sorts vehicle based on priority
		synchronized(this) {
		while (this.moreSuperior(priority, vehicle)) { //waits while not prioritized
			try {
				//Thread.currentThread().wait();
				//this.wait();
				//vehicle.wait(); //race condition
				//lock.wait();
		
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(true) { //critical section
            for(Tunnel tunnel : tunnels) {
                if(tunnel.tryToEnter(vehicle)) {
                	pairMap.put(vehicle, tunnel);
                	//Thread.currentThread().notifyAll();
                	//vehicle.notifyAll();
                	//this.notifyAll();
                	//lock.notifyAll();

                	removeFromLine(priority);

                	notifyAll();

               
                    return true; 
                }
            }
            try {
				//Thread.currentThread().wait();
            	//this.wait();
            	//vehicle.wait();
            	//lock.wait();
            	this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
		}
	}
	
	public void removeFromLine(int prior) {
		switch(prior) {
		case 0: waitLine0.removeFirst();
				break;
		case 1: waitLine1.removeFirst();
				break;
		case 2: waitLine2.removeFirst();
				break;
		case 3: waitLine3.removeFirst();
				break;
		case 4: waitLine4.removeFirst();
				break;
		default: return;
		}
	}
	
	public int sortPriority(Vehicle vehicle) { // sorts vehicle based on priority
		
		switch(vehicle.getPriority()) {
		case 0:	waitLine0.add(vehicle);
				return 0;
				
		case 1:	waitLine1.add(vehicle);
				return 1;
		
		case 2:	waitLine2.add(vehicle);
				return 2;
		
		case 3:	waitLine3.add(vehicle);
				return 3;
			
		case 4:	waitLine4.add(vehicle);
				return 4;
				
		}
		
		return 0;
	}
	
	public boolean moreSuperior(int prior, Vehicle vehi) {
		for(int i = 4; i > prior; i--) {

		switch(i) {
		case 0: if (!waitLine0.isEmpty())
					return true;
				break;
		case 1: if (!waitLine1.isEmpty())
					return true;
				break;
		case 2: if (!waitLine2.isEmpty()) {
						notifyAll();
						return true;

				}
				break;
		case 3: if (!waitLine3.isEmpty()) {
					notifyAll();
					return true;
					}
					
				break;
		case 4: if (!waitLine4.isEmpty()) {
					notifyAll();
					return true;
					}
				break;
		
		}
		}
		

		switch(prior) {
		case 0: if (waitLine0.peek().equals(vehi)) {
				
				return false;
				}
					
				break;
		case 1: if (waitLine1.peek().equals(vehi)) {
					return false;
					}
				break;
		case 2: if (waitLine2.peek().equals(vehi))
					return false;
				break;
		case 3: if (waitLine3.peek().equals(vehi))
					return false;
				break;
		case 4: if (waitLine4.peek().equals(vehi))
					return false;
				break;
		}
		
		return true;
	}

	@Override
	public synchronized void exitTunnelInner(Vehicle vehicle) {
		pairMap.get(vehicle).exitTunnel(vehicle);
		notifyAll();
		//this.notifyAll();
		//vehicle.notifyAll();
		//Thread.currentThread().notifyAll();
		//lock.notifyAll();
	}
	
	
}
