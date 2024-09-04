package fr.assara.widgets.repository;

import fr.assara.widgets.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
