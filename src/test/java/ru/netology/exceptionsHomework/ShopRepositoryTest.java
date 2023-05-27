package ru.netology.exceptionsHomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(33, "Яблоко", 80);
        Product product2 = new Product(178, "Книга", 8_000);
        Product product3 = new Product(888, "Мотоцикл", 8_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(178);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(33, "Яблоко", 80);
        Product product2 = new Product(178, "Книга", 8_000);
        Product product3 = new Product(888, "Мотоцикл", 8_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(666)
        );
    }
}