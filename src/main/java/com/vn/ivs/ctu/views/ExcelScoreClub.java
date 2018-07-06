package com.vn.ivs.ctu.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.vn.ivs.ctu.entity.Summarization;;

public class ExcelScoreClub extends  AbstractXlsView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment:filename=\"score_club.xls\"");	
		
		List<Summarization> list = (List<Summarization>) model.get("sums");
		Sheet sheet = workbook.createSheet("scoreList");
		Row  header = sheet.createRow(0);
		header.createCell(0).setCellValue("Tên thành viên");
		header.createCell(1).setCellValue("Số Điểm");
		header.createCell(2).setCellValue("Điểm Phát sinh");
		header.createCell(3).setCellValue("Ghi Chú");
		int  rownum = 1;
		for(Summarization s:list) {
			Row row =  sheet.createRow(rownum++);
			row.createCell(0).setCellValue(s.getMember().getNameMember());
			row.createCell(1).setCellValue(s.getScoreClub());
			row.createCell(2).setCellValue(s.getToAriseScore());
			row.createCell(3).setCellValue(s.getNote());
		}
	}
}
