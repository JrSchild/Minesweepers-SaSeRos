public class Error {
	private boolean hasErrors = false;
	private String name;
	private String port;
	
	public Error() {}
	
	public Error(String name, String port) {
		this.hasErrors = false;
		this.name = name;
		this.port = port;
	}

	public boolean isHasErrors() {
		return hasErrors;
	}

	public Error setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
		return this;
	}

	public String getName() {
		return name;
	}

	public Error setName(String name) {
		this.name = name;
		return this;
	}

	public String getPort() {
		return port;
	}

	public Error setPort(String port) {
		this.port = port;
		return this;
	}
}