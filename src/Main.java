import java.awt.EventQueue;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Dispositive> dispositives;
    
    
    public static void main(String[] args) {
    	dispositives = new ArrayList<>();
    	MainView frame = new MainView();
    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		for(int i = 1;i<11;i++) {
    		Dispositive d = new Dispositive(i,50,frame.statusView);
    		d.start();
    		dispositives.add(d);
    	}

    	for(Dispositive d : dispositives) {
    		frame.statusView.setColor(d.getValue(), d.getValue(), 3);
    		for(Dispositive anotherD : dispositives) {
        		if(d!=anotherD) d.addDispositive(anotherD);
        	}
    	}

    	boolean isAlive = true;
    	while(isAlive) {
    		for(Dispositive d : dispositives) {
    			isAlive |= d.multicast();
        	}
    	}
    	
    	
		
	}

    public static ArrayList<Dispositive> getDispositives(){
        return dispositives;
    }
}
