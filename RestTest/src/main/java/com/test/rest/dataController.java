package com.test.rest;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dataController {
	
    private DataAccesor dataAccessor = new DataAccesor();
    
    @RequestMapping("/autoFill")
    public List<String> error(@RequestParam(value="name", defaultValue="a") String name) {
        return dataAccessor.keysThatMatch(name);
    }
    
    
}
