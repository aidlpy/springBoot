package com.example.demo.controller;
import com.example.demo.model.UserModel;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

//测试http协议的post,del,put请求
@RestController
public class TestController {

    private Map<String,Object> params = new HashMap<>();

    /**
     * 功能描述:测试Restful协议，从路径中获取参数
     * @param cityId
     * @param userId
     * @return
     */
    @RequestMapping(path= "/{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
                           @PathVariable("user_id") String userId){
        params.clear();
        params.put("cityId",cityId);
        params.put("userId",userId);
        return params;
    }

    /**
     * 功能描述:测试GetMapping
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value="/v1/page_user1")
    public Object pageUser(int from,int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    /**
     * 功能描述:默认值,是否必须的参数
     * @param from //下面page修饰的是from
     * @param size
     * @return
     */
    @GetMapping(value="/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "3",name="page",required = true) int from,int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    /**
     * 功能描述:bean对象转参
     * 注意:1、注意需要指定http头header内包含 content-type 为application/json
     * @param userModel
     * @return
     */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody UserModel userModel){
        params.clear();
        params.put("user",userModel);
        return params;
    }

    /**
     * 功能描述: 获取http头信息
     * @param accessToken
     * @param id
     * @return
     */
    @GetMapping("/V1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken,String id){
        params.clear();
        params.put("access_token",accessToken);
        params.put("id",id);
        return params;
    }
}
