package com.amex.vo;

import java.util.ArrayList;
import java.util.List;

public class NewsBulletins {

	List<NewsBulletin> entries = new ArrayList<NewsBulletin>();

	public List<NewsBulletin> getLisOfBulletins() {
		return entries;
	}

	public void setLisOfBulletins(List<NewsBulletin> lisOfBulletins) {
		this.entries = lisOfBulletins;
	}
}
