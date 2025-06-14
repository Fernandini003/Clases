package com.cibertec;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cibertec.entity.Category;
import com.cibertec.repository.CategoryRepository;

@SpringBootApplication
public class SpringSesion1Application implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSesion1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category category = new Category();
		category.setName("Prueba");
		category.setLastUpdate(new Date());
		
		categoryRepository.save(category);
		
		List<Category> categoryList = categoryRepository.findAll();
		
		for(Category c : categoryList) {
			System.out.println(c);
		}
		
	}

}
