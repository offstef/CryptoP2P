package main;

public class Bank {
	public String name;
	protected String location;

	public Bank() {
		this.name = "";
		this.location = "";
	}

	public Bank(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
