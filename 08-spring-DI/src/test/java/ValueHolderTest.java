import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.bean.di.ArrayHolder;
import com.jdc.bean.di.ListHolder;
import com.jdc.bean.di.MapHolder;
import com.jdc.bean.di.SetHolder;
import com.jdc.bean.di.ValueHolder;

public class ValueHolderTest {
	@Test
	void test() {
		try(var context = new GenericXmlApplicationContext()) {
			context.load("classpath:/value-holder.xml");
			context.refresh();
			
			var bean = context.getBean(ValueHolder.class);
			Assertions.assertNotNull(bean);
			
			
			var arrayHolder = context.getBean(ArrayHolder.class);
			var subjects = Arrays.toString(arrayHolder.getSubjects());
			System.out.println(subjects);
			
			var setHolder = context.getBean(SetHolder.class);
			System.out.println(setHolder.getNumbers());
			
			var listHoler = context.getBean(ListHolder.class);
			System.out.println(listHoler.getCloseDays());
			
			var mapHolder = context.getBean(MapHolder.class);
			System.out.println(mapHolder.getDates());
		}
	}
}
