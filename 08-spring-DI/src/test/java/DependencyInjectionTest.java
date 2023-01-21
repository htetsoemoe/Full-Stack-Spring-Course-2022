import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.bean.di.Employee;
import com.jdc.bean.di.EmployeeService;

public class DependencyInjectionTest {
	
	@Test
	public void di_test() {
		try(var context = new GenericXmlApplicationContext("classpath:/application.xml")) {
			var service = context.getBean(EmployeeService.class);
			
			var employee = new Employee();
			employee.setName("Thaw Thaw");
			employee.setEmail("thaw@gmail.com");
			
			service.create(employee);
		}
	}
}
