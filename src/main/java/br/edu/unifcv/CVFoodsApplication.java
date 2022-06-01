package br.edu.unifcv;

import br.edu.unifcv.view.ProductsForm;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
@SpringBootApplication
public class CVFoodsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(CVFoodsApplication.class).headless(false).run(args);
        SwingUtilities.invokeLater(() -> {
            ProductsForm productsForm = applicationContext.getBean(ProductsForm.class);
            productsForm.setVisible(true);
        });

    }

}