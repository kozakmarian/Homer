package sk.upjs.paz1c.homer;

import com.alee.extended.image.DisplayType;
import com.alee.extended.image.WebImage;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.list.WebList;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.scroll.WebScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.Recipe;
import sk.upjs.paz1c.homer.model.RecipeItemListModel;

/**
 *
 * @author dyske
 */
public class RecipePanel extends JPanel {

    private final JLabel cookingLabel = new WebLabel("Úprava: ");
    private final JPanel imagePanel = new WebPanel();
    private final JPanel infoPanel = new WebPanel();
    private final JPanel instructionsPanel = new WebPanel();
    private final JLabel ingredientsLabel = new WebLabel("Ingrediencie:");
    private final JLabel instructionsLabel = new WebLabel("Postup:");
    private final JLabel portionsLabel = new WebLabel("Počet porcií: ");
    private final JLabel preparationLabel = new  WebLabel("Príprava: ");
    private final JLabel cookingDurationLabel = new WebLabel();
    private final JLabel preparationDurationLabel = new WebLabel();
    private final JLabel portionsCountLabel = new WebLabel();
    private final JLabel recipeNameLabel = new WebLabel();
    private JList recipeItemList = new WebList();
//    private JLabel instruction = new WebLabel();
    private WebImage recipeImage;
    private List<JLabel> instructions = new ArrayList<>();
    private JScrollPane recipeItemListScrollPane;
    private JScrollPane detailScrollPane;
   
    private final Recipe recipe;
    
    public RecipePanel(Recipe recipe) {
        this.recipe  = recipe;
        this.initComponents();
        this.setComponentContents();
        recipeItemList = new WebList(new RecipeItemListModel(recipe));
        for (String instruction : recipe.getInstructions().split("\n")) {
            instructions.add(new JLabel(instruction));
        }
    }

    private void setComponentContents() {
        recipeNameLabel.setText(recipe.getName());
        portionsCountLabel.setText(recipe.getPortions().toString());
        preparationDurationLabel.setText(recipe.getPreparation().toString());
        cookingDurationLabel.setText(recipe.getCooking().toString());
        
        recipeImage.setDisplayType(DisplayType.fitComponent);
        recipeImage.setPreferredSize(imagePanel.getMaximumSize());
    }

    private void initComponents() {
        try {
            File f = FileStorage.getFile(
                        "recipe" + recipe.getId() + ".jpg",
                        new URL(recipe.getImage())
                    );
            recipeImage = new WebImage(ImageIO.read(f));
        } catch (IOException e) {
            System.err.println(recipe.getImage());
        }
        detailScrollPane = new WebScrollPane(recipeImage); //instructionsEditorPane
        recipeNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recipeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE/2, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recipeImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE/2, 254, Short.MAX_VALUE)
        );

        instructionsLabel.setText("Postup");

//        instruction.setText("Instrukcia 1");
        
        recipeItemListScrollPane = new WebScrollPane(recipeItemList);
        recipeItemList.setModel(new RecipeItemListModel(recipe));
        recipeItemList.setCellRenderer(new RecipeItemListCellRenderer());

        ingredientsLabel.setText("Ingrediencie:");

        
        javax.swing.GroupLayout instructionsPanelLayout = new javax.swing.GroupLayout(instructionsPanel);
        
        // Meh kto povedal ze to nemozem upravovat xD
        GroupLayout.SequentialGroup instructionsGroupHorizontal = instructionsPanelLayout.createSequentialGroup();
        for (JLabel l : instructions) instructionsGroupHorizontal.addComponent(l).addGap(0, 0, Short.MAX_VALUE);
        
        GroupLayout.SequentialGroup instructionsGroupVertical = instructionsPanelLayout.createSequentialGroup();
        instructionsGroupVertical.addContainerGap()
                .addComponent(ingredientsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recipeItemListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED);
        for (JLabel l : instructions) instructionsGroupVertical.addComponent(l).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        
        instructionsPanel.setLayout(instructionsPanelLayout);
        instructionsPanelLayout.setHorizontalGroup(
            instructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionsGroupHorizontal)
            .addComponent(recipeItemListScrollPane)
            .addGroup(instructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(instructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instructionsLabel)
                    .addComponent(ingredientsLabel))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        instructionsPanelLayout.setVerticalGroup(
            instructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionsGroupVertical)
        );

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(recipeNameLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(portionsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(portionsCountLabel))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(preparationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addComponent(preparationDurationLabel))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(cookingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cookingDurationLabel))))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recipeNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portionsLabel)
                    .addComponent(portionsCountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preparationLabel)
                    .addComponent(preparationDurationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cookingLabel)
                    .addComponent(cookingDurationLabel))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(instructionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
