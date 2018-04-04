

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class MainView extends JFrame {

	private static final long serialVersionUID = -1828768834684873050L;
	private JPanel contentPane;
	public StatusView statusView;

	
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 1020);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		statusView = new StatusView();
		JPanel panel = new JPanel();
		panel.add(statusView);
		
		JScrollPane scrollPane = new JScrollPane(panel,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
	}

}
