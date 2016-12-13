package sk.upjs.paz1c.homer.guicomponents;

import sk.upjs.paz1c.homer.guicomponents.RecipeItemListCellRenderer;
import com.alee.extended.image.DisplayType;
import com.alee.extended.image.WebImage;
import com.alee.laf.label.WebLabel;
import com.alee.laf.list.WebList;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.scroll.WebScrollPane;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import sk.upjs.paz1c.homer.FileStorage;
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
    private final JLabel instructions = new WebLabel();
    private JList recipeItemList = new WebList();
    private WebImage recipeImage;
    private JScrollPane recipeItemListScrollPane;
    private JScrollPane instructionsScrollPane;
   
    private final Recipe recipe;
    
    public RecipePanel(Recipe recipe) {
        this.recipe  = recipe;
        this.initComponents();
        this.setComponentContents();
    }

    private void setComponentContents() {
        recipeNameLabel.setText(recipe.getName());
        portionsCountLabel.setText(recipe.getPortions().toString());
        preparationDurationLabel.setText(recipe.getPreparation().toString());
        cookingDurationLabel.setText(recipe.getCooking().toString());
        
        recipeItemList = new WebList(new RecipeItemListModel(recipe));
        
        instructions.setText(
                Arrays.stream(recipe.getInstructions().split("\n"))
                        .map(i -> "<li>" + i + "</li>")
                        .collect(Collectors.joining("\n", "<html><ul style=\"margin-left:18px;\">", "</ul></html>"))
        );
        
        Dimension panelSize = this.getSize();
        instructionsPanel.setMaximumSize(new Dimension((int)(panelSize.getWidth() / 2), (int)(panelSize.getHeight() / 2)));
        recipeNameLabel.setMaximumSize(new Dimension((int)(panelSize.getWidth() / 3), (int)(panelSize.getHeight() / 3)));
        
        instructions.setMinimumSize(new Dimension((int)(panelSize.getWidth() / 2), (int)(panelSize.getHeight() / 2)));
        instructions.setPreferredSize(new Dimension((int)(panelSize.getWidth() / 2), (int)(panelSize.getHeight() / 2)));
        instructions.setMaximumSize(new Dimension((int)(panelSize.getWidth() / 2), (int)(panelSize.getHeight() / 2)));
        
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
            System.err.println("Failed to load: " + recipe.getImage());
        }
        instructionsScrollPane = new WebScrollPane(instructions);
        recipeNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        
        recipeItemListScrollPane = new WebScrollPane(recipeItemList);
        instructionsScrollPane = new WebScrollPane(instructions);   
        
        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recipeImage, javax.swing.GroupLayout.DEFAULT_SIZE, (int)(665*0.5), Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recipeImage, javax.swing.GroupLayout.DEFAULT_SIZE, (int)(374*0.5), Short.MAX_VALUE))
        );

        instructions.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        instructionsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        instructionsScrollPane.setViewportView(instructions);

        recipeItemList.setModel(new RecipeItemListModel(recipe));
        recipeItemList.setCellRenderer(new RecipeItemListCellRenderer());
        
        recipeItemListScrollPane.setViewportView(recipeItemList);

        javax.swing.GroupLayout instructionsPanelLayout = new javax.swing.GroupLayout(instructionsPanel);
        instructionsPanel.setLayout(instructionsPanelLayout);
        instructionsPanelLayout.setHorizontalGroup(
            instructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, instructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(instructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(instructionsScrollPane)
                    .addComponent(recipeItemListScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, instructionsPanelLayout.createSequentialGroup()
                        .addGroup(instructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingredientsLabel)
                            .addComponent(instructionsLabel))
                        .addGap(0, 328, Short.MAX_VALUE)))
                .addContainerGap())
        );
        instructionsPanelLayout.setVerticalGroup(
            instructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingredientsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recipeItemListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsScrollPane)
                .addContainerGap())
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(instructionsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
