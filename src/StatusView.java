import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class StatusView extends JPanel {

	private static final long serialVersionUID = 8641265316420356198L;

	Hashtable<String, ArrayList<JLabel>> pics = new Hashtable<>();
	
	ArrayList<ImageIcon> colors = new ArrayList<>();

	ImageIcon green, red, blue, black;

	public StatusView() {

		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dispositives", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		try {
			green = new ImageIcon(getClass().getResource("/img/green.png"));
			red = new ImageIcon(getClass().getResource("/img/red.png"));
			blue = new ImageIcon(getClass().getResource("/img/blue.png"));
			black = new ImageIcon(getClass().getResource("/img/black.png"));
			colors.add(green);
			colors.add(red);
			colors.add(blue);
			colors.add(black);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int j = 1; j < 11; j++) {
			ArrayList<JLabel> dispositivePics = new ArrayList<>();
			pics.put("" + j, dispositivePics);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "" + j, TitledBorder.LEADING, TitledBorder.TOP, null, null));
			add(panel_1);
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			for (int i = 1; i < 11; i++) {
				JPanel panel = new JPanel();
				panel.setPreferredSize(new Dimension(60, 60));
				panel.setBorder(new TitledBorder(null, "" + i, TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
				JLabel picLabel = new JLabel(blue);
				panel.add(picLabel, BorderLayout.CENTER);

				dispositivePics.add(picLabel);

			}
		}
	}
	
	public void setColor(int dispositive, int innerDispositive, int color) {
		
		JLabel label = pics.get(""+(dispositive)).get(innerDispositive-1);
		label.setIcon(colors.get(color));
	}

}
