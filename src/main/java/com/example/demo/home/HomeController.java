package com.example.demo.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	// localhost:8082/homeへのGETに対する処理をさせる
	public String getHome() {

		// GETリクエストに対してhome.htmlを表示させる
		return "home/home";
	}
}
