package by.tc.task02.entity;

import java.io.Serializable;
import java.util.List;

public class RentJournal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Client> clients;
	
	
	
	public RentJournal() {
		super();
	}
	
	public RentJournal(List<Client> clients) {
		super();
		this.clients = clients;
	}
	
	
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
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
		RentJournal other = (RentJournal) obj;
		if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RentJournal [clients=" + clients + "]";
	}
	
	
	
	
	
	
}
