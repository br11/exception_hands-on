/**
 * 
 */
package br.atech.workshop.bestpractices.legacy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author marcio
 * 
 */
public class Legacy {

	public static class FakeInputStream extends InputStream {

		private String url;

		public FakeInputStream(URL conn) {
			this.url = conn.toString();
		}

		@Override
		public synchronized int read(byte[] b, int off, int len)
				throws IOException {
			throw new IOException("READ-ERROR 1404: " + url);
		}

		@Override
		public int read() throws IOException {
			return read(null, 0, 0);
		}
	}

	static int counter;

	public static InputStream getInputStream(URL conn) throws IOException {
		
		if (conn.toString().contains("system1")) {
			counter = 0;
			return new ByteArrayInputStream(
					"joao 1\nmaria 2\njose 3\nmaria 22\n".getBytes());
		} else if (conn.toString().contains("system2")) {
			counter = 0;
			return new ByteArrayInputStream(
					"joao 11\nmaria 22\njose 33\nmaria 2222\n".getBytes());
		} else if (conn.toString().contains("system3")) {
			counter++;

			if (counter == 1) {
				// IOException durante a leitura
				return new FakeInputStream(conn);
			} else if (counter == 2) {
				// Comunicação OK
				return new ByteArrayInputStream(
						"joao 111\nmaria 222\njose 333\nmaria 222222\n"
								.getBytes());
			} else if (counter == 3) {
				// durante a tentativa de estabelecer conexão.
				return null;
			} else {
				// IOException durante a tentativa de estabelecer conexão.
				counter = 0;
				throw new IOException();
			}
		} else {
			counter = 0;
			return conn.openConnection().getInputStream();
		}
	}
}
