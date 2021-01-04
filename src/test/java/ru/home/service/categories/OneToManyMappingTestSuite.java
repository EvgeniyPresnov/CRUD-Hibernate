package ru.home.service.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.home.service.BookAuthorTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(OneToManyMapping.class)
@Suite.SuiteClasses({BookAuthorTest.class})
public class OneToManyMappingTestSuite {
}
