package com.covisint.action.server.service;

import java.util.HashMap;

import com.javasteam.util.Configurator;

public class Configuration implements Configurator {
  
  private static HashMap<String,String> settings = new HashMap<String,String>();
  
  public Configuration() {
    settings.put( "username",             "david.damon@covisint.com" );
    settings.put( "password",             "greniia" );
    settings.put( "loginForm",            "ap_signin_form" );
    settings.put( "userNameField",        "email" );
    settings.put( "userPasswordField",    "password" );
    settings.put( "twit.user",            "tkismarr" );
    settings.put( "twit.password",        "greniia" );
    
    settings.put( "pollingInterval",  "5" );
    settings.put( "pollingItemCount", "30" );
    
    settings.put( "todoCancelledMinutesToLive", "1440" );

    settings.put( "todoListener.1", "com.javasteam.amazon.echo.plugin.Twitter:sendTwit key=Tweet" );
    settings.put( "todoListener.2", "com.javasteam.amazon.echo.plugin.Builtin:doNothing key=light,queue=arduino" );
    settings.put( "todoListener.3", "com.javasteam.amazon.echo.plugin.Builtin:doNothing key=movie,queue=scout" );
     
    settings.put( "activityPollingStartTime", "now" );
    
    settings.put( "activityListener.1", "com.javasteam.amazon.echo.plugin.Twitter:sendTwit key=alexa simon says tweet" );
    settings.put( "activityListener.2", "com.javasteam.amazon.echo.plugin.Builtin:doNothing queue=scout, key=alexa simon says scout" );
    settings.put( "activityListener.3", "com.javasteam.amazon.echo.plugin.Builtin:doNothing queue=power, key=alexa simon says power" );
    //settings.put( "", "" );
    //settings.put( "", "" );

  }

  @Override
  public String get( String key ) {
    return settings.get(  key  );
    //String retval = settings.get( key );
    //return retval != null ? retval : "";
  }

  @Override
  public void set( String key, String value ) {
    settings.put( key, value );
  }

}
