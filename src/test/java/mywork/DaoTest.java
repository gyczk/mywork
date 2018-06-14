package mywork;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czk.action.CustomerAction;
import com.czk.dao.CustomerMapper;
import com.czk.domain.Customer;

public class DaoTest {
//	ApplicationContext ctx;
//	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		
		
	}
	@Test
	public void CustomerDaoTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		CustomerMapper customerMapper = (CustomerMapper) ctx.getBean("customerMapper");
		List<Customer> list = customerMapper.selectByExample(null);
		for(Customer customer:list){
			System.out.println(customer);
		}
	}
	
	@Test
	public void CustomerActioinTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
		CustomerAction customerAction = (CustomerAction) ctx.getBean("customerAction");
		System.out.println(customerAction);
	}
	
	@Test
	public void testDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH,1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		
		System.out.println(sdf.format(c.getTime()));
		
	}
	

	@Test
	public void testDate1(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH,-1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		System.out.println(sdf.format(c.getTime()));
		
	}
}
