package cs131.pa2.CarsTunnels;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import cs131.pa2.Abstract.Tunnel;
import cs131.pa2.Abstract.Vehicle;
import cs131.pa2.Abstract.Log.Log;

public class PreemptivePriorityScheduler extends Tunnel{
	private Collection<Tunnel> tunnels;
	private PriorityQueue<Vehicle> waiting = new PriorityQueue<Vehicle>((a, b) -> a.getPriority() - b.getPriority());
	private Map<Vehicle, Tunnel> innerVehicle = new HashMap<>();
	public Lock lock = new ReentrantLock();
	public Condition ambExist = lock.newCondition();
//	public Lock lock2 = new ReentrantLock();
	public Condition vehicleRunning = lock.newCondition();
	//protected boolean sameT;
	
	
	public PreemptivePriorityScheduler(String name) {
		super(name);
	}
	
	public PreemptivePriorityScheduler(String name,Collection<Tunnel> tunnels, Log log) {
		super(name);
		this.tunnels = tunnels;
	}

	@Override
	public boolean tryToEnterInner(Vehicle vehicle) {
		lock.lock();
		try{
			waiting.add(vehicle);//add vehicle into waiting list
			try{
				while(!vehicle.equals(waiting.peek()) || !fullOrNot(vehicle)){
					if(vehicle.getPriority() >= waiting.peek().getPriority() /*&& sameT == true|| vehicle instanceof Ambulance*/){
						// if the first vehicle is ambulance or has a higher priority, go on
						waiting.poll();
//						innerVehicle.put(vehicle, tunnel);
						vehicleRunning.signalAll();
					}else{// else, let the vehicle inside the tunnel wait
						vehicleRunning.await();
					}
				}
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			waiting.poll();
			vehicleRunning.signalAll();
			return true;
		}
		finally{
			lock.unlock();
		}
	}
	
	private boolean fullOrNot(Vehicle vehicle) {
		if(vehicle instanceof Ambulance){
			for (Tunnel tunnel : tunnels) {
				if (tunnel.tryToEnter(vehicle)) {
					innerVehicle.put(vehicle, tunnel);
					return false;
				}
			}
		}else{
			for (Tunnel tunnel : tunnels) {
				if (tunnel.tryToEnter(vehicle)) {
					innerVehicle.put(vehicle, tunnel);
					vehicle.addTunnel(tunnel);
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void exitTunnelInner(Vehicle vehicle) {
		lock.lock();
//		lock.lock();
		try{
			Tunnel tunnel = innerVehicle.get(vehicle);
			if(vehicle instanceof Ambulance){
				vehicleRunning.signalAll();
			}
			tunnel.exitTunnel(vehicle);
			ambExist.signalAll();
		}finally{
			lock.unlock();
//			lock.unlock();
		}
	}
	
}

