package by.tc.task02.dao;

import java.util.List;

import by.tc.task02.dao.exeption.DAOExciption;
import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;

public interface ShopDAO {

	void init() throws DAOExciption;

	List<SportEquipment> getSportEquipmentByCategory(Category categoryName);

	SportEquipment getSportEquipmentByName(String sportEquipmentName);

	boolean isClientNameUniq(String clientName);

	void addClient(String clientName);

	boolean isSportEquipmentInTheShop(String sportEquipmentName);

	boolean isClientExist(String clientName);

	void addSportEquipmentToClient(String clientName, String sportEquipmentName);

	boolean isClientHasSportEqupment(String clientName, String sportEquipmentName);

	boolean isClientHasMaxNumberOfSportEquipment(String clientName, String sportEquipmentName);

	void returnSportEquipmentFromClient(String clientName, String sportEquipmentName);
	
	List<SportEquipment> getSportEquipmentByClient(String clientName);

}
