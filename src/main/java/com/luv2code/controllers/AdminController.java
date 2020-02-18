package com.luv2code.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.domain.AvocatVo;
import com.luv2code.entities.Avocat;
import com.luv2code.entities.Role;
import com.luv2code.entities.User;
import com.luv2code.service.IAvocatService;
import com.luv2code.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    private IAvocatService service;
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("/home")
    public String index(Model m) {
        return "admin/welcomePageAdmin";
    }
	  @RequestMapping(value = "/save")
	    public String save(@ModelAttribute("avocatVo") AvocatVo avocat) {
	        service.save(avocat);
	        return "redirect:/admin/list"; // will redirect to viewemp request mapping
	    }
	  
	  @RequestMapping("/form")
	    public String showform(Model m) {
	        m.addAttribute("avocatVo", new AvocatVo());
	        return "/admin/edit";
	    }
	  
	  @RequestMapping("/list")
	    public String viewemp(Model m) {
	        List<AvocatVo> list = service.getAvocats();
	        m.addAttribute("list", list);
	        return "/admin/viewAvocat";
	    }
	  
	  @RequestMapping(value = "/edit/{id}")
	    public String edit(@PathVariable Long id, Model m) {
	        AvocatVo avocat = service.getAvocatById(id);
	        m.addAttribute("avocatVo", avocat);
	        return "/admin/edit";
	    }
	 
	    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
	    public String editsave(@ModelAttribute("avocatVo") AvocatVo avocat) {
	        service.save(avocat);
	        return "redirect:/admin/list";
	    }
	 
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable Long id) {
	        service.delete(id);
	        return "redirect:/admin/list";
	    }
	    
	    @RequestMapping (value = "/Recherche", method= RequestMethod.GET)
	    public String Recherche(Model m , @RequestParam(value="nomAvocat") String nomAvocat) {
	    	List <Avocat> List =service.findBynomAvocat(nomAvocat);
	    	m.addAttribute("list",List);
	    	return "admin/viewAvocat";
	    	
	    }
	    
	    @RequestMapping(value = "/RegisterAvocat", method = RequestMethod.GET)
	    public String RegisterAvocat( Model model) {
	        User user = new User();
	        model.addAttribute("User", user);
	        return "admin/RegisterFormAvocat";
	    }
	    
	    @RequestMapping(value = "/RegisterSecretaire", method = RequestMethod.GET)
	    public String RegisterSecretaire( Model model) {
	        User user = new User();
	        model.addAttribute("User", user);
	        return "admin/RegisterFormSecretaire";
	    }
	    
	    @RequestMapping(value = "/saveAvocat")
	    public String SaveAvocat(@ModelAttribute("User") User user ) {
	    	if(userService.CompareUserWithAllUsers(user)==true)
	    		return "access-denied2";
	    	
	    	else {
	    	Role roleAvocat= userService.getRoleByName("AVOCAT");
	    	user.setRoles(Arrays.asList(roleAvocat));
	    	userService.save(user);
	        return "redirect:/Adminhome";
	    	}
	    		
	    }
	    
	    @RequestMapping(value = "/saveSecretaire")
	    public String SaveSecretaire(@ModelAttribute("User") User user ) {	    	
	    	if(userService.CompareUserWithAllUsers(user)==true)
	    		return "access-denied2";
	    	
	    	else {
	    	Role roleAvocat= userService.getRoleByName("SECRETAIRE");
	    	user.setRoles(Arrays.asList(roleAvocat));
	    	userService.save(user);
	        return "redirect:/Adminhome";
	    	
	    	}
	    }
	    
	    
}
