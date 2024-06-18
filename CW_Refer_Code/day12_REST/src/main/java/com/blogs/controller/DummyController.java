package com.blogs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Category;

@RestController
/*
 * =@Controller at the cls level + @ResponseBody added implicitly on ret type of
 * all req handling methods(@RequestMapping,@GetMapping....) *
 */
@RequestMapping("/dummy")
public class DummyController {
	@GetMapping
	public List<Double> renderList() {
		System.out.println("in render list");				
		return List.of(10.0, 20.5, 30.56, 40.123);
	}

}
