package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Services.CoronaDataService;
import com.example.demo.models.LocationStats;

@Controller
public class HomeController {

	@Autowired
	CoronaDataService coronaDataService;
	@GetMapping("/")
	public String home(Model model) {
		ArrayList<LocationStats> allstats = coronaDataService.getData();
		int totalcount = allstats.stream().mapToInt(stat->stat.getLetestTotalcases()).sum();
		model.addAttribute("locationStats", allstats);
		model.addAttribute("totalcount",totalcount);
		return "home";
	}
	
}
