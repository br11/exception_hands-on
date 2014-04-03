import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sample {

	class InputStreamIterator1 implements Iterator<String> {
		private String next;
		private BufferedReader reader;

		InputStreamIterator1(InputStream stream) throws IOException {
			reader = new BufferedReader(new InputStreamReader(stream));
			doNext();
		}

		private String doNext() throws IOException {
			String current = next;
			do {
				next = reader.readLine();
			} while (next != null && !next.equals("EOF"));
			return current;
		}

		public boolean hasNext() {
			return next != null && !next.equals("EOF");
		}

		public String next() {
			if (next == null) {
				throw new NoSuchElementException();
			}
			try {
				return doNext();
			} catch (IOException e) {
				System.err.println("ERROR <more info>");
				e.printStackTrace();
				return null;
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	
	
	
	
	
	
}
