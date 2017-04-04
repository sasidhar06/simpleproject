package com.simple.application;

import javax.servlet.ServletContextEvent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class GuiceListener extends GuiceServletContextListener {

  private Injector injector;

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    try {
      super.contextDestroyed(servletContextEvent);
    } finally {
      injector = null;
    }
  }

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    injector = Guice.createInjector(new SimpleServlet());
    super.contextInitialized(servletContextEvent);
    injector.injectMembers(this);
  }

  @Override
  protected Injector getInjector() {
    return injector;
  }

}
