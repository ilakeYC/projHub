package com.hub.web;

import com.hub.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @author ilakeyc
 * @since 2017/3/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class BaseResourceTest {

    @Qualifier("indexResource")
    @Autowired
    BaseResource baseResource;

    @Test
    public void categoryTest() {
        Map<Long, Category> categoryList = baseResource.getCategories();
        System.out.println(categoryList);
        Assert.assertNotNull(categoryList);
    }
}