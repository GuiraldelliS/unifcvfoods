package br.edu.unifcv.view;

import br.edu.unifcv.exceptions.ProductNotFoundException;
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

    private Product currentProduct;

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
    private JTextField descriptionJField;
    private JTextArea fullDescriptionJTextArea;
    private JScrollPane fullDescriptionJScrollPane;
    private JSpinner buyPriceJSpinner;
    private JSpinner sellPriceJSpinner;
    private JSpinner amountJSpinner;
    private JSpinner minAmountJSpinner;
    private JPanel pricesJPanel;
    private JPanel amountsJPanel;
    private JSpinner soldAmountJSpinner;
    private JPanel buttonsJPanel;
    private JButton saveButton;
    private JButton deleteButton;

    public ProductsForm(ProductService productService) throws HeadlessException {
        this.productService = productService;
        this.productListModel = new DefaultListModel<>();
        this.productJList.setModel(productListModel);
        this.productJList.setPrototypeCellValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        setContentPane(productJPanel);
        setTitle("UniFCV Foods");
        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.refreshProductList();

        productJList.addListSelectionListener(e -> setCurrentProduct((Product) productJList.getSelectedValue()));
        deleteButton.addActionListener(e -> {
            if (currentProduct != null) {
                try {
                    productService.delete(currentProduct.getId());
                    JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
                    refreshProductList();
                } catch (ProductNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        saveButton.addActionListener(e -> {
            if (currentProduct != null) {

                Product product = new Product();
                product.setDescription(descriptionJField.getText());
                product.setFullDescription(fullDescriptionJTextArea.getText());
                product.setBuyPrice((Integer) buyPriceJSpinner.getValue());
                product.setSellPrice((Integer) sellPriceJSpinner.getValue());
                product.setSoldAmount((Integer) soldAmountJSpinner.getValue());
                product.setMinAmount((Integer) minAmountJSpinner.getValue());
                product.setAmount((Integer) amountJSpinner.getValue());

                try {
                    productService.update(currentProduct.getId(), product);
                } catch (ProductNotFoundException ex) {
                    productService.add(product);
                } finally {
                    refreshProductList();
                    JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
                }
            }
        });
    }

    private void refreshProductList() {
        productListModel.removeAllElements();
        List<Product> allProduct = productService.findAll();
        if (!allProduct.isEmpty()) {
            allProduct.forEach(this.productListModel::addElement);
        }

        Product newProduct = new Product();
        newProduct.setDescription("Novo produto");

        productListModel.addElement(newProduct);

        productJPanel.repaint();
        productJPanel.revalidate();

    }

    private void setCurrentProduct(Product product) {
        if (product == null) return;

        this.currentProduct = product;
        this.descriptionJField.setText(product.getDescription());
        this.fullDescriptionJTextArea.setText(product.getFullDescription());
        this.buyPriceJSpinner.setValue(product.getBuyPrice());
        this.sellPriceJSpinner.setValue(product.getSellPrice());
        this.amountJSpinner.setValue(product.getAmount());
        this.minAmountJSpinner.setValue(product.getMinAmount());
        this.soldAmountJSpinner.setValue(product.getSoldAmount());

    }

}
