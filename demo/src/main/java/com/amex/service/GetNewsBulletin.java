package com.amex.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amex.dao.NewsBulletinDao;
import com.amex.vo.NewsBulletins;

@Service
public class GetNewsBulletin {

	@Autowired
	NewsBulletinDao newsBulletinDao;

	public NewsBulletins getBulletin() {
		return newsBulletinDao.getNewsFromDB();
	}
	
	public void loadNewsBulletinToDB() throws FileNotFoundException, IOException {
		newsBulletinDao.loadCSVToDB();
	}
}
