package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest2 {

    @Test
    public void testCreatedCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(0, shoppingCart.getItems().size());
    }

    @Test
    public void testEmpty() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.empty();
        assertEquals(0, shoppingCart.getItems().size());
    }

    @Test
    public void testAddItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCart shoppingCart2 = new ShoppingCart();
        Product product = new Product("t", 5);
        shoppingCart.addItem(product);
        assertEquals(1, shoppingCart.getItems().size() - shoppingCart2.getItems().size());
    }

    @Test
    public void testGetBalance() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("t", 5);
        Product product2 = new Product("3", 3);
        shoppingCart.addItem(product);
        shoppingCart.addItem(product2);
        assertEquals(8.0, shoppingCart.getBalance());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("t", 5);
        Product product2 = new Product("3", 3);
        shoppingCart.addItem(product);
        shoppingCart.addItem(product2);
        assertEquals(2, shoppingCart.getItemCount());
        try {
            shoppingCart.removeItem(product);
            assertEquals(1, shoppingCart.getItemCount());
        } catch (ProductNotFoundException e) {
        }
    }

    @Test
    public void testProductNotFoundException() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("t", 5);
        Exception exception = assertThrows(ProductNotFoundException.class,
                () -> shoppingCart.removeItem(product));

        assertNull(exception.getMessage());
    }
}

