package br.edu.unifcv;

import br.edu.unifcv.view.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CVFoodsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(CVFoodsApplication.class).headless(false).run(args);

        MainFrame mainFrame = applicationContext.getBean(MainFrame.class);
        mainFrame.setVisible(true);

    }

}