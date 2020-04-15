package com.example.demo.Services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LocationStats;

@Service
@RestController
public class CoronaDataService {
	
	
	
	public static String VIRUS_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private ArrayList<LocationStats> allsets =  new ArrayList<>();
	
	public ArrayList<LocationStats> getData() {
		return allsets;
	}
	
	@PostConstruct
	public void FatchVirusData() throws IOException {
		ArrayList<LocationStats> newStats =  new ArrayList<>();
		URL stockURL = new URL(VIRUS_URL);
		BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream()));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
           LocationStats l = new LocationStats();
           l.setState(record.get("Province/State"));
           l.setCountry(record.get("Province/State"));
           
           int letest = Integer.parseInt(record.get(record.size()-1));
           int previous = Integer.parseInt(record.get(record.size()-2));
           l.setLetestTotalcases(letest);
           l.setDiff(letest-previous);
			/* System.out.println(l); */
           newStats.add(l);
        }
        	this.allsets =  newStats;
		
	}

}
