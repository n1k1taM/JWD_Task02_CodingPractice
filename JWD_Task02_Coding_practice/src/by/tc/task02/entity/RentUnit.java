package by.tc.task02.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RentUnit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<SportEquipment> units;
	
	
	public RentUnit() {
		super();
		units = new ArrayList<>();
	}
	
	
	public RentUnit(List<SportEquipment> units) {
		super();
		this.units = units;
	}


	public List<SportEquipment> getUnits() {
		return units;
	}
	public void setUnits(List<SportEquipment> units) {
		this.units = units;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		RentUnit other = (RentUnit) obj;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RentUnit [units=" + units + "]";
	}
	
	
	
	
	
}
