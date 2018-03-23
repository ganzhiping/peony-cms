package com.peony.peonydata.popular.controller;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.popular.model.Popular;
import com.peony.peonydata.popular.service.PopularService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */
@Controller
@RequestMapping("/popular")
public class PopularController extends BaseController {
    @Autowired
    private PopularService popularService;
    @Autowired
    private UserService userService;
    @Autowired
    private IdService idService;
    @RequestMapping("/popularList")
    public ModelAndView popularList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/popular/list_popular");
        return mv;
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
    @ResponseBody
    public Pagination<Popular> selectByPage(@ModelAttribute("popular") Popular popular,
                                            HttpServletRequest request) {
        popular.setPageParameter(getpagePageParameter());
        Pagination<Popular> pagination = this.popularService.selectByPage(popular);
        request.setAttribute("list", pagination);
        return pagination;
    }

    @RequestMapping(value = "/addPopular")
    public ModelAndView addPopular(){
        ModelAndView mv = new ModelAndView("/popular/add_popular");
        return mv;
    }

    @RequestMapping(value = "/savePopular", method = { RequestMethod.POST })
    @ResponseBody
    public String savePopular(HttpServletRequest request, Popular popular, HttpServletResponse response) {
        popular.setUploadTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        int pe_t_popular = idService.NextKey("pe_t_popular");
        popular.setPopularId(pe_t_popular);
        popular.setIsDelete(0);
       // popular.setChangeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        popularService.insert(popular);
        return "";
    }

    @RequestMapping(value = "/deletePopular")
    @ResponseBody
    public String deletePubInfo(@RequestParam(value = "popularId", required = true) int id) {
        this.popularService.deleteByPrimaryKey(id);
        return "";
    }

    @RequestMapping(value = "/editPopular")
    public ModelAndView editPubInfo(@RequestParam(value = "popularId", required = true) int popularId) {
        ModelAndView mv=new ModelAndView();
        Popular popular=this.popularService.selectByPrimaryKey(popularId);
        popular.setPopularId(popularId);
        mv.addObject("popular", popular);
        mv.setViewName("popular/edit_popular");
        return mv;
    }

    @RequestMapping(value = "/updatePopular", method = RequestMethod.POST)
    @ResponseBody
    public String updatePubInfo(HttpServletRequest request, Popular popular,HttpServletResponse response) {
        this.popularService.updateByPrimaryKey(popular);
        return "";
    }


    @RequestMapping("/userList")
    public @ResponseBody List<User> userList(){
        User user = new User();
        user.setUserStatus("1");
        List<User> list = userService.selectByPopular(user);
        return list;
    }

}
