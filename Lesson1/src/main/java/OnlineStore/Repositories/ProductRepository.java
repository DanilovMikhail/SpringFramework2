package OnlineStore.Repositories;

import OnlineStore.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    @Query("from Product p where p.name = :name")
    List<Product> filterProductsByName(@Param("name") String name);

    Page<Product> findAllByCostBetween(BigDecimal minCost, BigDecimal maxCost, Pageable pageable);

    Page<Product> findAllByCostGreaterThanEqual(BigDecimal minCost, Pageable pageable);

    Page<Product> findAllByCostLessThanEqual(BigDecimal maxCost, Pageable pageable);
}
