package com.Equipe.Dynamite.virtual.market.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Equipe.Dynamite.virtual.market.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
