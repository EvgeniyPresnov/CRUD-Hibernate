package ru.home.service.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.home.service.BookGenreTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(OneToOneMapping.class)
@Suite.SuiteClasses({BookGenreTest.class})
public class OneToOneMappingTestSuite {
}
