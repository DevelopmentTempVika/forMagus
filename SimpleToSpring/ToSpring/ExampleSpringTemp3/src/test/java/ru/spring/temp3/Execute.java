package ru.spring.temp3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.temp3.helpers.DriverManager;
import ru.spring.temp3.pages.YandexSearchPage;

public class Execute {
    /*public static void main(String [] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        *//**
         * Пример применения Spring
         * Источник:http://dev-blogs.com/simple-spring-app/
         *//*
        //Print printRectangle = (Print) context.getBean("printRectangle");
        //printRectangle.showSquare();

        //Print printCircle = (Print) context.getBean("printCircle");
        //printCircle.showSquare();

        DriverManager driverManager = (DriverManager) context.getBean("DriverManager");
        DriverManager.getDriver();

        YandexSearchPage yandexSearchPage = (YandexSearchPage) context.getBean("YandexSearchPage");
        yandexSearchPage.load();
        yandexSearchPage.goToMarket();

    }*/

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DriverManager driverManager = (DriverManager) context.getBean("DriverManager");
        DriverManager.getDriver();

        YandexSearchPage yandexSearchPage = (YandexSearchPage) context.getBean("YandexSearchPage");
        yandexSearchPage.load();
        yandexSearchPage.goToMarket();
    }
}