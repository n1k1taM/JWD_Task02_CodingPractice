package by.tc.task02.entity;

import java.io.Serializable;
import java.util.Map;

public class Shop implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<SportEquipment, Integer> goods;
	private RentJournal rentJournal;

	public Shop() {
		super();
	}

	public Map<SportEquipment, Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<SportEquipment, Integer> goods) {
		this.goods = goods;
	}

	public RentJournal getRentJournal() {
		return rentJournal;
	}

	public void setRentJournal(RentJournal rentJournal) {
		this.rentJournal = rentJournal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((rentJournal == null) ? 0 : rentJournal.hashCode());
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
		Shop other = (Shop) obj;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (rentJournal == null) {
			if (other.rentJournal != null)
				return false;
		} else if (!rentJournal.equals(other.rentJournal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shop [goods=" + goods + ", rentJournal=" + rentJournal + "]";
	}

}
