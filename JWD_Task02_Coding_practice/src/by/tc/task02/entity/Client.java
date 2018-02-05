package by.tc.task02.entity;

public class Client {
	private String name;
	private RentUnit rentUnit;
	
	
	public Client() {
		super();
	}
	
	
	public Client(String name, RentUnit rentUnit) {
		super();
		this.name = name;
		this.rentUnit = rentUnit;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RentUnit getRentUnit() {
		return rentUnit;
	}
	public void setRentUnit(RentUnit rentUnit) {
		this.rentUnit = rentUnit;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rentUnit == null) ? 0 : rentUnit.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rentUnit == null) {
			if (other.rentUnit != null)
				return false;
		} else if (!rentUnit.equals(other.rentUnit))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Client [name=" + name + ", rentUnit=" + rentUnit + "]";
	}
	
	
	
	
}
