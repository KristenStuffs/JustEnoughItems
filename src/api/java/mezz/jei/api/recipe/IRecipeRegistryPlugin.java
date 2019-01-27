package mezz.jei.api.recipe;

import java.util.List;

import net.minecraft.util.ResourceLocation;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.category.IRecipeCategory;

/**
 * Recipe Registry Plugins are used by the {@link IRecipeRegistry} to look up recipes.
 * JEI has its own internal plugin, which uses information from {@link IRecipeCategory} to look up recipes.
 * Implementing your own Recipe Registry Plugin offers total control of lookups, but it must be fast.
 *
 * Add your plugin with {@link IModRegistry#addRecipeRegistryPlugin(IRecipeRegistryPlugin)}
 */
public interface IRecipeRegistryPlugin {
	/**
	 * Returns a list of Recipe Categories offered for the focus.
	 * This is used internally by JEI to implement {@link IRecipeRegistry#getRecipeCategories(IFocus)}.
	 */
	<V> List<ResourceLocation> getRecipeCategoryUids(IFocus<V> focus);

	/**
	 * Returns a list of Recipe Wrappers in the recipeCategory that have the focus.
	 * This is used internally by JEI to implement {@link IRecipeRegistry#getRecipes(IRecipeCategory, IFocus)}.
	 */
	<T, V> List<T> getRecipes(IRecipeCategory<T> recipeCategory, IFocus<V> focus);

	/**
	 * Returns a list of all Recipe Wrappers in the recipeCategory.
	 * This is used internally by JEI to implement {@link IRecipeRegistry#getRecipes(IRecipeCategory)}.
	 */
	<T> List<T> getRecipes(IRecipeCategory<T> recipeCategory);
}