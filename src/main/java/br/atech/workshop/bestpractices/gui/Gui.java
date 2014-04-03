package br.atech.workshop.bestpractices.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atech.workshop.bestpractices.app.App;

/**
 * 
 * @author marcio
 * 
 */
public class Gui {

	private final JFrame guiFrame;

	final JPanel messagePanel;
	final JLabel messagelbl;

	private final JPanel contentPanel;
	private final JLabel namelbl;
	private final JTextField namefield;
	private final JLabel resultlbl;
	final JTextField resultfield;

	private final JPanel actionPanel;
	private final JButton btn1;
	private final JButton btn2;
	private final JButton btn3;

	private final App app;

	public Gui(App app) {
		this.app = app;

		guiFrame = new JFrame();

		// make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Example GUI");
		guiFrame.setSize(500, 150);

		// This will center the JFrame in the middle of the screen
		guiFrame.setLocationRelativeTo(null);

		messagePanel = new JPanel();
		messagelbl = new JLabel();
		messagePanel.add(messagelbl);
		messagePanel.setVisible(false);

		contentPanel = new JPanel();
		final GridLayout layout = new GridLayout(3, 2);
		contentPanel.setLayout(layout);
		namelbl = new JLabel("Name:");
		namefield = new JTextField();
		contentPanel.add(namelbl);
		contentPanel.add(namefield);
		resultlbl = new JLabel("Result:");
		resultfield = new JTextField();
		contentPanel.add(resultlbl);
		contentPanel.add(resultfield);
		resultfield.setEditable(false);

		actionPanel = new JPanel();
		btn1 = new JButton("Check 1");
		btn2 = new JButton("Check 2");
		btn3 = new JButton("Check 3");
		actionPanel.add(btn1);
		actionPanel.add(btn2);
		actionPanel.add(btn3);

		guiFrame.add(messagePanel, BorderLayout.NORTH);
		guiFrame.add(contentPanel, BorderLayout.CENTER);
		guiFrame.add(actionPanel, BorderLayout.SOUTH);

		addListeners();
	}

	public void show() {
		guiFrame.setVisible(true);
	}

	public void hide() {
		guiFrame.setVisible(false);
	}

	public void error(String err) {
		messagePanel.setVisible(true);
		messagelbl.setText(err);
	}

	public void reset() {
		messagePanel.setVisible(false);
		messagelbl.setText("");
	}

	private void addListeners() {

		btn1.addActionListener(new BaseAction(this) {
			@Override
			public void doAction(ActionEvent event) throws Exception {
				resultfield.setText(app.feature1(namefield.getText()));
			}
		});

		btn2.addActionListener(new BaseAction(this) {
			@Override
			public void doAction(ActionEvent event) throws Exception {
				resultfield.setText(app.feature2(namefield.getText()));
			}
		});

		btn3.addActionListener(new BaseAction(this) {
			@Override
			public void doAction(ActionEvent event) throws Exception {
				resultfield.setText(app.feature3(namefield.getText()));
			}
		});
	}
}