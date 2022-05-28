package br.edu.unifcv;

import br.edu.unifcv.view.ProductsForm;
import mdlaf.MaterialLookAndFeel;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.util.Locale;

@SpringBootApplication
public class CVFoodsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(CVFoodsApplication.class).headless(false).run(args);
        initializeUI();
        SwingUtilities.invokeLater( () -> {
            ProductsForm productsForm = applicationContext.getBean(ProductsForm.class);
            productsForm.setVisible(true);
        } );

    }

    public static void initializeUI() {
        try {
            Locale.setDefault(new Locale("pt-BR"));
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

}