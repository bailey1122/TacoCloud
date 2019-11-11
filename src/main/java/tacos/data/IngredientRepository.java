package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

public interface IngredientRepository
            extends CrudRepository<Ingredient, String> {     // spring data jpa

//    Iterable<Ingredient> findAll();
//    Ingredient findOne(String id);
//    Ingredient save(Ingredient ingredient);
}
