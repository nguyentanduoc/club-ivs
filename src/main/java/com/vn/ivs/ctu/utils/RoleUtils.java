package com.vn.ivs.ctu.utils;

import java.util.List;

public class RoleUtils {
	
	public static boolean isMember(List<String> roles) {
		if (roles.contains("MEMBER")) {
			return true;
		}
		return false;
	}

	public static boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}

	public static boolean isLeader(List<String> roles) {
		if (roles.contains("LEADER")) {
			return true;
		}
		return false;
	}
	public static boolean isLeaderClub(List<String> roles) {
		if (roles.contains("LEADER_CLUB")) {
			return true;
		}
		return false;
	}
}
