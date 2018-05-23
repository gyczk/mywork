package com.czk.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chart")
@Controller
public class HighCharts {
	@RequestMapping("/mychart")
	public String chart(){
		return "/highcharts/charts";
	}
}
