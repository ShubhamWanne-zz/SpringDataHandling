package com.psl.SpringDB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.SpringDB.dao.CircleDAOClassImp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	CircleDAOClassImp dao = ctx.getBean("circleDAOClassImp", CircleDAOClassImp.class);
//    	System.out.println(dao.getNumberOfCircle());
//    	System.out.println(dao.getCircleWithJDBCTemplate(1));
//    	System.out.println(dao.getRecords());
//    	Circle circle = new Circle(new Random(1000).nextInt(), "Annulus");
//    	System.out.println("Circle "+circle+" is inserted = "+dao.insertCircle(circle));
//    	System.out.println("Creating a Triangle table");
//    	dao.createTriangle();
//    	dao.insertTriangle(new Triangle(2,"Equi"));    
    	System.out.println(dao.getNumberOfCircle());
    }
}
