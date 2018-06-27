package com.vn.ivs.ctu.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.vn.ivs.ctu.utils.SecurityUtils;

@Component
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			logger.error("Can't redirect");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if (isAdmin(roles)) {
			url = "/admin";
		} else if (isOtc(roles)) {
			url = "/leader";
		} else if (isOtcLub(roles)) {
			url = "/leaderclub";
		} else if (isMember(roles)) {
			url = "/member";
		}
		return url;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	private boolean isMember(List<String> roles) {
		if (roles.contains("MEMBER")) {
			return true;
		}
		return false;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}

	private boolean isOtc(List<String> roles) {
		if (roles.contains("LEADER")) {
			return true;
		}
		return false;
	}
	private boolean isOtcLub(List<String> roles) {
		if (roles.contains("LEADER_CLUB")) {
			return true;
		}
		return false;
	}
}
