package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhonebookController.list()");

		List<PersonVo> personList = phonebookService.exeList();

		model.addAttribute("pList", personList);

		return "list";
	}

	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");

		phonebookService.exeWrite(personVo);

		return "redirect:/list"; // 리다이렉터

	}

	// 등록폼
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		return "writeForm";

	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int personId) {

		System.out.println("phonebookController.delete()");

		phonebookService.exeDelete(personId);

		return "redirect:/list";

	}

	// 수정폼
	@RequestMapping(value = "/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {

		System.out.println("phonebookController.modifyform()");
		
		PersonVo personVo = phonebookService.exeModifyForm(no);

		model.addAttribute("personVo", personVo);

		return "/modifyForm";

	}

	//수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("phonebookController.modify()");
		
		phonebookService.exeUpdate(personVo);
		
		return "redirect:/list";
	}
}
