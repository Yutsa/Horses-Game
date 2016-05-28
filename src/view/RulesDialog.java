package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RulesDialog extends JDialog implements ActionListener {
	public RulesDialog() {
		super();
		
		final String html1 = "<html><body style='width: ";
        final String html2 = "px'>";

		this.setTitle("Règle du jeu des petits chevaux");
		JPanel panel = new JPanel(new GridLayout(2, 1));
		this.setContentPane(panel);

		JLabel rules = new JLabel(html1 + "300" + html2 + "Lancer le dé, si vous faites 6 vous pouvez sortir un cheval de"
				+ " l'écurie. Pour déplacer un cheval il faut cliquer dessus après avoir lancer le" +
				"dé. Le but est d'amener tous ses chevaux jusqu'à l'enclos au centre du plateau." +
				"Dans les cases escalier il faut faire le chiffre exact pour se déplacer.");
		this.add(rules);

		JButton validate = new JButton("OK");
		this.add(validate);
		validate.addActionListener(this);

		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
