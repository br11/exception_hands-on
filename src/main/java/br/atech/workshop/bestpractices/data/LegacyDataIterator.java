/**
 * 
 */
package br.atech.workshop.bestpractices.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import br.atech.workshop.bestpractices.thirdpart1.DataException;
import br.atech.workshop.bestpractices.thirdpart2.DataPointer;

/**
 * 
 * @author marcio
 * 
 */
public class LegacyDataIterator implements Iterator<Integer> {

	private DataPointer pointer;

	/**
	 * 
	 * @param url
	 * @throws DataException
	 */
	public LegacyDataIterator(InputStream input, String query) {
		pointer = new DataPointer(input, query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		try {
			return !pointer.eof();
		} catch (IOException e) {
			System.err.println("Error de conexão/leitura.");
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Integer next() {
		try {
			return pointer.getValue();
		} catch (IOException e) {
			 System.err.println("Error de conexão/leitura.");
			 e.printStackTrace();
			 return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
