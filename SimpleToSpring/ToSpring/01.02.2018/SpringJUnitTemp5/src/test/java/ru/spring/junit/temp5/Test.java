package ru.spring.junit.temp5;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


@EnableAutoConfiguration
@ComponentScan
public class Test {

    ApplicationContext ctx;
    //Как можно запускать -  и спользовать бины
    //var 1
    AbstractPage abstractPage;
    //var 2
    YandexSearchPage yandexSearchPage;

    //Как можно логировать
    @Logging
    Logger log;


    @Before
    public void setUp(){
        this.ctx = new ClassPathXmlApplicationContext("beans.xml");
        //Логирование:var 1 - вывод на консоль
        Logger logger = Logger.getLogger(String.valueOf(YandexSearchPage.class));
        logger.info("Method \"tearDown\" worked");
        //Логирование:var 2
        //log.name == LoggingAnnotationProcessorTest.name;
        //log.getName();
        //Test.class.getName();
        log.
    }

    @org.junit.Test
    public void test(){
        //var 1
       /* String URL = "http://yandex.ru";
        abstractPage = (AbstractPage) ctx.getBean("d");
        abstractPage.loadUrl(URL);*/

        // var 2
        yandexSearchPage = (YandexSearchPage) ctx.getBean("d");
        yandexSearchPage.load();

        //Логирование: var 1 -  вывод на консоль
        //Logger logger = (Logger) LoggerFactory.getLogger(YandexSearchPage.class);
        Logger logger = Logger.getLogger(String.valueOf(YandexSearchPage.class));
        logger.info("Worked method \"test\" in class  \"Test\"");
    }

    @After
    public void tearDown() throws Exception{
        // var 1
        //  abstractPage.driver.close();
        // var 2
        yandexSearchPage.driver.close();
        //Логирование:var 1 - вывод на консоль
        Logger logger = Logger.getLogger(String.valueOf(YandexSearchPage.class));
        logger.info("Method \"tearDown\" worked");
    }

    @Bean
    public LoggingAnnotationProcessor loggingAnnotationProcessor(){
        return new LoggingAnnotationProcessor();
    }

    /**
     * 1)Посмотреть вот это:
     * 2)+ добавить логирование
     * private static WebDriver driver;
     * Источник: https://memorynotfound.com/selenium-firefox-webdriver-test-cases-junit-java/

     @BeforeClass
     public static void setUp(){
     driver = new FirefoxDriver();
     }

     @Test
     public void testFireFoxSelenium() {
     driver.get("https://memorynotfound.com/");
     }

     @AfterClass
     public static void cleanUp(){
     if (driver != null) {
     driver.close();
     driver.quit();
     }
     }
     */
}