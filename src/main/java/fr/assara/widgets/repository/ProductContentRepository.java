package fr.assara.widgets.repository;

import fr.assara.widgets.models.ProductContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductContentRepository extends JpaRepository<ProductContent, Long> {
}
