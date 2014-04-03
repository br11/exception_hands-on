package br.atech.workshop.bestpractices.thirdpart1;

import java.util.Iterator;

/**
 * 
 * @author marcio
 * 
 * @param <T>
 */
public interface DataProvider<T> {
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	DataProvider<T> connect() throws DataException ;
	
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws DataException
	 */
	Iterator<T> getData(String query) throws DataException;
	
	/**
	 * 
	 * @return
	 */
	String getName();
	
	
	/**
	 * 
	 * @return
	 */
	DataProvider<T> releaseConnection();
}
