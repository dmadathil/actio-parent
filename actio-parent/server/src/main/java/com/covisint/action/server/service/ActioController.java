/**
 * 
 */
package com.covisint.action.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javasteam.amazon.echo.EchoUserSession;
import com.javasteam.amazon.echo.plugin.Builtin;
import com.javasteam.util.Configurator;

/**
 * @author dmadathil
 *
 */
@Controller
@RequestMapping(value = "/actio")
public class ActioController {
	
	private final Logger log = LoggerFactory.getLogger(ActioController.class);
	
	private static final EchoUserSession echoUserSession;
	static {
	  Configurator    configurator    = new Configuration();
	  
	  echoUserSession = new EchoUserSession( configurator );
	  echoUserSession.startPollers();
	}

	/**
	 * 
	 */
	public ActioController() {
		// TODO Auto-generated constructor stub
	}
	
	  @RequestMapping(method = RequestMethod.GET, value = "/test/{id}" ,produces =  {"text/plain; charset=UTF-8"})
	  @ResponseBody
	    public String getDeviceTest(@PathVariable String id) {

	        log.debug("Attempting to retrieve resource with ID {}", id);

	       // final Map<String, Object> responseModel = ModelSupport.createModel();
	        log.debug("Retrieved the following resource with ID {}: {}", "DILEEP", "SUCCESS");
            //ModelSupport.setVersion(responseModel, currentResourceVersion);
           // ModelSupport.setBody(responseModel, "SUCCESS");
            
	        
	        //String retval = Builtin.fetchQueuedItem( id );
            //return retval != null ? retval : "TURNONREDLIGHT";
	        
	        return "TURNONREDLIGHT";
	  }
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/home")
	  public ModelAndView showHomePage() {
		  log.info("INSIDE ModelANDvIEW");
	      return new ModelAndView("index");   
	     }
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/{id}" ,produces =  {"text/plain; charset=UTF-8"})
        @ResponseBody
          public String getDevice(@PathVariable String id) {

              log.debug("Attempting to retrieve resource with ID {}", id);

             // final Map<String, Object> responseModel = ModelSupport.createModel();
              log.debug("Retrieved the following resource with ID {}: {}", "DILEEP", "SUCCESS");
              //ModelSupport.setVersion(responseModel, currentResourceVersion);
             // ModelSupport.setBody(responseModel, "SUCCESS");
              
              
              String retval = Builtin.fetchQueuedItem( id );
              return retval != null ? retval : "";
        }
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/{command}" ,produces =  {"text/plain; charset=UTF-8"})
        @ResponseBody
        public String getDevice(@PathVariable String id, @PathVariable String command ) {
	      id = id.toLowerCase();
	      Builtin.queueItem( id, command );
	      return "SUCCESS";
	    }
}
