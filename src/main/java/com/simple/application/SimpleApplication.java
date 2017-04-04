package com.simple.application;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.google.common.collect.ImmutableSet;

public class SimpleApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    return ImmutableSet.<Class<?>>builder()
        .add(SimpleResource.class)
        .build();
  }

}
