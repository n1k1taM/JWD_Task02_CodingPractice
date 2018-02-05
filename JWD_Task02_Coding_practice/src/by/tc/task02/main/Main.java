package by.tc.task02.main;




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
			shopService.addClient("John");
			response =  "Incorrect name";
		} catch (ServiceException e) {
			response =  "Incorrect client name";
		} catch (DuplicateClientNameExeption e) {
			response =  "Clients name already exist";
		}
		
		//////////
		
		
		try {
			shopService.rentSportEquipment("John", "Bear Archery Finger Tab");
			response =  "Sport equipment rents!!!";
		} catch (ServiceException e) {
			// Logger
			response =  "Incorrect information for rent";
		}
		PrintResponse.print(response);
		shopService.returnSportEquipment("John", "Bear Archery Finger Tab");
			
		 
		
		

		

	}

}
