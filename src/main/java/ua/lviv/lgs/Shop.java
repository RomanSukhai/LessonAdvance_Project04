package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class Shop implements ShopAble{
	private static  Shop shop ;
	private List<Magazine> listOfMagazine;
	private static List<User> listOfUser;
	
	public Shop() {
		this.shop = shop;
		this.listOfMagazine = listOfMagazine;
		this.listOfUser = listOfUser;
	}

	public User getUser(String email) {
		return getListOfUser().stream().filter(x->x.getEmailUser().equals(email)).findAny().orElse(null);	
	}
	
	@Override
	public Magazine getMagazine(String name) {
		return getListOfMagazine().stream().filter(x->x.getName().equals(name)).findAny().orElse(null);
	}

	@Override
	public void addUser(User user) {
		getListOfUser().add(user);
	}
	

	@Override
	public void addMagazine(Magazine magazine) {
		getListOfMagazine().add(magazine);
		
	}

	static Shop getShop() {
		if(shop==null) {
			shop = new Shop();
		}
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Magazine> getListOfMagazine() {
		if(listOfMagazine==null) {
			listOfMagazine = new ArrayList<Magazine>();
		}
		return listOfMagazine;
	}

	public void setListOfMagazine(List<Magazine> listOfMagazine) {
		this.listOfMagazine = listOfMagazine;
	}

	public static List<User> getListOfUser() {
		if(listOfUser==null) {
			listOfUser = new ArrayList<User>();
		}
		return listOfUser;
	}

	public void setListOfUser(List<User> listOfUser) {
		this.listOfUser = listOfUser;
	}
	
	
	
}
