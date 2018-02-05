package by.tc.task02.service;

import java.util.List;

import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.service.exception.DuplicateClientNameExeption;
import by.tc.task02.service.exception.ServiceException;

public interface ShopService {
	void shopInit() throws ServiceException;
	
	void rentSportEquipment(String client, String sportEquipmentName) throws ServiceException;
	
	void returnSportEquipment(String client, String sportEquipmentName);
	
	List<SportEquipment> getSportEquipmentByCategory(Category categoryName);
	
	SportEquipment getSportEquipmentByName(String sportEquipmentName);
	
	List<SportEquipment> getSportEquipmentByClient(String clientName);
	
	void addClient(String clientName)throws ServiceException, DuplicateClientNameExeption;
	
	
	
	
	
	
}
