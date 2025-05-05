package io.cjbdevlabs.library;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class CategoryService {

    @Transactional
    public void createCategory() {
        var primaryCategory = new Category();
        primaryCategory.setName("Horror");

        var subCategory1 = new Category();
        subCategory1.setName("Psychological Horror");
        subCategory1.setPrimaryCategory(primaryCategory);

        var subCategory2 = new Category();
        subCategory2.setName("Slasher");
        subCategory2.setPrimaryCategory(primaryCategory);

        var subCategory3 = new Category();
        subCategory3.setName("Monster");
        subCategory3.setPrimaryCategory(primaryCategory);

        subCategory1.persist();
        subCategory2.persist();
        subCategory3.persist();
    }

    @Transactional
    public void retrieveCategories() {
        Category primaryCategory = Category.find("name", "Horror").firstResult();
        log.infof("primary category is : %s", primaryCategory.getName());
        primaryCategory.getSubCategories().forEach(subCategory -> log.infof("sub category is : %s", subCategory.getName()));
    }
}
