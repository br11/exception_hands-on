/**
 * 
 */
package br.atech.workshop.bestpractices.data;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import br.atech.workshop.bestpractices.legacy.Legacy;
import br.atech.workshop.bestpractices.thirdpart1.DataException;
import br.atech.workshop.bestpractices.thirdpart1.DataProvider;

/**
 * @author marcio
 * 
 */
public class LegacyDataProvider implements DataProvider<Integer> {

	private URL url;
	private InputStream conn;

	/**
	 * 
	 * @param endpoint
	 */
	public LegacyDataProvider(String endpoint) {
		try {
			this.url = new URL(endpoint);
		} catch (MalformedURLException e) {
			System.err.println("WARNING: Endpoint config error." + endpoint);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param endpoint
	 */
	public LegacyDataProvider(URL endpoint) {
		this.url = endpoint;
	}

	/*
	 * (non-Javadoc)
	 * @see br.atech.workshop.bestpractices.thirdpart1.DataProvider#getData(java.lang.String)
	 */
	@Override 
	public Iterator<Integer> getData(String query) throws DataException {
		return new LegacyDataIterator(conn, query);
	}

	private InputStream connect(URL url) throws IOException {
		return Legacy.getInputStream(url);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.thirdpart1.DataProvider#getName()
	 */
	@Override
	public String getName() {
		String[] parts = url.toString().split("/");
		return parts[parts.length - 2] + "/" + parts[parts.length - 1];
	}

	@Override
	public LegacyDataProvider connect() throws DataException {
		if (conn != null) {
			throw new IllegalStateException("Unreleased connection.");
		}
		try {
			conn = connect(url);
			return this;
		} catch (IOException e) {
			throw new DataException(e);
		}
	}

	@Override
	public LegacyDataProvider releaseConnection() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
			return this;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
