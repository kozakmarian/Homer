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
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ListModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.dao.ProductDao;
import sk.upjs.paz1c.homer.dao.RecipeDao;
import sk.upjs.paz1c.homer.dao.ShoppingListDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.Product;
import sk.upjs.paz1c.homer.entity.Recipe;
import sk.upjs.paz1c.homer.entity.ShoppingList;
import sk.upjs.paz1c.homer.guicomponents.ItemListCellRenderer;
import sk.upjs.paz1c.homer.guicomponents.ProductListCellRenderer;
import sk.upjs.paz1c.homer.model.ItemListModel;
import sk.upjs.paz1c.homer.model.ListComboBoxModel;
import sk.upjs.paz1c.homer.model.ProductListModel;
import sk.upjs.paz1c.homer.model.RecipeTableModel;

/**
 * Uses WebLookAndFeel (GNU GPL 3.0)
 * @see http://weblookandfeel.com/
 * @see https://www.gnu.org/licenses/gpl-3.0.html
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
    private final ShoppingListDao shoppingListDao = ObjectFactory.INSTANCE.getDao(ShoppingList.class);
    private final Dimension windowSize;
    private int selectedItem;
    private ProductListCellRenderer productListCellRenderer = new ProductListCellRenderer();
    private ItemListCellRenderer itemListCellRenderer = new ItemListCellRenderer();

    private Image iconImage = null;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() * 2 / 3;
        int height = gd.getDisplayMode().getHeight() * 2 / 2;
        windowSize = new Dimension(width, height);

        
        try {
            iconImage = ImageIO.read(ClassLoader.getSystemResource("sk/upjs/paz1c/homer/homer-icon.png"));
            setIconImage(iconImage);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, "Failed loading icon", ex);
        }
        
        initComponents();
        
        recipeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        recipeTable.setRowHeight(40);
        int[] widths = {69, 300, 100, 120, 120};
        TableColumnModel columnModel = recipeTable.getColumnModel();
        for (int i = 0; i < recipeTable.getColumnCount() - 1; i++) {
            columnModel.getColumn(i).setMinWidth(widths[i]);
            columnModel.getColumn(i).setMaxWidth(widths[i]);
        }
        columnModel.getColumn(
                ((RecipeTableModel) (recipeTable.getModel())).COLUMN_INDEX_NAME
        ).setMaxWidth(Integer.MAX_VALUE);
        recipeTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        tabbedPane.setMnemonicAt(0, KeyEvent.VK_P);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_Z);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_R);
        this.shoppingList = (ShoppingList) listComboBox.getSelectedItem();
        refreshRecipes();
        refreshItems();
        refreshProducts(20);
    }

    private void refreshRecipes() {
        RecipeTableModel model = (RecipeTableModel) recipeTable.getModel();
        model.refresh();
    }

    private void refreshProducts(int size) {
        List<Product> products = productDao.list();
        Set<Product> setProducts = new HashSet<>();
        setProducts.addAll(products);
        List<Product> result = new ArrayList<>();
        int i = 0;
        setProducts.stream().filter((add) -> (i < size)).forEachOrdered((add) -> {
            result.add(add);
        });
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
        addItem = new javax.swing.JButton();
        updateItem = new javax.swing.JButton();
        listPurchasedButton = new javax.swing.JButton();
        removeItem = new javax.swing.JButton();
        dateField = new com.alee.extended.date.WebDateField();
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
        searchProductField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductFieldKeyReleased(evt);
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
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productScrollPane)
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchProductField, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(searchProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchProductButton)
                    .addComponent(searchProductField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
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

        itemList.setFont(new java.awt.Font("Source Code Pro Medium", 0, 12)); // NOI18N
        itemList.setModel(new ItemListModel(shoppingList));
        itemList.setCellRenderer(new ItemListCellRenderer());
        itemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemListMouseClicked(evt);
            }
        });
        listScrollPane.setViewportView(itemList);

        addItem.setText("Pridať...");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        updateItem.setText("Upraviť...");
        updateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemActionPerformed(evt);
            }
        });

        listPurchasedButton.setText("Kúpené");
        listPurchasedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPurchasedButtonActionPerformed2(evt);
            }
        });

        removeItem.setText("Odstrániť");
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });

        addListButton.setText("Pridať zoznam...");
        addListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addListButtonActionPerformed(evt);
            }
        });

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
                                .addComponent(updateItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(listPurchasedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchasedCheckBox)
                    .addComponent(listStatusLabel)
                    .addComponent(finishedCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listScrollPane)
                    .addGroup(listsPanelLayout.createSequentialGroup()
                        .addComponent(addItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listPurchasedButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeItem)
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
                .addComponent(recipeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Recepty", recipePanel);

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
        //return selected shopping list from combobox
        ShoppingList selectedList = (ShoppingList) listComboBox.getSelectedItem();
        return selectedList;
    }
    
    private void listNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ShoppingList shoppingList = (ShoppingList) listComboBox.getSelectedItem();
        searchField.setText(shoppingList.getName());
    }
    
    private void listRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRemoveButtonActionPerformed
        Item item = getSelectedItem();
        itemDao.delete(item);
        refreshItems();
    }//GEN-LAST:event_listRemoveButtonActionPerformed

    private void listPurchasedButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                          
         shoppingList = (ShoppingList) listComboBox.getSelectedItem();
        ItemListModel model = (ItemListModel) itemList.getModel();
        model.refresh(shoppingList);
        Item item = getSelectedItem();
        item.setStatus(Status.DONE);
        itemDao.store(item);
        refreshItems();
    }                                                   

    private void updateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemActionPerformed
        // TODO add your handling code here:
        Item item = getSelectedItem();
        ItemDialog productDialog;
        shoppingList = addSelectedList();
        productDialog = new ItemDialog(item, shoppingList, this, true);
        productDialog.setVisible(true);
        refreshItems();
    }//GEN-LAST:event_updateItemActionPerformed

    

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_searchButtonActionPerformed

    private void addRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeButtonActionPerformed
        try {
            RecipeParser.fetchFromUrl(recipeUrlTextField.getText());
            ((RecipeTableModel) recipeTable.getModel()).refresh();
        } catch (IOException | UnsupportedOperationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addRecipeButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed


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
    private void searchProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductButtonActionPerformed
        this.loadProducts();
    }//GEN-LAST:event_searchProductButtonActionPerformed

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked
        if (evt.getClickCount() == 2) {
            int row = recipeTable.getSelectedRow();
            Recipe recipe = ((RecipeTableModel) recipeTable.getModel()).getRecipeAt(row);
            RecipePanel recipeDetailPanel = new RecipePanel(recipe);
            String recipeName = recipe.getName();
            tabbedPane.addTab(
                    recipeName.substring(0, (recipeName.length() > 16) ? 16 : recipeName.length()) + "...",
                    recipeDetailPanel
            );
            int tabIndex = tabbedPane.getTabCount() - 1;
            for (int i = 3; i < tabbedPane.getTabCount(); i++) {
                tabbedPane.setMnemonicAt(i, 46 + i);
            }

            tabbedPane.setTabComponentAt(tabIndex, new ButtonTabComponent(tabbedPane));
            tabbedPane.setSelectedComponent(recipeDetailPanel);
        }
    }//GEN-LAST:event_recipeTableMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        this.searchForRecipeFromField();
    }//GEN-LAST:event_searchButtonMouseClicked

    private void searchForRecipeFromField() {
        String query = searchField.getText();
        RecipeTableModel model = (RecipeTableModel) recipeTable.getModel();
        if (!query.trim().equals("")) {
            model.searchFor(searchField.getText());
        } else {
            model.refresh();
        }
    }

    private void listComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
     // TODO add your handling code here:
     shoppingList = (ShoppingList) listComboBox.getSelectedItem();
     refreshItems();
     
     
    }
    private Item getSelectedItem() {
        // return selected item from shopping list
        Item item = (Item) (itemList.getModel().getElementAt(selectedItem));
        return item;
    }

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.searchForRecipeFromField();
        }
    }//GEN-LAST:event_searchFieldKeyPressed

    private void listPurchasedButtonActionPerformed2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPurchasedButtonActionPerformed2
        // TODO add your handling code here
        ShoppingList shoppingList = (ShoppingList) listComboBox.getSelectedItem();
        ItemListModel model = (ItemListModel) itemList.getModel();
        model.refresh(shoppingList);

        Item item = getSelectedItem();
        item.setStatus(Status.DONE);
        refreshItems();
    }//GEN-LAST:event_listPurchasedButtonActionPerformed2

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
        // TODO add your handling code here:
         Item item = getSelectedItem();
        itemDao.delete(item);
        refreshItems();
        
    }//GEN-LAST:event_removeItemActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        ItemDialog productDialog;

        shoppingList = addSelectedList();
        productDialog = new ItemDialog(shoppingList, this, true);
        productDialog.setVisible(true);
        refreshItems();
    }//GEN-LAST:event_addItemActionPerformed

    private void itemListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemListMouseClicked
        // TODO add your handling code here:
        selectedItem = itemList.getSelectedIndex();
    }//GEN-LAST:event_itemListMouseClicked

    private void addListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addListButtonActionPerformed
        ShoppingList shoppingList;
        if (listNameField.getText() != null) {
            shoppingList = new ShoppingList();
            shoppingList.setName(listNameField.getText());
            shoppingList.setExpiry(dateField.getDate());
            shoppingListDao.store(shoppingList);
            listNameField.setText("");
            dateField.setText("");
            refreshComboBox();
        }
    }//GEN-LAST:event_addListButtonActionPerformed

    private void searchProductFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) this.loadProducts();
    }//GEN-LAST:event_searchProductFieldKeyReleased

    public void loadProducts () {
        searchProductField.setBackground(Color.white);
        String query = searchProductField.getText();
        List<Product> rawProducts = productDao.find(query);
        List<Product> products = new ArrayList<>();
        Set<String> productNames = new HashSet();
        rawProducts.stream()
                   .filter((p) -> (productNames.add(p.getName())))
                   .forEachOrdered((p) -> {products.add(p);});
        ProductListModel productListModel = (ProductListModel) productList.getModel();
        if (products.isEmpty())
            if (query.length() > 0) searchProductField.setBackground(new Color(192, 57, 43));
            else productListModel.refreshList();
        else productListModel.refreshList(products);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        WebLookAndFeel.install();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItem;
    private javax.swing.JButton addListButton;
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JLabel addRecipeLabel;
    private com.alee.extended.date.WebDateField dateField;
    private javax.swing.JCheckBox finishedCheckBox;
    private javax.swing.JList itemList;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<ShoppingList> listComboBox;
    private javax.swing.JLabel listDateLabel;
    private javax.swing.JTextField listNameField;
    private javax.swing.JLabel listNameLabel;
    private javax.swing.JButton listPurchasedButton;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JLabel listStatusLabel;
    private javax.swing.JPanel listsPanel;
    private javax.swing.JList<Product> productList;
    private javax.swing.JPanel productPanel;
    private javax.swing.JScrollPane productScrollPane;
    private javax.swing.JCheckBox purchasedCheckBox;
    private javax.swing.JPanel recipePanel;
    private javax.swing.JScrollPane recipeScrollPane;
    private javax.swing.JTable recipeTable;
    private javax.swing.JTextField recipeUrlTextField;
    private javax.swing.JButton removeItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchProductButton;
    private javax.swing.JTextField searchProductField;
    private javax.swing.JLabel searchRecipeLabel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton updateItem;
    // End of variables declaration//GEN-END:variables
}
