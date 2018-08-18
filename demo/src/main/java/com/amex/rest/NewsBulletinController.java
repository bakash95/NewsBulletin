package com.amex.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amex.service.GetNewsBulletin;
import com.amex.vo.NewsBulletins;

@RestController
public class NewsBulletinController {

	@Autowired
	GetNewsBulletin getNewsBulletin;

	@RequestMapping(value = "/getNewsBulletin", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<NewsBulletins> getNewsBulletinCards() {
		NewsBulletins newsBulletin = getNewsBulletin.getBulletin();
		return ResponseEntity.accepted().body(newsBulletin);
	}

	@RequestMapping(value = "/loadNews", method = RequestMethod.GET)
	public void loadNewsBulletin() {
		try {
			getNewsBulletin.loadNewsBulletinToDB();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
