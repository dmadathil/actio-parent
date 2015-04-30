/**
 * 
 */
package com.covisint.action.server.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covisint.core.http.service.server.Version;
import com.covisint.core.http.service.server.view.ModelSupport;
import com.javasteam.amazon.echo.plugin.Builtin;

/**
 * @author dmadathil
 *
 */
@Controller
@RequestMapping(value = "/actio")
public class ActioController {
	
	private final Logger log = LoggerFactory.getLogger(ActioController.class);

	/**
	 * 
	 */
	public ActioController() {
		// TODO Auto-generated constructor stub
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

}
