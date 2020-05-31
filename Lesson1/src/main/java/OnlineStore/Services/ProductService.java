package OnlineStore.Services;

import OnlineStore.Entities.Product;
import OnlineStore.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void update(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void delete(Product product){
        productRepository.delete(product);
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Product> findAllProductsByCostBetween(Optional<BigDecimal> minCost,
                                                      Optional<BigDecimal> maxCost,
                                                      Pageable pageable){
        if (minCost.isPresent() && maxCost.isPresent()){
            return productRepository.findAllByCostBetween(minCost.get(), maxCost.get(), pageable);
        }
        if (minCost.isPresent()){
            return productRepository.findAllByCostGreaterThanEqual(minCost.get(), pageable);
        }
        if (maxCost.isPresent()){
            return productRepository.findAllByCostLessThanEqual(maxCost.get(), pageable);
        }
        return productRepository.findAll(pageable);
    }
}
