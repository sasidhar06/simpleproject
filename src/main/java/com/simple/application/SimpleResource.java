package com.simple.application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;

@Path("/stuff/{id}")
public class SimpleResource {

  private final ManagerImpl manager;

  @Inject
  public SimpleResource(final ManagerImpl manager) {
    this.manager = manager;
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String submitClipboard(@PathParam("id") final String id) {
    String welcomeScreen = manager.getWelcomeScreen();
    return "This is" + welcomeScreen + id;
  }
}
