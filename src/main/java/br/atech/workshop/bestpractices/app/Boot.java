/**
 * 
 */
package br.atech.workshop.bestpractices.app;

import br.atech.workshop.bestpractices.gui.Gui;
import br.atech.workshop.bestpractices.thirdpart1.DataException;
import br.atech.workshop.bestpractices.thirdpart1.DataProvider;
import br.atech.workshop.bestpractices.thirdpart1.DataProviderFactory;

/**
 * @author marcio
 * 
 */
public class Boot {

	/**
	 * 
	 * @param args
	 * @throws AppException
	 */
	public static void main(String[] args) throws AppException {
		try {

			DataProviderFactory factory = new DataProviderFactory();

			DataProvider<Integer> sys1 = factory.getProvider(
					args.length > 0 ? args[0]
							: "file:///system1/service",
					Integer.class);
			DataProvider<Integer> sys2 = factory.getProvider(
					args.length > 0 ? args[0]
							: "ftp://remote-server2:2222/system2/service",
					Integer.class);
			DataProvider<Integer> sys3 = factory.getProvider(
					args.length > 0 ? args[0]
							: "https://remote-server3:3333/system3/service",
					Integer.class);

			new Gui(new App(sys1, sys2, sys3)).show();

		} catch (DataException e) {
			e.printStackTrace();

			System.exit(1);
		}
	}
}
