package wind.test.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by huchaoyang on 2017/7/15.
 */
@ContextConfiguration("classpath*:applicationContext.xml")
public class BaseTestCase extends AbstractTestNGSpringContextTests {
    private static Logger logger = Logger.getLogger(BaseTestCase.class);

    protected static final int CHROME_DRIVER = 1;
    protected static final int FIREFOX_DRIVER = 2;
    protected static final int IE_DRIVER = 3;
    private WebDriver webDriver;

    @BeforeSuite
    public void initDb() {
        //DB为数据环境路径（目前:qa,home,如特殊测试需要可覆盖次父类的内容）
        System.setProperty("DB", "qa");
       logger.info("READ DATABASE FROM "+System.getProperty("DB"));
    }

    private void initWebDriver() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//页面加载超时设置
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//元素定位超时设置
        logger.info("webDriver初始化完成");
    }

    /**
     * 关闭并释放webDriver
     */
    public void closeWebDriver() {
        try {
            webDriver.quit();
            logger.info("webDriver释放完成");
        } catch (Exception e) {
            logger.error("webDriver释放失败");
            logger.error(e.getMessage());
        }
    }

    /**
     * 获取webDriver驱动并初始化设置
     *
     * @param driverInt
     * @return
     */
    public WebDriver getWebDriver(int driverInt) {
        String driverPath = "";
        try {
            driverPath = new File("").getCanonicalPath() + "\\src\\main\\resources\\dataDriver\\browser\\";
            logger.info("READ DRIVERPATH FROM "+driverPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (driverInt) {
            case CHROME_DRIVER: {
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                webDriver = new ChromeDriver();
                this.initWebDriver();
                break;
            }
            case FIREFOX_DRIVER: {
                webDriver = new FirefoxDriver();
                this.initWebDriver();
                break;
            }
            case IE_DRIVER: {
                System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer32.exe");
                webDriver = new InternetExplorerDriver();
                this.initWebDriver();
                break;
            }
            default:
                break;
        }

        return webDriver;
    }
}
