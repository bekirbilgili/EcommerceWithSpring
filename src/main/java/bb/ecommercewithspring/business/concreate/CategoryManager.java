package bb.ecommercewithspring.business.concreate;

import bb.ecommercewithspring.business.abstracts.ICategoryService;
import bb.ecommercewithspring.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {


    @Override
    public Category save(Category category) {
        return null;
    }
}
