package sk.upjs.paz1c.homer;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.text.WebEditorPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 *
 * @author dyske
 */
public class RecipePanel extends JPanel {

    private final JButton buyButton = new WebButton("Pridať do zoznamu...");
    private final JLabel cookingDurationLabel = new WebLabel();
    private final JLabel cookingLabel = new WebLabel("Úprava: ");
    private final JLabel portionsCountLabel = new WebLabel();
    private final JLabel portionsLabel = new WebLabel("Počet porcií: ");
    private final JLabel preparationDurationLabel = new WebLabel();
    private final JLabel preparationLabel = new  WebLabel("Príprava: ");
    private final JLabel recipeNameLabel = new WebLabel();
    private JEditorPane instructionsEditorPane;
    private JScrollPane detailScrollPane;
   
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
    }

    private void initComponents() {
        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(detailPanelLayout);
        instructionsEditorPane = new RecipeEditorPane(recipe);
        instructionsEditorPane.setEditable(false);
        detailScrollPane = new WebScrollPane(instructionsEditorPane);
        recipeNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailScrollPane)
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addComponent(preparationLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(preparationDurationLabel)
                                .addGap(18, 18, 18)
                                .addComponent(cookingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cookingDurationLabel)
                                .addGap(18, 18, 18)
                                .addComponent(portionsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(portionsCountLabel))))
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addComponent(recipeNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recipeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preparationLabel)
                    .addComponent(preparationDurationLabel)
                    .addComponent(cookingLabel)
                    .addComponent(cookingDurationLabel)
                    .addComponent(portionsLabel)
                    .addComponent(portionsCountLabel))
                .addGap(18, 18, 18)
                .addComponent(detailScrollPane)
                .addContainerGap())
        );
    }
}
