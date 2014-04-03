/**
 * 
 */
package br.atech.workshop.bestpractices.thirdpart2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

import br.atech.workshop.bestpractices.thirdpart1.DataException;

/**
 * 
 * @author marcio
 * 
 */
public class DataPointer {

	private InputStream input;
	private String query;

	private BufferedReader reader;

	private String next;

	/**
	 * 
	 * @param url
	 * @throws DataException
	 */
	public DataPointer(InputStream input, String query) {
		this.input = input;
		this.query = query;
	}

	/**
	 * 
	 * @throws IOException
	 */
	private void prepare() throws IOException {
		if (reader == null) {
			reader = new BufferedReader(new InputStreamReader(input));
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			doSkip();
		}
	}

	public boolean eof() throws IOException {
		prepare();
		return next == null;
	}

	public Integer getValue() throws IOException {
		prepare();
		
		if (next == null) {
			throw new NoSuchElementException();
		}

		String current = next;

		skip();

		Integer nextInt = null;

		if (!current.isEmpty()) {
			nextInt = Integer.parseInt(current);
		}

		return nextInt;
	}

	/**
	 * 
	 * @return
	 */
	public void skip() throws IOException {
		if (next == null) {
			throw new NoSuchElementException();
		}
		
		doSkip();
	}

	/**
	 * 
	 * @throws IOException
	 */
	private void doSkip() throws IOException {
		do {
			next = reader.readLine();
			if (next != null){
				System.out.println((next.startsWith(query) ? ">" : " ") + next);
			}
		} while (next != null && !next.startsWith(query));

		if (next != null) {
			next = next.substring(query.length()).trim();
		}
	}

}
