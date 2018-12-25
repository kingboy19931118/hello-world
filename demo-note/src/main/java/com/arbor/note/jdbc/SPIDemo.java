package com.arbor.note.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * @author qiaomu.wang
 * @date 2018-12-21
 */
public class SPIDemo {

    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver;
        while (drivers.hasMoreElements()) {
            driver = drivers.nextElement();
            System.out.println(driver.getClass() + "------" + driver.getClass().getClassLoader());
        }
        System.out.println(DriverManager.class.getClassLoader());
    }
}
