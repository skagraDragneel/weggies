package com.main.weggies;

import com.main.weggies.model.product.Product;
import com.main.weggies.model.recipe.Ingredient;
import com.main.weggies.model.recipe.Recipe;
import com.main.weggies.wegmans.ProductClient;
import com.main.weggies.wegmans.RecipeClient;

import java.lang.reflect.Array;

public class RecipeKeyGen {
    private Array reciReg;

    public RecipeKeyGen(long id, int store){
        //For each ingredient, look at the sku and find the product from that sku
        // generate key from each product (or take pregenerated one) and apply bitwise operation
        // To all of these prodcuts to get a recipe key
        boolean[] reciReg = {true, true, true, true, true, true, true, true, true};
        RecipeClient recipeClient = new RecipeClient();
        ProductClient productClient = new ProductClient(store);
        for (Recipe recipe : recipeClient.getRecipes()){
            for(Ingredient ingredient : recipe.getIngredients()){
                Product product = productClient.getProductById(ingredient.getSku());
                boolean[] prodKey = new ProdcutKeyGen(product).getKey();
                for(int i = 0; i < 8; i ++) {
                    if (reciReg[i] == true && prodKey[i] == false) {
                        reciReg[i] = false;
                    }
                }

                }

            }
        }
}
