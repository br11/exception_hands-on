package br.atech.workshop.bestpractices.gui;

import br.atech.workshop.bestpractices.app.AppException;
import br.atech.workshop.bestpractices.app.InfoRequestException;
import br.atech.workshop.bestpractices.thirdpart1.DataException;

/**
 * 
 * @author marcio
 * 
 */
public class ExceptionHandler {

	public Gui gui;

	/**
	 * 
	 * @param gui
	 */
	public ExceptionHandler(Gui gui) {
		this.gui = gui;
	}

	/**
	 * 
	 * @param t
	 */
	public void handle(Throwable t) {
		 // Log
        t.printStackTrace();
        // user friendly message
        gui.error(translate(t));
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	private String translate(Throwable t) {
		return "Falha de operação.";
	}
}