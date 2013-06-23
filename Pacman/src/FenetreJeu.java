import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreJeu extends JFrame {
	public FenetreJeu(){
		super();
		build();
	}

	private void build() {
		setTitle("Pacman");
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(true);
		Dimension min = new Dimension(200, 200);
		Dimension max = new Dimension(500, 700);
		setMinimumSize(min);
		setMaximumSize(max);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPanel());
	}
	
	private JPanel buildContentPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.BLACK);
				
		return panel;
	}
}
