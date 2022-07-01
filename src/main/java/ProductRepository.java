package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return this.products;
    }

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = Arrays.copyOf(products, length);
        tmp[length - 1] = product;
        products = tmp;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product movie : products) {
            if (movie.getId() != id) {
                if (index == length) return;
                tmp[index] = movie;
                index++;
            }
        }
        products = tmp;
    }
}
