package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;

	// 리스트
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");

		List<PersonVo> personList = phonebookDao.personSelect();

		return personList;
	}

	// 등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");

		int count = phonebookDao.personInsert(personVo);

		return count;
	}

	// 삭제
	public int exeDelete(int personId) {
		System.out.println("PhonebookService.exeDelete()");

		int count = phonebookDao.personDelete(personId);

		return count;
	}

	// 수정폼
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");

		PersonVo personVo = phonebookDao.personSelectOne(no);

		return personVo;
	}

	// 수정
	public int exeUpdate(PersonVo personVo) {

		int count = phonebookDao.personUpdate(personVo);

		return count;
	}
}
