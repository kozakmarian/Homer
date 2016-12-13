package sk.upjs.paz1c.homer;

import sk.upjs.paz1c.homer.guicomponents.RecipePanel;
import sk.upjs.paz1c.homer.guicomponents.ButtonTabComponent;
import sk.upjs.paz1c.homer.guicomponents.TimeTableCellRenderer;
import sk.upjs.paz1c.homer.guicomponents.PortionsTableCellRenderer;
import sk.upjs.paz1c.homer.guicomponents.ImageTableCellRenderer;
import com.alee.laf.WebLookAndFeel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ListModel;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.dao.ProductDao;
import sk.upjs.paz1c.homer.dao.RecipeDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.Product;
import sk.upjs.paz1c.homer.entity.Recipe;
import sk.upjs.paz1c.homer.entity.ShoppingList;
import sk.upjs.paz1c.homer.model.ItemListModel;
import sk.upjs.paz1c.homer.model.ListComboBoxModel;
import sk.upjs.paz1c.homer.model.ProductListModel;
import sk.upjs.paz1c.homer.model.RecipeTableModel;

/**
 *
 * @author dyske
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private ShoppingList shoppingList = new ShoppingList();
    private final RecipeDao recipeDao = ObjectFactory.INSTANCE.getDao(Recipe.class);
    private final ItemDao itemDao = ObjectFactory.INSTANCE.getDao(Item.class);
    private final ProductDao productDao = ObjectFactory.INSTANCE.getDao(Product.class);
    private final Dimension windowSize;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() * 2 / 3;
        int height = gd.getDisplayMode().getHeight() * 2 / 2;
        windowSize = new Dimension(width, height);
        
        
        initComponents();
        recipeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        recipeTable.setRowHeight(40);
        int[] widths = {69, 300, 70, 70, 100, 70};
        TableColumnModel columnModel = recipeTable.getColumnModel();
        for (int i = 0; i < recipeTable.getColumnCount() - 1; i++) {
            columnModel.getColumn(i).setMinWidth(widths[i]);
            columnModel.getColumn(i).setMaxWidth(widths[i]);
        }
        columnModel.getColumn(
                ((RecipeTableModel)(recipeTable.getModel())).COLUMN_INDEX_NAME
        ).setMaxWidth(Integer.MAX_VALUE);
        recipeTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_P);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_Z);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_R);
        refreshRecipes();
        refreshProducts(20);
    }

    private void refreshRecipes() {
        RecipeTableModel model = (RecipeTableModel) recipeTable.getModel();
        model.refresh();
    }

    private void refreshProducts(int size) {
        List<Product> products = productDao.list();
        Set<Product> setProducts = new HashSet<Product>();
        setProducts.addAll(products);
        List<Product> result = new ArrayList<Product>();
        int i = 0;
        for (Product add : setProducts) {
            if (i < size) {
                result.add(add);
            }
        }
        ProductListModel model = (ProductListModel) productList.getModel();
        model.refreshList(result);
    }

    private void refreshItems() {
        ItemListModel model = (ItemListModel) itemList.getModel();
        model.refresh(shoppingList);

    }

    private void refreshComboBox() {
        ListComboBoxModel listComboBoxModel = (ListComboBoxModel) listComboBox.getModel();
        listComboBoxModel.refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        productPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        productScrollPane = new javax.swing.JScrollPane();
        productList = new javax.swing.JList<>();
        searchProductField = new javax.swing.JTextField();
        searchProductButton = new javax.swing.JButton();
        listsPanel = new javax.swing.JPanel();
        listComboBox = new javax.swing.JComboBox<>();
        listNameLabel = new javax.swing.JLabel();
        listNameField = new javax.swing.JTextField();
        listDateLabel = new javax.swing.JLabel();
        purchasedCheckBox = new javax.swing.JCheckBox();
        listStatusLabel = new javax.swing.JLabel();
        finishedCheckBox = new javax.swing.JCheckBox();
        listScrollPane = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList();
        listAddButton = new javax.swing.JButton();
        listEditButton = new javax.swing.JButton();
        listPurchasedButton = new javax.swing.JButton();
        listRemoveButton = new javax.swing.JButton();
        webDateField2 = new com.alee.extended.date.WebDateField();
        addListButton = new javax.swing.JButton();
        recipePanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        recipeScrollPane = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable() {
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                switch(column) {
                    case RecipeTableModel.COLUMN_INDEX_IMAGE:
                    return new ImageTableCellRenderer();
                    case RecipeTableModel.COLUMN_INDEX_COOKING:
                    case RecipeTableModel.COLUMN_INDEX_PREP:
                    return new TimeTableCellRenderer();
                    case RecipeTableModel.COLUMN_INDEX_PORTIONS:
                    return new PortionsTableCellRenderer();
                    default: return super.getCellRenderer(row, column);
                }
            }
        };
        searchButton = new javax.swing.JButton();
        searchRecipeLabel = new javax.swing.JLabel();
        addRecipeLabel = new javax.swing.JLabel();
        recipeUrlTextField = new javax.swing.JTextField();
        addRecipeButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Homer");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 350));
        setPreferredSize(windowSize);
        setSize(windowSize);

        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.setMinimumSize(new java.awt.Dimension(143, 200));

        jLabel2.setText("Hľadať produkt:");

        productList.setModel(new ProductListModel());
        productList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productListMouseClicked(evt);
            }
        });
        productScrollPane.setViewportView(productList);

        searchProductField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductFieldActionPerformed(evt);
            }
        });

        searchProductButton.setText("Hľadať");
        searchProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchProductField)
                        .addGap(18, 18, 18)
                        .addComponent(searchProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(productScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)))
                .addContainerGap())
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchProductField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProductButton))
                .addGap(18, 18, 18)
                .addComponent(productScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Produkty", productPanel);

        listComboBox.setModel(new ListComboBoxModel());
        listComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listComboBoxActionPerformed(evt);
            }
        });

        listNameLabel.setText("Názov");

        listDateLabel.setText("Dátum expirácie");

        purchasedCheckBox.setText("Nakúpené");

        listStatusLabel.setText("Stav");

        finishedCheckBox.setText("Zoznam je úplný");

        itemList.setModel(new ItemListModel(shoppingList));
        listScrollPane.setViewportView(itemList);

        listAddButton.setText("Pridať...");

        listEditButton.setText("Upraviť...");
        listEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEditButtonActionPerformed(evt);
            }
        });

        listPurchasedButton.setText("Kúpené");
        listPurchasedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPurchasedButtonActionPerformed(evt);
            }
        });

        listRemoveButton.setText("Odstrániť");

        addListButton.setText("Pridať zoznam...");

        javax.swing.GroupLayout listsPanelLayout = new javax.swing.GroupLayout(listsPanel);
        listsPanel.setLayout(listsPanelLayout);
        listsPanelLayout.setHorizontalGroup(
            listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listsPanelLayout.createSequentialGroup()
                        .addComponent(listComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(listsPanelLayout.createSequentialGroup()
                        .addComponent(listScrollPane)
                        .addGap(16, 16, 16)
                        .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(listEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(listAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(listPurchasedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(listRemoveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(listsPanelLayout.createSequentialGroup()
                        .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listNameLabel)
                            .addComponent(listStatusLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(listsPanelLayout.createSequentialGroup()
                                .addComponent(purchasedCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(finishedCheckBox)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(listsPanelLayout.createSequentialGroup()
                                .addComponent(listNameField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(webDateField2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        listsPanelLayout.setVerticalGroup(
            listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addListButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listNameLabel)
                    .addComponent(listDateLabel)
                    .addComponent(webDateField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchasedCheckBox)
                    .addComponent(listStatusLabel)
                    .addComponent(finishedCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listScrollPane)
                    .addGroup(listsPanelLayout.createSequentialGroup()
                        .addComponent(listAddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listEditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listPurchasedButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listRemoveButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabbedPane.addTab("Zoznamy", listsPanel);

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        recipeTable.setModel(new RecipeTableModel());
        recipeTable.setColumnSelectionAllowed(true);
        recipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeTableMouseClicked(evt);
            }
        });
        recipeScrollPane.setViewportView(recipeTable);
        recipeTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        searchButton.setText("OK");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchRecipeLabel.setText("Vyhľadať v receptoch:");

        addRecipeLabel.setText("Pridať recept z URL:");

        recipeUrlTextField.setText("http://");

        addRecipeButton.setText("Pridať");
        addRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecipeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout recipePanelLayout = new javax.swing.GroupLayout(recipePanel);
        recipePanel.setLayout(recipePanelLayout);
        recipePanelLayout.setHorizontalGroup(
            recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recipePanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recipeScrollPane)
                    .addGroup(recipePanelLayout.createSequentialGroup()
                        .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchRecipeLabel)
                            .addComponent(addRecipeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchField)
                            .addComponent(recipeUrlTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addRecipeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        recipePanelLayout.setVerticalGroup(
            recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recipePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchRecipeLabel)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRecipeLabel)
                    .addComponent(recipeUrlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRecipeButton))
                .addGap(25, 25, 25)
                .addComponent(recipeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Recepty", recipePanel);

        fileMenu.setText("File");
        menuBar.add(fileMenu);

        editMenu.setText("Edit");
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ShoppingList addSelectedList() {
        ShoppingList selectedList = (ShoppingList) listComboBox.getSelectedItem();
        return selectedList;
    }

    private void listNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ShoppingList shoppingList = (ShoppingList) listComboBox.getSelectedItem();
        searchField.setText(shoppingList.getName());
    }

    private void listAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    

    }
    
    private void listEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEditButtonActionPerformed
        // TODO add your handling code here:
        ShoppingList shoppingList;
        if (listNameField.getText() != null) {
            shoppingList = new ShoppingList();
            shoppingList.setName(listNameField.getText());
            shoppingList.setExpiry(dateField.getDate());
            shoppingListDao.store(shoppingList);
            refreshComboBox();
        }
    }//GEN-LAST:event_addListButtonActionPerformed
    }//GEN-LAST:event_listEditButtonActionPerformed

    private void listComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listComboBoxActionPerformed
    private void listRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRemoveButtonActionPerformed
        Item item = getSelectedItem();
        itemDao.delete(item);
        refreshItems();
    }//GEN-LAST:event_listRemoveButtonActionPerformed

    private void listPurchasedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPurchasedButtonActionPerformed
        // TODO add your handling code here:
        ShoppingList shoppingList = (ShoppingList) listComboBox.getSelectedItem();
        ItemListModel model = (ItemListModel) itemList.getModel();
        model.refresh(shoppingList);

        Item item = getSelectedItem();
        item.setStatus(Status.DONE);
        refreshItems();

    }//GEN-LAST:event_listPurchasedButtonActionPerformed

    private void updateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemActionPerformed
        // TODO add your handling code here:
        Item item = getSelectedItem();
        ItemDialog productDialog;
        shoppingList = addSelectedList();
        productDialog = new ItemDialog(item, shoppingList, this, true);
        productDialog.setVisible(true);
        refreshItems();
    }//GEN-LAST:event_updateItemActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        ItemDialog productDialog;

        shoppingList = addSelectedList();
        productDialog = new ItemDialog(shoppingList, this, true);
        productDialog.setVisible(true);
        refreshItems();

    }//GEN-LAST:event_listComboBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_searchButtonActionPerformed

    private void addRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeButtonActionPerformed
        try {
            RecipeParser.fetchFromUrl(recipeUrlTextField.getText());
            ((RecipeTableModel)recipeTable.getModel()).refresh();
        } catch (IOException | UnsupportedOperationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addRecipeButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed
        shoppingList = addSelectedList();
        System.out.println(shoppingList.getName());
       
                refreshItems();

    private void searchProductFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductFieldActionPerformed
    
    }//GEN-LAST:event_searchProductFieldActionPerformed

    private void productListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productListMouseClicked
        // add product to shopping list
      

        if (evt.getClickCount() == 2) {
             
            int riadok = productList.getSelectedIndex();
            Product product;
            product = (Product) ((ListModel) productList.getModel()).getElementAt(riadok);

            ListDialog listDialog = new ListDialog(product, this, true);
            listDialog.setVisible(true);
            refreshComboBox();
        }

    }//GEN-LAST:event_productListMouseClicked

    private void listPurchasedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPurchasedButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_listPurchasedButtonActionPerformed

    private void searchProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductButtonActionPerformed
        searchProductField.setBackground(Color.white);
        String query = searchProductField.getText();
        List<Product> products = productDao.find(query);
        ProductListModel productListModel = (ProductListModel) productList.getModel();
        if (products.isEmpty())
            searchProductField.setBackground(new Color(192, 57, 43));
        else
            productListModel.refreshList(products);
    }//GEN-LAST:event_searchProductButtonActionPerformed

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked
        if (evt.getClickCount() == 2){
            int row = recipeTable.getSelectedRow();
            Recipe recipe = ((RecipeTableModel) recipeTable.getModel()).getRecipeAt(row);
            RecipePanel recipeDetailPanel = new RecipePanel(recipe);
            String recipeName = recipe.getName();
            tabbedPane.addTab(
                    recipeName.substring(0, (recipeName.length() > 16) ? 16 : recipeName.length()) + "...",
                    recipeDetailPanel
            );
            int tabIndex = tabbedPane.getTabCount() - 1;
            for (int i = 3; i < tabbedPane.getTabCount(); i++)
                tabbedPane.setMnemonicAt(i, 46+i);
            
            tabbedPane.setTabComponentAt(tabIndex, new ButtonTabComponent(tabbedPane));
            tabbedPane.setSelectedComponent(recipeDetailPanel);
        }
    }//GEN-LAST:event_recipeTableMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        this.searchForRecipeFromField();
    }//GEN-LAST:event_searchButtonMouseClicked

    private void searchForRecipeFromField() {
        String query = searchField.getText();
        RecipeTableModel model = (RecipeTableModel)recipeTable.getModel();
        if (!query.trim().equals("")) {
            model.searchFor(searchField.getText());
        } else {
            model.refresh();
        }
    public ShoppingList addSelectedList() {
        //return selected shopping list from combobox
        ShoppingList selectedList = (ShoppingList) listComboBox.getSelectedItem();
        return selectedList;
    }

    //private void listNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
    //   // TODO add your handling code here:
    //  ShoppingList shoppingList = (ShoppingList) listComboBox.getSelectedItem();
    // searchField.setText(shoppingList.getName());
    //}
    private Item getSelectedItem() {
        // return selected item from shopping list
        Item item = (Item) (itemList.getModel().getElementAt(selectedItem));
        return item;
    }
    
    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            this.searchForRecipeFromField();
    }//GEN-LAST:event_searchFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        WebLookAndFeel.install();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addListButton;
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JLabel addRecipeLabel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox finishedCheckBox;
    private javax.swing.JList itemList;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton listAddButton;
    private javax.swing.JComboBox<ShoppingList> listComboBox;
    private javax.swing.JLabel listDateLabel;
    private javax.swing.JButton listEditButton;
    private javax.swing.JTextField listNameField;
    private javax.swing.JLabel listNameLabel;
    private javax.swing.JButton listPurchasedButton;
    private javax.swing.JButton listRemoveButton;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JLabel listStatusLabel;
    private javax.swing.JPanel listsPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JList<Product> productList;
    private javax.swing.JPanel productPanel;
    private javax.swing.JScrollPane productScrollPane;
    private javax.swing.JCheckBox purchasedCheckBox;
    private javax.swing.JPanel recipePanel;
    private javax.swing.JScrollPane recipeScrollPane;
    private javax.swing.JTable recipeTable;
    private javax.swing.JTextField recipeUrlTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchProductButton;
    private javax.swing.JTextField searchProductField;
    private javax.swing.JLabel searchRecipeLabel;
    private javax.swing.JTabbedPane tabbedPane;
    private com.alee.extended.date.WebDateField webDateField2;
    // End of variables declaration//GEN-END:variables
}
