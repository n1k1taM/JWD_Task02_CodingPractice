package by.tc.task02.service.util;

import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.ShopDAO;
import by.tc.task02.entity.Category;

public final class Validator {
	public static boolean validString(String line) {
		if ((line.isEmpty()) || (line == null)) {
			return false;
		}
		return true;
	}
	
	public static boolean validateCategory(Category category){
		if (category == null) {
			return false;
		}
		return true;
	}

	
	public static boolean validDataForReturnSportEquipment(String client, String sportEquipmentName) {
		DAOFactory factory = DAOFactory.getInstance();
		ShopDAO shopDAO = factory.getShopDAO();

		boolean validationResault;
		validationResault = shopDAO.isClientExist(client) && shopDAO.isClientHasSportEqupment(client, sportEquipmentName);
		System.out.println(validationResault);
		return validationResault;
	}
}
