package domain;

import java.io.Serializable;

public class Customer implements Serializable {
	private final String code;
	private String name;

	public Customer(String name, String code) {
		this.code = code;
		this.name = name;

	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Customer[%s %s]", code, name);

	}
}
