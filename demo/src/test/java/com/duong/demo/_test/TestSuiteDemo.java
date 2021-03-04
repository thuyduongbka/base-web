package com.duong.demo._test;


import com.duong.demo._test.junit.OrderedTestsDemo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.runner.SelectClasses;
import org.junit.platform.runner.SelectPackages;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(JUnitPlatform.class)
@SelectClasses(OrderedTestsDemo.class)
@SpringBootTest
public class TestSuiteDemo {
}
