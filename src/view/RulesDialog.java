/*  horses_game
    Copyright (C) 2016  Édouard WILLISSECK

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RulesDialog extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5569287796933631677L;

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
