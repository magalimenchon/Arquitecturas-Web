package edu.isistan.rest;

import java.util.Random;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LectorCicloDeVida implements ServletContextListener{

	public static String EMF = null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Aca crearia mi EntityManagerFactory");
		EMF = "E" + new Random().nextInt();
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Cerrar EntityManagerFactory");
		//ServletContextListener.super.contextDestroyed(sce);
	}
}
