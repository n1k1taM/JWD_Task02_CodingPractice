package by.tc.task02.main;

import java.util.List;
import java.util.Map;

import by.tc.task02.entity.Client;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;

public final class PrintResponse {

	private PrintResponse() {
		super();
	}

	public static void print(String line) {
		System.out.println(line);
	}

	public static void pintInformationAboutShop(Shop shop) {
		String shopInformation = "Information about Shop:\n";
		Map<SportEquipment, Integer> goods = shop.getGoods();
		for (Map.Entry<SportEquipment, Integer> good : goods.entrySet()) {
			SportEquipment sportEquipment = good.getKey();
			Integer numberOfSportEquipment = good.getValue();
			shopInformation += "title: " + sportEquipment.getTitle() + ", category: " + sportEquipment.getCategory()
					+ ", price: " + sportEquipment.getPrice() + "$, available quantity: " + numberOfSportEquipment
					+ "\n";

		}

		shopInformation += "Information about our client \n";
		List<Client> clients = shop.getRentJournal().getClients();
		for (Client client : clients) {
			shopInformation += "Name: " + client.getName() + ", ";
			List<SportEquipment> sportEquipments = client.getRentUnit().getUnits();
			for (SportEquipment sportEquipment : sportEquipments) {
				shopInformation += "title: " + sportEquipment.getTitle() + ", category: " + sportEquipment.getCategory()
						+ ", price: " + sportEquipment.getPrice() + "$ \n";
			}

		}
		System.out.println(shopInformation);
	}

}
