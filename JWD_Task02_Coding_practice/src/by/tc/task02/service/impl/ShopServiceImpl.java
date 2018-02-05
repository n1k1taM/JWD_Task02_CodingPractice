package by.tc.task02.service.impl;


import java.util.List;

import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.ShopDAO;
import by.tc.task02.dao.exeption.DAOExciption;
import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.service.ShopService;
import by.tc.task02.service.exception.DuplicateClientNameExeption;
import by.tc.task02.service.exception.ServiceException;
import by.tc.task02.service.util.Validator;

public class ShopServiceImpl implements ShopService {

	@Override
	public void rentSportEquipment(String client, String sportEquipmentName) throws ServiceException {
		// TODO Check client and sportEquipment
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();

		boolean validationResault = shopDAO.isClientExist(client)
				&& shopDAO.isSportEquipmentInTheShop(sportEquipmentName)
				&& !(shopDAO.isClientHasSportEqupment(client, sportEquipmentName))
				&& !(shopDAO.isClientHasMaxNumberOfSportEquipment(client, sportEquipmentName));
		if (!validationResault) {
			throw new ServiceException("Incorrect information for rent");
		}
		shopDAO.addSportEquipmentToClient(client, sportEquipmentName);
	}

	@Override
	public void returnSportEquipment(String client, String sportEquipmentName) {
		// TODO Check client and sportEquipment
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();

		if (Validator.validDataForReturnSportEquipment(client, sportEquipmentName)) {
			shopDAO.returnSportEquipmentFromClient(client, sportEquipmentName);
		}
	}

	@Override
	public List<SportEquipment> getSportEquipmentByCategory(Category categoryName) {
		if (Validator.validateCategory(categoryName)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();
		List<SportEquipment> sportEquipment = shopDAO.getSportEquipmentByCategory(categoryName);
		return sportEquipment;
	}

	@Override
	public SportEquipment getSportEquipmentByName(String sportEquipmentName) {
		if (Validator.validString(sportEquipmentName)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();
		if(!shopDAO.isSportEquipmentInTheShop(sportEquipmentName)){
			return null;
		}
		return shopDAO.getSportEquipmentByName(sportEquipmentName);
	}

	@Override
	public List<SportEquipment> getSportEquipmentByClient(String clientName) {
		
		if (Validator.validString(clientName)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();
		if (!shopDAO.isClientExist(clientName)) {
			return null;
		}
		return shopDAO.getSportEquipmentByClient(clientName);
		
	}

	@Override
	public void addClient(String clientName) throws ServiceException, DuplicateClientNameExeption {
		if (!Validator.validString(clientName)) {
			throw new ServiceException("Incorrect client name");
		}
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();

		if (!shopDAO.isClientNameUniq(clientName)) {
			throw new DuplicateClientNameExeption();
		}
		shopDAO.addClient(clientName);
	}

	@Override
	public void shopInit() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();
		try {
			shopDAO.init();
		} catch (DAOExciption e) {
			throw new ServiceException("Data is not available", e);
		}

	}

}
