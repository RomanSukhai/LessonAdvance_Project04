package ua.lviv.lgs;

public class Magazine {

	private String name;
	private int pages;
	private String information;
	public Magazine(String name, int pages,String information) {
		super();
		this.name = name;
		this.pages = pages;
		this.information = information;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Magazine [name=" + name + ", pages=" + pages + "]";
	}
	
	
	
}
