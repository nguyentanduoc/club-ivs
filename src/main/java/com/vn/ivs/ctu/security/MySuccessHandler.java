package com.vn.ivs.ctu.security;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.utils.MyUserDetail;
import com.vn.ivs.ctu.utils.RoleUtils;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Component
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication,request);
		if (response.isCommitted()) {
			logger.error("Can't redirect");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public String determineTargetUrl(Authentication authentication,HttpServletRequest request) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		try{
			MyUserDetail myUser = SecurityUtils.getMyUserDetail();			
			if(RoleUtils.isLeaderClub(roles)) {
				if(myUser.getClubs().size()>1) {
					url = "/chooseClub";
				}else {		
					if(myUser.getClubs().size()==1) {
						Set<Club> clubs = myUser.getClubs() ;
						Iterator<Club> iter = clubs.iterator();
						request.getSession().setAttribute("club",(Club)iter.next());
					}					
				}
			}else {
				if (RoleUtils.isAdmin(roles)) {
					url = "/member/admin";
				} else if (RoleUtils.isLeader(roles)) {
					url = "/leader";
				} else if (RoleUtils.isLeaderClub(roles)) {
					url = "/schedule/scheduletotal";
				} else if (RoleUtils.isMember(roles)) {
					url = "/member/profile";
				}
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			url="/login";
		}
		
		return url;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
