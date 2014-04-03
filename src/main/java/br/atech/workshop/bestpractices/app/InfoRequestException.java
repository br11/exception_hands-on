package br.atech.workshop.bestpractices.app;

import br.atech.workshop.bestpractices.thirdpart1.DataProvider;

public class InfoRequestException extends AppException {

	private static final long serialVersionUID = 1L;

	private final String provider;
	
	public InfoRequestException(DataProvider<?> provider, Throwable cause) {
		super("", cause);
		this.provider = provider.getName();
	}

	public InfoRequestException(DataProvider<?> provider) {
		this(provider, null);
	}

	public String getProvider() {
		return provider;
	}
}
