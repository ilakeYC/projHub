package com.hub.web.util;

import com.hub.model.AccessToken;
import com.hub.model.WxUserInfo;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author ilakeyc
 * @since 2017/3/24
 */
public class WxAuthorizationUtilsTest {

    @Test
    public void mainTest() {

        boolean error = WxAuthorizationUtils.hasError("{ \n" +
                "\"openid\":\"OPENID\",\n" +
                "\"nickname\":\"NICKNAME\",\n" +
                "\"sex\":1,\n" +
                "\"province\":\"PROVINCE\",\n" +
                "\"city\":\"CITY\",\n" +
                "\"country\":\"COUNTRY\",\n" +
                "\"headimgurl\": \"http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0\",\n" +
                "\"privilege\":[\n" +
                "\"PRIVILEGE1\", \n" +
                "\"PRIVILEGE2\"\n" +
                "],\n" +
                "\"unionid\": \" o6_bmasdasdsad6_2sgVt7hMZOPfL\"\n" +
                "\n" +
                "}");

        Gson g = new Gson();
        WxUserInfo result = g.fromJson("{ \n" +
                "\"openid\":\"OPENID\",\n" +
                "\"nickname\":\"NICKNAME\",\n" +
                "\"sex\":1,\n" +
                "\"province\":\"PROVINCE\",\n" +
                "\"city\":\"CITY\",\n" +
                "\"country\":\"COUNTRY\",\n" +
                "\"headimgurl\": \"http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0\",\n" +
                "\"privilege\":[\n" +
                "\"PRIVILEGE1\", \n" +
                "\"PRIVILEGE2\"\n" +
                "],\n" +
                "\"unionid\": \" o6_bmasdasdsad6_2sgVt7hMZOPfL\"\n" +
                "\n" +
                "}", WxUserInfo.class);

        Assert.assertTrue(1 == result.getSex());
        Assert.assertTrue(!result.getPrivilege().isEmpty());

        AccessToken accessToken = WxAuthorizationUtils.parseAccessToken("{ \n" +
                "\"access_token\":\"ACCESS_TOKEN\", \n" +
                "\"expires_in\":7200, \n" +
                "\"refresh_token\":\"REFRESH_TOKEN\",\n" +
                "\"openid\":\"OPENID\", \n" +
                "\"scope\":\"SCOPE\",\n" +
                "\"unionid\": \"o6_bmasdasdsad6_2sgVt7hMZOPfL\"\n" +
                "}");
        Assert.assertNotNull("accessToken is null", accessToken);
    }
}