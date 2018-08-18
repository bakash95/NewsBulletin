package com.amex.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.amex.vo.NewsBulletin;
import com.amex.vo.NewsBulletins;

@Repository
public class NewsBulletinDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public NewsBulletinDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Gets the news bulletin from the Database this requires that the loadNews Rest
	 * is called atleast once
	 * 
	 * @return NewsBulletin
	 */
	public NewsBulletins getNewsFromDB() {
		NewsBulletins newsBulletins = new NewsBulletins();
		ArrayList<NewsBulletin> listOfBulletins = new ArrayList<NewsBulletin>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from news_bulletin;");
		for (Map<String, Object> row : rows) {
			String url = row.get("url").toString();
			String headLine = (String) row.get("headline");
			String publisher = (String) row.get("publisher");
			NewsBulletin newsBulletin = new NewsBulletin(headLine, url, publisher, "", "", "");
			listOfBulletins.add(newsBulletin);
		}

		newsBulletins.setLisOfBulletins(listOfBulletins);
		return newsBulletins;
	}

	/**
	 * This loads the news from csv file present in the src/resources folder and
	 * loads into the Database
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadCSVToDB() throws FileNotFoundException, IOException {
		jdbcTemplate.execute("DROP TABLE IF EXISTS news_bulletin;");
		jdbcTemplate.execute(
				"create table news_bulletin(identifier INT NOT NULL AUTO_INCREMENT,headline varchar(1000),url varchar(1000),publisher varchar(1000),character_id varchar(100),pubsite varchar(1000),expo varchar(140),CONSTRAINT contacts_pk PRIMARY KEY (identifier));");
		File file = ResourceUtils.getFile("classpath:news_bulletin.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(new FileReader(file));
		String insq = "insert into news_bulletin values(?,?,?,?,?,?,?)";
		for (CSVRecord record : records) {
			jdbcTemplate.execute(insq, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setString(1, "0");
					ps.setString(2, record.get(1));
					ps.setString(3, record.get(2));
					ps.setString(4, record.get(3));
					ps.setString(5, record.get(4));
					ps.setString(6, record.get(5));
					ps.setString(7, record.get(6));
					return ps.execute();
				}
			});
		}

	}
}
