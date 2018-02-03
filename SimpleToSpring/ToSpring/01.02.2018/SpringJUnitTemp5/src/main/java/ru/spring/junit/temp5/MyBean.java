package ru.spring.junit.temp5;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    @Autowired
    private Logger log;

}