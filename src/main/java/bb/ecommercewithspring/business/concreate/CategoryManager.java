package bb.ecommercewithspring.business.concreate;

import bb.ecommercewithspring.business.abstracts.ICategoryService;
import bb.ecommercewithspring.dao.CategoryRepo;
import bb.ecommercewithspring.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }
}
