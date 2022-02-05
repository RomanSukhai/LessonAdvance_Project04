package ua.lviv.lgs;

public interface ShopAble {
	User getUser(String email);
	Magazine getMagazine(String name);
	void addUser(User user);
	void addMagazine(Magazine magazine);

}
