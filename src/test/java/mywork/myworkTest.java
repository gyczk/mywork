package mywork;

import org.junit.Test;
import org.springframework.util.SocketUtils;

import com.czk.domain.Customer;

public class myworkTest {
	@Test
	public void excetion() {
		Customer customer = null;
		try{
			customer.getCustAddress();
		}catch(Exception e){
//			throw new RuntimeException(e);】
			e.printStackTrace();
			System.out.println("in try catch");
		}
		
		System.out.println(111);
	}
}
