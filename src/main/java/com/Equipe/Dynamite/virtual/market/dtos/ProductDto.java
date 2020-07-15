package com.Equipe.Dynamite.virtual.market.dtos;

import com.Equipe.Dynamite.virtual.market.entities.Product;

public class ProductDto {
private int id, stock;
private String name,description,image;
private double price;
private CategorieDTo categorie;

public ProductDto(int id, int stock, String name, String description, double price,CategorieDTo categorie, String image) {
	super();
	this.id = id;
	this.stock = stock;
	this.name = name;
	this.description = description;
	this.price = price;
	this.categorie = categorie;
	this.image=image;
	
}
public ProductDto(Product product) {
	this.id= product.getId();
	this.stock= product.getStock();
	this.name= product.getName();
	this.description= product.getDescription();
	this.price= product.getPrice();
	this.categorie= new CategorieDTo(product.getCategorie());
	this.image=product.getImage();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public CategorieDTo getCategorie() {
	return categorie;
}
public void setCategorie(CategorieDTo categorie) {
	this.categorie = categorie;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}


}
