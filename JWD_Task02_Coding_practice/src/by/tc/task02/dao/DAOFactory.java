package by.tc.task02.dao;

import by.tc.task02.dao.impl.ShopDAOImpl;


public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final ShopDAO shopDAO = new ShopDAOImpl();
	
	private DAOFactory() {
		super();
	}
	
	
	public ShopDAO getShopDAO() {
		
		return shopDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
