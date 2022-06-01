package br.edu.unifcv.service;

import br.edu.unifcv.exceptions.ProductNotFoundException;
import br.edu.unifcv.model.Product;
import br.edu.unifcv.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void update(long productId, Product product) throws ProductNotFoundException {

        if (!productRepository.existsById(productId)) throw new ProductNotFoundException();

        product.setId(productId);

        productRepository.save(product);

    }

    @Transactional
    public void delete(long productId) throws ProductNotFoundException {

        if (!productRepository.existsById(productId)) throw new ProductNotFoundException();
        productRepository.deleteById(productId);

    }

    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
