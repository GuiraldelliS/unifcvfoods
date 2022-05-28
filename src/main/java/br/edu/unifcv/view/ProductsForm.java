package br.edu.unifcv.view;

import br.edu.unifcv.model.Product;
import br.edu.unifcv.service.ProductService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Component
public class ProductsForm extends JFrame {

    private final ProductService productService;
    private final DefaultListModel<Object> productListModel;
    private final List<Product> allProducts;

    private JPanel productJPanel;
    private JList<Object> productJList;
    private JScrollPane productListJScrollPane;

    private JLabel descriptionJLabel;
    private JLabel fullDescriptionJLabel;
    private JLabel buyPriceJLabel;
    private JLabel sellPriceJLabel;
    private JLabel minAmountJLabel;
    private JLabel amountJLabel;
    private JLabel soldAmountJLabel;
    private JLabel expirationDateJLabel;
    private JTextField descriptionJField;
    private JTextArea fullDescriptionJTextArea;
    private JScrollPane fullDescriptionJScrollPane;
    private JFormattedTextField buyPriceFormattedTextField;
    private JFormattedTextField sellPriceJFormattedTextField;
    private JSpinner amountJSpinner;
    private JSpinner minAmountJSpinner;
    private JPanel pricesJPanel;
    private JPanel amountsJPanel;
    private JSpinner soldAmountJSpinner;
    private JPanel buttonsJPanel;
    private JButton saveJButton;
    private JButton deleteButton;

    public ProductsForm(ProductService productService) throws HeadlessException {
        this.productService = productService;
        this.allProducts = this.productService.findAll();
        this.productListModel = new DefaultListModel<>();
        this.productJList.setModel(productListModel);
        this.productJList.setPrototypeCellValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        setContentPane(productJPanel);
        setTitle("UniFCV Foods");
        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.refreshProductList();

    }

    private void refreshProductList() {
        productListModel.removeAllElements();
        this.allProducts.forEach(product -> this.productListModel.addElement(product.getDescription()));
    }

}
