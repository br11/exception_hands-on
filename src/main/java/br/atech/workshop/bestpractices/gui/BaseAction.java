package br.atech.workshop.bestpractices.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author marcio
 * 
 */
abstract class BaseAction implements ActionListener {

	private ExceptionHandler exHandler;
	private Gui gui;

	/**
	 * 
	 * @param gui
	 */
	BaseAction(Gui gui) {
		this.gui = gui;
		this.exHandler = new ExceptionHandler(gui);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		gui.reset();
		try {
			doAction(event);
		} catch (Exception e) {
			gui.error("erro de execuçção.");
		}
	}

	/**
	 * 
	 * @param event
	 * @throws Exception
	 */
	public abstract void doAction(ActionEvent event) throws Exception;
}