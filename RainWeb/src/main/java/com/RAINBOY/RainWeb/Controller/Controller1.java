package com.RAINBOY.RainWeb.Controller;

import com.RAINBOY.RainWeb.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class Controller1
{
    @RequestMapping("/RainWebApp")//Default/Homepage(Context path)
    public String disp()
    {
        //"action" attribute of a form tag serves as a re-directory from your index page
        System.out.println ("*Controller1 Invoked*");
        return "index";//LVN, but if view name matches with URL map, then void is permitted (not recommended)
    }

    @PostMapping(value = "addAlien")//Adding data
    public String addAlien(@ModelAttribute ("alien")Alien ignoredAlien)
    //Alien ref contains constructor or setter-injected data
    {
        //@ModelAttribute can sometimes replace Model/AndView objects
        //@ModelAttribute param string should match "${}" in corresp. view file
        System.out.println ("*Controller2 Invoked*");
        return "result";
    }

    @GetMapping({"getAliens","getX-tra","getData"})//Fetching data
    public String getAliens(Map<String,Object> model)
    {
        /*
        Direct Hashmap Interface usage makes the framework less invasive
        If Spring's logic is directly used, it cannot be resolved when it runs on other machines
        All the logic should be pure Java because it'll get processed by Spring's annos and config anyway
        */
        System.out.println ("*Controller3 Invoked*");

        List<Alien> li= Arrays.asList
                (new Alien (1,"GODFREY")
                ,new Alien (2,"DAMIAN")
                ,new Alien (3,"ANNIKA"));

        model.put("result",li);
        return "detailList";
    }

}
