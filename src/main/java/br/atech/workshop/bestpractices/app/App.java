/**
 * 
 */
package br.atech.workshop.bestpractices.app;

import java.util.Iterator;

import br.atech.workshop.bestpractices.thirdpart1.DataException;
import br.atech.workshop.bestpractices.thirdpart1.DataProvider;

/**
 * @author marcio
 * 
 */
public class App {

	private DataProvider<Integer> sys1;
	private DataProvider<Integer> sys2;
	private DataProvider<Integer> sys3;

	public App(DataProvider<Integer> sys1, DataProvider<Integer> sys2,
			DataProvider<Integer> sys3) {

		this.sys1 = sys1;
		this.sys2 = sys2;
		this.sys3 = sys3;

	}

	private String requestInformation(DataProvider<Integer> provider,
			String query) throws AppException {
		try {
			provider.connect();

			StringBuilder sb = new StringBuilder();
			Iterator<Integer> data = provider.getData(query);
			while (data.hasNext()) {
				Integer part = data.next();
				if (part != null) {
					sb.append(part);
				}
				sb.append("; ");
			}

			return sb.toString();
		} catch (DataException e) {
			throw new AppException(e);
		} finally {
			provider.releaseConnection();
		}
	}

	public String feature1(String name) throws AppException {
		return requestInformation(sys1, name);
	}

	public String feature2(String name) throws AppException {
		return requestInformation(sys2, name);
	}

	public String feature3(String name) throws AppException {
		return requestInformation(sys3, name);
	}

}
