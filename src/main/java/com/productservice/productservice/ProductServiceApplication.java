package com.productservice.productservice;



import com.productservice.productservice.Repositories.CategoryRepository;
import com.productservice.productservice.Repositories.PriceRepository;
import com.productservice.productservice.Repositories.ProductRepository;
import com.productservice.productservice.inheritanceRelations.singleTable.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
// 	private ST_MentorRepository ST_mentorRepository;
//	 private ST_UserRepository ST_userRepository;
//	 private ST_StudentRepository ST_studentRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final PriceRepository priceRepository;

	ProductServiceApplication(CategoryRepository categoryRepository,
							  ProductRepository productRepository,
							  PriceRepository priceRepository){
		this.categoryRepository = categoryRepository;
		this.productRepository =  productRepository;
		this.priceRepository = priceRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor=new Mentor();
//		mentor.setAvgRating(4.9);
//		mentor.setName("Kiran");
//		mentor.setEmailId("abc@gmail.com");
//		ST_mentorRepository.save(mentor);
//
//		Student student = new Student();
//		student.setPsp(90);
//		student.setName("John");
//		student.setEmailId("xyz.com");
//		ST_studentRepository.save(student);
//
//		User user = new User();
//		user.setName("John");
//		user.setEmailId("xyz.com");
//		ST_userRepository.save(user);
//	List<User> users= ST_userRepository.findAll();
//
//		for (User user1: users){
//			System.out.println(user1.toString());
//		}

//		Category category = new Category();
//
//		category.setName("Apple devices");
//
//		Category savedCategory = categoryRepository.save(category);

//		Optional<Category> category = categoryRepository.findById(UUID.fromString("f9cc844d-fc00-4dbd-911d-95862ed61718"));
//
//		if(category.isEmpty()){
//			throw new Exception("Category not found");
//		}


//		Product product = new Product();
//		product.setTitle("iPhone 15");
//		product.setDescription("iphone 15,16GB RAM,128 HD");
//		product.setPrice(4);
//		product.setCategory(category.get());
//
//		Product savedProduct = productRepository.save(product);

		//Find all products with category = Apple devices

//		List<Product> products = category.get().getProducts();
//		for(Product product: products){
//			System.out.println(product.toString());
//		}

//		Price price = new Price();
//		price.setCurrency("INR");
//		price.setValue(10000.00);
//		Price savedPrice = priceRepository.save(price);
//
//		Category category = new Category();
//		category.setName("Apple devices");
//		Category savedCategory = categoryRepository.save(category);
//
//		Product product = new Product();
//		product.setTitle("iPhone 15");
//		product.setDescription("iphone 15,16GB RAM,128 HD");
//		product.setPrice(savedPrice);
//		product.setCategory(savedCategory);
//		Product savedProduct = productRepository.save(product);

		productRepository.deleteById(UUID.fromString("6a798a2b-5f0f-4f4b-baba-8972ee20d8b3"));



	}
}
