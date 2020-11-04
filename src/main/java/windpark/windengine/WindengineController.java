package windpark.windengine;

import org.springframework.web.bind.annotation.RestController;

import windpark.model.WindengineData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class WindengineController {

    @Autowired
    private WindengineService service;
	
    @RequestMapping("/")
    public String windengineMain() {
    	String mainPage = "This is the windengine application! (DEZSYS_GK72_WINDPARK) <br/><br/>" +
                          "<a href='http://localhost:8080/windengine/001/xml'>Link to windengine/001/xml</a><br/>" +
                          "<a href='http://localhost:8080/windengine/001/json'>Link to windengine/001/json</a><br/>";
        return mainPage;
    }
    
    @RequestMapping(value="/windengine/{windengineID}/xml",produces = {"application/xml"})
    public WindengineData windengineDataXML( @PathVariable String windengineID ) {
        return service.getWindengineData( windengineID );
    }

    @RequestMapping(value="/windengine/{windengineID}/json",produces = {"application/json"})
    public WindengineData windengineDataJSON( @PathVariable String windengineID ) {
        return service.getWindengineData(windengineID);
    }

}