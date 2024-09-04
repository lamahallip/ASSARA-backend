package fr.assara.widgets.repository;

import fr.assara.widgets.models.Favorite;
import fr.assara.widgets.models.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
}
