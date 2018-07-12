package com.vn.ivs.ctu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.SumarizationBranch;
import com.vn.ivs.ctu.entity.Summarization;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.SumarizationBranchService;
import com.vn.ivs.ctu.service.SumarizationService;
import com.vn.ivs.ctu.utils.DateUtils;
import com.vn.ivs.ctu.utils.SecurityUtils;
import com.vn.ivs.ctu.views.ExcelScoreClub;

@Controller
@RequestMapping(path="to-grade/")
public class ToGradeController {
	
	@Autowired SumarizationService sumarizationService;
	@Autowired SumarizationBranchService sumarizationBranchService;
	@Autowired ClubService clubService;
	@Autowired BranchService branchSevice;
	
	@RequestMapping(path="index")
	public String tableScore(ModelMap map, HttpSession session) {
		map.put("action1", "score");
		map.put("action2", "scoreclub");
		map.put("title", "Bảng Điểm");
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
			List<Summarization> sums =  sumarizationService.getSumByClubPreMonth(club.getIdClub(), DateUtils.getCurentMonth()-1,DateUtils.getCurentYear());
			if(sums!=null) {
				map.put("status", 200);
				map.put("sums", sums);
			}
			else {
				map.put("status", 400);
			}
		}
		return "tableScore";
	}
	
	@PostMapping(path="updateScore")
	@ResponseBody
	public Map<String,Object> updateScore(int id, float toArise, String note, boolean require){
		Map<String,Object> map  = new HashMap<>();		
		Summarization sum =  sumarizationService.getSumById(id);
		sum.setToAriseScore(toArise);
		sum.setNote(note);
		sum.setRequireDonate(require);
		sum.setSeeDonate(false);
		if(sumarizationService.createOrUpdate(sum)>0) {
			map.put("status", 200);
		}else {
			map.put("status", 400);
		}
		map.put("status",200);
		return map;
	}
	
	@GetMapping(path="scoreTotalBrach")
	public String  scoreTotalBranch(ModelMap modelMap) {
		modelMap.put("action1", "score");
		modelMap.put("action2", "scorebranch");
		modelMap.put("title", "Bảng Điểm");
		int month = DateUtils.getCurentMonth()-1;
		int year = DateUtils.getCurentYear();
		long idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchSevice.getBranchByMember(idLeader);
		List<SumarizationBranch> sum = sumarizationBranchService.getSumByBranch(branch.getIdBranch(), month, year);
		
		if(sum!=null && sum.size()>0) {
			modelMap.put("status", 200);
			modelMap.put("sums", sum);
			System.out.println(sum);
		}		
		return "scoreTotalBranch";
	}
	
	@GetMapping(path="exportExcel")
	public ModelAndView sroceClub(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		ModelAndView modelAndView=null;
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
			List<Summarization> sums =  sumarizationService.getSumByClubPreMonth(club.getIdClub(), DateUtils.getCurentMonth()-1,DateUtils.getCurentYear());
			if(sums!=null) {
				modelAndView=  new ModelAndView(new ExcelScoreClub(),"sums",sums);
			}else {
				modelAndView= new ModelAndView("tableScore","sums",sums);
			}
		}
		return modelAndView;
	}
}