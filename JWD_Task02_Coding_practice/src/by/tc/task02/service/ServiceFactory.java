package by.tc.task02.service;

import by.tc.task02.service.impl.ShopServiceImpl;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	private final ShopService shopService = new ShopServiceImpl();
	
	private ServiceFactory() {
		super();
	}
	
	
	public ShopService getShopService() {

		return shopService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}
	
}
