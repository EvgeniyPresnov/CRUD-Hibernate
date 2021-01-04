package ru.home.service.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.home.service.BookShopTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(ManyToManyMapping.class)
@Suite.SuiteClasses({BookShopTest.class})
public class ManyToManyMappingTestSuite {
}
