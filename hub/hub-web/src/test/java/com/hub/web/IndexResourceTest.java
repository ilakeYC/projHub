package com.hub.web;

import com.hub.model.Course;
import com.hub.model.Instructor;
import com.hub.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ilakeyc
 * @since 2017/3/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class IndexResourceTest {

    @Resource
    private IndexResource indexResource;

    @Test
    public void mainTest() {
        Pair<Integer, List<Course>> banner = indexResource.getBannerCourses();
        Pair<Integer, List<Course>> exp = indexResource.getExpCourses();
        Pair<Integer, List<Course>> hot = indexResource.getHotCourses();
        Pair<Integer, List<Instructor>> instructor = indexResource.getStarInstructors();

        Assert.assertNotNull(banner);
        Assert.assertNotNull(exp);
        Assert.assertNotNull(hot);
        Assert.assertNotNull(instructor);
    }

}