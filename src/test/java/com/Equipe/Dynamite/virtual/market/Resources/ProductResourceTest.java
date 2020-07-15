package com.Equipe.Dynamite.virtual.market.Resources;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Equipe.Dynamite.virtual.market.dtos.CategorieDTo;
import com.Equipe.Dynamite.virtual.market.dtos.ProductDto;
import com.Equipe.Dynamite.virtual.market.resources.ProductResource;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductResourceTest {

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	@Autowired
	private RestService restService;
	private ProductDto productDto;
	private CategorieDTo categorieDTo;
	
	@Before
	public void before() {
		this.categorieDTo = new CategorieDTo(1, "color");

		this.productDto= new ProductDto(1, 50, "name", "description", 50 , this.categorieDTo,"Imagen");
	}
	
	@Test
	public void createProductTest() {
		restService.restBuilder().path(ProductResource.PRODUCT).body(productDto).post().build();
	}
	
	@Test
	public void readAllProductsTest() {
		String json= restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(ProductResource.PRODUCT).get().build();
		System.out.println("------>"+json);
	}
	@Test
	public void readProductByIdTest() {
		String json= restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(ProductResource.PRODUCT)
				.path(ProductResource.ID).expand(1).get().build();
		System.out.println("------>"+json);
	}
	
	@Test
	public void editProductTest() {
		this.categorieDTo.setId(2);
		this.productDto.setId(2);
		this.productDto.setName("Calzones IronMan 5X1");
		this.productDto.setDescription("Calzon de marvel");
		this.productDto.setPrice(20.00);
		this.productDto.setStock(100);
		this.productDto.setCategorie(categorieDTo);
		this.productDto.setImage(" hola ");
		restService.restBuilder().path(ProductResource.PRODUCT)
		.path(ProductResource.ID).expand(1).body(productDto).put().build();	
	}
	
}

