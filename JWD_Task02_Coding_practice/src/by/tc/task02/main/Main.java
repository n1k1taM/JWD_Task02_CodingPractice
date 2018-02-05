package by.tc.task02.main;

import java.util.List;

import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.service.ServiceFactory;
import by.tc.task02.service.ShopService;
import by.tc.task02.service.exception.DuplicateClientNameExeption;
import by.tc.task02.service.exception.ServiceException;

public class Main {

	public static void main(String[] args) {
		ServiceFactory factory = ServiceFactory.getInstance();
		ShopService shopService = factory.getShopService();
		String response = null;
		try {
			shopService.shopInit();
			response = "DataShop have been initilisated";
		} catch (ServiceException e) {
			// Logger
			response = "DataShop haven`t been initilisated";
		}
		PrintResponse.print(response);
		
		///////////////////////////
		
		try {
			shopService.addClient("bgoucouv");
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateClientNameExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//////////
		
		
		try {
			shopService.rentSportEquipment("bgoucouv", "Bear Archery Finger Tab");
			response =  "Sport equipment rents!!!";
		} catch (ServiceException e) {
			// Logger
			response =  "Incorrect information for rent";
		}
		PrintResponse.print(response);
		shopService.returnSportEquipment("bgoucouv", "Bear Archery Finger Tab");
			
		 
		
		

		List<SportEquipment> equipmentList = shopService.getSportEquipmentByCategory(Category.SOFTBALL_EQUIPMENT);
		System.out.println("--->" + equipmentList);
		// try {
		// shopService.addClient("Jonh");
		// shopService.addSportEquipmentToClient("Jonh", "Basket");
		// } catch (DuplicatClientNameExeption e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
