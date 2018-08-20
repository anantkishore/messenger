/**
 * 
 */
package com.kishore.anant.messenger.application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.kishore.anant.messenger.dao.impl.WineDaoImpl;

/**
 * @author i351596
 *
 */

@WebListener
public class ApplicationContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Starting");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Shutdown");
		closeAllResources();
	}

	private void closeAllResources() {
		WineDaoImpl.closeAllResources();
	}
}
