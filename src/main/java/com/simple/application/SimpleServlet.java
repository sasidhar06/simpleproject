package com.simple.application;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.WebComponent;

public class SimpleServlet extends ServletModule {

  @Override
  protected void configureServlets() {
    configureGuiceServlet();
  }

  private void configureGuiceServlet() {
    ResourceConfig rc = new PackagesResourceConfig("com.simple.application");
    for (Class<?> resource : rc.getClasses()) {
      bind(resource).in(Scopes.SINGLETON);
    }
    final Map<String, String> options = new HashMap<String, String>();
    options.put(WebComponent.RESOURCE_CONFIG_CLASS, SimpleApplication.class.getName());
    serve("/service/*").with(GuiceContainer.class, options);
    bind(Manager.class).to(ManagerImpl.class);
  }
}
