package by.tc.task02.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import by.tc.task02.dao.ShopDAO;
import by.tc.task02.dao.exeption.DAOExciption;
import by.tc.task02.entity.Category;
import by.tc.task02.entity.Client;
import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.source.DataBase;

public class ShopDAOImpl implements ShopDAO {
	private final String FILE_PATH = "resources\\shop_db.txt";
	private final int MAX_NUMBER_RENT_SPORT_EQUIPMENT = 3;

	@Override
	public void init() throws DAOExciption {
		Shop shop = null;

		try (FileInputStream fin = new FileInputStream(FILE_PATH);
				ObjectInputStream ois = new ObjectInputStream(fin);) {

			shop = (Shop) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new DAOExciption("Initialisation error", e);
		}
		DataBase base = DataBase.getInstance();
		base.setShop(shop);
	}

	@Override
	public List<SportEquipment> getSportEquipmentByCategory(Category categoryName) {
		DataBase dataBase = DataBase.getInstance();
		Shop shop = dataBase.getShop();
		Map<SportEquipment, Integer> goods = shop.getGoods();
		List<SportEquipment> goodsInCategory = new ArrayList<SportEquipment>();

		for (Entry<SportEquipment, Integer> good : goods.entrySet()) {
			SportEquipment sportEquipment = good.getKey();
			Integer numberOfSportEquipment = good.getValue();

			if ((sportEquipment.getCategory() == categoryName) && (numberOfSportEquipment != 0)) {
				goodsInCategory.add(sportEquipment);
			}
		}
		return goodsInCategory;
	}

	@Override
	public SportEquipment getSportEquipmentByName(String sportEquipmentName) {
		DataBase dataBase = DataBase.getInstance();
		Shop shop = dataBase.getShop();

		Map<SportEquipment, Integer> goods = shop.getGoods();
		for (Entry<SportEquipment, Integer> good : goods.entrySet()) {
			SportEquipment sportEquipment = good.getKey();
			Integer numberOfSportEquipment = good.getValue();

			if (sportEquipment.getTitle().equals(sportEquipmentName) && (numberOfSportEquipment != 0)) {
				return sportEquipment;
			}
		}
		return null;
	}

	@Override
	public boolean isClientNameUniq(String clientName) {
		DataBase dataBase = DataBase.getInstance();
		Shop shop = dataBase.getShop();

		boolean matchingResault = true;
		List<Client> cliens = shop.getRentJournal().getClients();
		for (Client client : cliens) {
			if (client.getName().equals(clientName)) {
				matchingResault = false;
				break;
			}
		}
		return matchingResault;
	}

	@Override
	public void addClient(String clientName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();
		List<Client> clients = shop.getRentJournal().getClients();
		clients.add(new Client(clientName, new RentUnit()));
		System.out.println(shop);
	}

	@Override
	public boolean isSportEquipmentInTheShop(String sportEquipmentName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();

		boolean resault = false;
		Map<SportEquipment, Integer> goods = shop.getGoods();
		for (Map.Entry<SportEquipment, Integer> good : goods.entrySet()) {
			if (good.getKey().getTitle().equals(sportEquipmentName) && good.getValue() > 0) {
				resault = true;
				break;
			}
		}
		return resault;
	}

	@Override
	public boolean isClientExist(String clientName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();

		boolean resault = false;
		List<Client> cliens = shop.getRentJournal().getClients();
		for (Client client : cliens) {
			if (client.getName().equals(clientName)) {
				resault = true;
				break;
			}
		}
		return resault;
	}

	@Override
	public void addSportEquipmentToClient(String clientName, String sportEquipmentName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();

		SportEquipment sportEquipment = null;
		Map<SportEquipment, Integer> goods = shop.getGoods();
		for (Map.Entry<SportEquipment, Integer> good : goods.entrySet()) {
			if (good.getKey().getTitle().equals(sportEquipmentName)) {
				good.setValue(good.getValue() - 1);
				sportEquipment = good.getKey();
				break;
			}
		}

		List<Client> clients = shop.getRentJournal().getClients();
		for (Client client : clients) {
			if (client.getName().equals(clientName)) {
				List<SportEquipment> unit = client.getRentUnit().getUnits();
				unit.add(sportEquipment);
			}
		}
		System.out.println("*********" + shop);

	}

	@Override
	public boolean isClientHasMaxNumberOfSportEquipment(String clientName, String sportEquipmentName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();

		boolean resault = false;
		List<Client> clients = shop.getRentJournal().getClients();
		int sportEquipmentCounter = 0;
		for (Client client : clients) {
			if (client.getName().equals(clientName)) {
				List<SportEquipment> goods = client.getRentUnit().getUnits();
				sportEquipmentCounter = goods.size();
				break;
			}
		}
		if (sportEquipmentCounter >= MAX_NUMBER_RENT_SPORT_EQUIPMENT) {
			resault = true;
		}
		return resault;
	}

	@Override
	public boolean isClientHasSportEqupment(String clientName, String sportEquipmentName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();

		boolean resault = false;
		List<Client> clients = shop.getRentJournal().getClients();
		for (Client client : clients) {
			if (client.getName().equals(clientName)) {
				List<SportEquipment> goods = client.getRentUnit().getUnits();
				for (SportEquipment sportEquipment : goods) {
					if (sportEquipment.getTitle().equals(sportEquipmentName)) {
						resault = true;
						break;
					}
				}
				break;
			}
		}
		return resault;
	}

	@Override
	public void returnSportEquipmentFromClient(String clientName, String sportEquipmentName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();

		SportEquipment sportEquipment = null;
		Map<SportEquipment, Integer> goods = shop.getGoods();
		for (Map.Entry<SportEquipment, Integer> good : goods.entrySet()) {
			if (good.getKey().getTitle().equals(sportEquipmentName)) {
				good.setValue(good.getValue() + 1);
				sportEquipment = good.getKey();
				break;
			}
		}

		List<Client> clients = shop.getRentJournal().getClients();

		for (Client client : clients) {
			if (client.getName().equals(clientName)) {
				List<SportEquipment> unit = client.getRentUnit().getUnits();
				ListIterator<SportEquipment> iter = unit.listIterator();
				while (iter.hasNext()) {
					if (iter.next().equals(sportEquipment)) {
						iter.remove();
						break;
					}
				}
				break;
			}
		}
		System.out.println("*-*->" + shop);
	}

	@Override
	public List<SportEquipment> getSportEquipmentByClient(String clientName) {
		DataBase base = DataBase.getInstance();
		Shop shop = base.getShop();
		
		List<SportEquipment> sportEquipment = new ArrayList<SportEquipment>();
		List<Client> clients = shop.getRentJournal().getClients();
		for (Client client : clients) {
			if(client.getName().equals(clientName)){
				sportEquipment = client.getRentUnit().getUnits();
			}
		}
		return sportEquipment;
	}

}
