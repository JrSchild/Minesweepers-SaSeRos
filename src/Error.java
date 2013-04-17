public class Error {
	private String name;
	private String port;
	private boolean hasErrors;
	
	public Error() {}
	
	public Error(String name, String port) {
		this.name = name;
		this.port = port;
		this.hasErrors = false;
	}
	
	public Error(String name, String port, boolean hasErrors) {
		this.name = name;
		this.port = port;
		this.hasErrors = hasErrors;
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