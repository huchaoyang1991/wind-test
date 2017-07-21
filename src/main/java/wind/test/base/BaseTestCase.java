package wind.test.base;

import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by huchaoyang on 2017/7/15.
 */
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseTestCase extends AbstractTestNGSpringContextTests{
	public static Logger logger=Logger.getLogger(BaseTestCase.class);
}
