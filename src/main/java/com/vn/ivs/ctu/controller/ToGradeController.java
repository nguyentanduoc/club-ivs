package com.vn.ivs.ctu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.Summarization;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.SumarizationService;
import com.vn.ivs.ctu.utils.DateUtils;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Controller
@RequestMapping(path="to-grade/")
public class ToGradeController {
	
	@Autowired SumarizationService sumarizationService;
	@Autowired ClubService clubService;
	
	@RequestMapping(path="index")
	public String tableScore(ModelMap map) {
		
		int idMember = SecurityUtils.getMyUserDetail().getIdMember();
		Club club = clubService.getLeaderClub(idMember);
		if(club!=null) {
			List<Summarization> sums =  sumarizationService.getSumByClubPreMonth(club.getIdClub(), DateUtils.getCurentMonth(),DateUtils.getCurentYear());
			if(sums!=null) {
				map.put("status", 200);
				map.put("sums", sums);
			}
			else {
				map.put("status", 400);
			}
		}else {
			map.put("status", 403);
		}
		
		return "tableScore";
	}
}
