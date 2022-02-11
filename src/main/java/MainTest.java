import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class MainTest {
	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		MagazineServiceImpl magazineServiceImpl = new MagazineServiceImpl();
		try {
			magazineServiceImpl.delete(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
