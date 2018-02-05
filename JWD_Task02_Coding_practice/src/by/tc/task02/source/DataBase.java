package by.tc.task02.source;

import by.tc.task02.entity.Shop;

public final class DataBase {

	private static DataBase instance;
	private Shop shop;

	private DataBase() {
		super();
	}

	public static DataBase getInstance() {
		if (instance == null) {
			instance = new DataBase();
		}
		return instance;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
