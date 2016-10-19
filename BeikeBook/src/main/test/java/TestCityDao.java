import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.fortest.dao.ICityDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestCityDao {
	
	@Autowired
	private ICityDao cityDao;
	
	@Test
	public void cityDaoShouldNotBeNull() {
		assertNotNull(cityDao);
	}
}
