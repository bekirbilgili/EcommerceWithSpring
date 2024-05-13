package bb.ecommercewithspring.api;

import bb.ecommercewithspring.business.abstracts.ICategoryService;
import bb.ecommercewithspring.config.modelMapper.IModelMapperService;
import bb.ecommercewithspring.config.result.ResultData;
import bb.ecommercewithspring.config.result.ResultHelper;
import bb.ecommercewithspring.dto.request.category.CategorySaveRequest;
import bb.ecommercewithspring.dto.response.category.CategoryResponse;
import bb.ecommercewithspring.entity.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forResponse().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);

        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class);
        return ResultHelper.created(categoryResponse);
    }
}
