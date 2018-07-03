package com.vn.ivs.ctu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/"})
public class HomeController {
	
	@GetMapping(value="logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
		
	@RequestMapping(path= {"","login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping(path= {"admin"})
	public String admin() {
		return "index";
	}
	
	@RequestMapping(path= {"leader"})
	public String otc() {
		return "index";
	}
	@RequestMapping(path= {"leaderclub"})
	public String otcclub() {
		return "index";
	}
	@RequestMapping(path= {"member"})
	public String member() {
		return "index";
	}
	@RequestMapping(path="403")
	public String accessDinied() {		
		return "redirect:/login?accessDinied";
	}
	@RequestMapping(path="404")
	public String notFount() {		
		return "404";
	}
}
