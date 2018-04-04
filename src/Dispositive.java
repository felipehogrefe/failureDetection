import java.util.Hashtable;
import java.util.Map;

import java.util.Random;

public class Dispositive extends Thread {
	private int myPort;
	private int timeout;
	private StatusView statusView;

	@Override
	public String toString() {
		return "" + myPort;
	}

	private Hashtable<Dispositive, Boolean> dispositives;

	public Dispositive(int _myPort, int _timeout, StatusView _statusView) {
		timeout = _timeout;
		statusView = _statusView;
		dispositives = new Hashtable<>();
		myPort = 500 + _myPort;
		statusView.setColor(_myPort, _myPort, 3);

	}
	
	public void addDispositive(Dispositive d) {
		dispositives.put(d,true);
	}
	
	public boolean multicast() {
		boolean isAlive = true;
		for(Map.Entry<Dispositive, Boolean> entry : dispositives.entrySet()){
			if(entry.getKey().getValue()!=getValue()){
				boolean thisIsAlive = entry.getValue();
				isAlive = isAlive || thisIsAlive;
				if(thisIsAlive) {
					send(entry.getKey());
				}
			}
		}
		return isAlive;
	}

	private void send(Dispositive destiny) {

		long tStart = System.currentTimeMillis();
		receive(destiny);	
		long tEnd = System.currentTimeMillis();
		
		if(tEnd-tStart > timeout) {
			statusView.setColor(destiny.getValue(), getValue(), 1);
			dispositives.put(destiny, false);
		}
		
		
	}
	
	private void receive(Dispositive destiny) {
		Random rand = new Random();
		int randomNum = rand.nextInt(timeout + timeout/10);

		long tStart = System.currentTimeMillis();
		
		statusView.setColor(destiny.getValue(), getValue(), 0);
		while(System.currentTimeMillis()-tStart<randomNum) {
			
		}
		statusView.setColor(destiny.getValue(), getValue(), 2);		
	}
	
	int getValue() {
		return myPort - 500;
	}
	
	
}
