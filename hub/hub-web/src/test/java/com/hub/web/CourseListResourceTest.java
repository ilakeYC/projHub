package com.hub.web;

import com.hub.Constants;
import com.hub.dao.BaseDao;
import com.hub.dao.EntityDao;
import com.hub.dao.mapper.CourseRowMapper;
import com.hub.model.Course;
import com.hub.util.PageNumberUtils;
import com.hub.util.Pair;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ilakeyc
 * @since 2017/3/29
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class CourseListResourceTest {

    @Resource
    private EntityDao entityDao;

    @Test
    public void lce() throws Exception {

        lce(1, 0, null, null);

        lce(1, 105, null, null);

        lce(1, 0, "ing", null);

        lce(1, 0, "over", null);

        lce(1, 0, "will", null);

        lce(1, 0, null, "n2o");
    }

    private List<Course> lce(int page, long categoryId, String when, String sort) {

        page = page > 0 ? page : 1;

        Map<Pair<String, String>, Object> offsets = new HashMap<Pair<String, String>, Object>();
        Map<String, Object> condition = new HashMap<String, Object>();

        String orderBy = "launchTime";
        String orderOption = BaseDao.ORDER_OPTION_ASC;

        condition.put("status", Constants.STATUS_OK);
        condition.put("single", false);

        if (StringUtils.isNotEmpty(when)) {
            long currentTimeMillis = System.currentTimeMillis();
            if ("ing".equals(when)) {
                offsets.put(new Pair<String, String>("endTime", BaseDao.ORDER_OPTION_ASC), currentTimeMillis);
                offsets.put(new Pair<String, String>("launchTime", BaseDao.ORDER_OPTION_DESC), currentTimeMillis);
            } else if ("will".equals(when)) {
                offsets.put(new Pair<String, String>("launchTime", BaseDao.ORDER_OPTION_ASC), currentTimeMillis);
            } else if ("over".equals(when)) {
                offsets.put(new Pair<String, String>("endTime", BaseDao.ORDER_OPTION_DESC), currentTimeMillis);
            }
        }

        if (categoryId != 0) {
            condition.put("categoryId", categoryId);
        }

        if (StringUtils.isNotEmpty(sort)) {
            if ("n2o".equals(sort)) {
                orderBy = "createTime";
                orderOption = BaseDao.ORDER_OPTION_DESC;
            }
        }

        List<Course> courseList = entityDao.findByOffset("course", condition, offsets, orderBy, orderOption, page, 6, CourseRowMapper.getInstance());

        long count = entityDao.countByOffset("course", condition, offsets);

        Pair<List<Integer>, Integer> pages = PageNumberUtils.generate(page, count, 6);

        return courseList;
    }

}