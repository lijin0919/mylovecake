package com.controller.admin;

import com.entity.*;
import com.google.gson.Gson;
import com.service.GoodsImpl;
import com.service.GoodsTypesImpl;
import com.service.TopServiceImpl;
import com.util.statusSet;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
public class adminGoodsListConntroller {
    @Autowired
    private GoodsImpl goodsImpl;
    @Autowired
    private HttpSession session;
    @Autowired
    private TopServiceImpl topService;
    @Autowired
    private GoodsTypesImpl goodsTypes;
    @Autowired
    private ServletContext servletContext;

    /**
     * 后台商品管理页面商品分页展示映射（第一页）
     * @return
     */
    @GetMapping("/GoodsList")
    public String GoodsList() {
        //总页数
        Integer totalPage = null;
        //创建一个新的商品页面类
        GoodsPage goodsPage = new GoodsPage();
        //设置当前页为第一页
        goodsPage.setCurrentPage(1);
        //获取总页面
        if ((goodsImpl.getGoodsTotalNum() % Util.GOODSNUMINPAGE) == 0) {
            totalPage = goodsImpl.getGoodsTotalNum() / Util.GOODSNUMINPAGE;
        } else {
            totalPage = goodsImpl.getGoodsTotalNum() / Util.GOODSNUMINPAGE + 1;
        }
        //设置每页展示的商品数量
        goodsPage.setGoodsNumInPage(Util.GOODSNUMINPAGE);
        //设置总页数
        goodsPage.setTotalPage(totalPage);
        //实例化一个单页所有商品类
        List<Goods> goodsList = new ArrayList<Goods>();
        //数据库分页查询当前页需要的商品
        goodsList = goodsImpl.getGoodListByCurrentPagAndGoodsNum(0, Util.GOODSNUMINPAGE);
        //获取推荐商品，热销商品，新品的集合
        List<Top> topList = topService.getTopList();
        //与tops标对比，设置当前页商品商品的setTopScroll（是否是条幅商品）、setTopLarge（是否是热销商品）、setTopSmall（是否是新品）属性
        goodsList = statusSet.goodsListSet(goodsList, topList);
        goodsPage.setGoodsList(goodsList);
        session.setAttribute("goodsPage", goodsPage);
        return "adminGoodsList";
    }

    /**
     * 后台商品管理页面点击下一页上一页等对应商品商品获取映射
     * @param ccurrentPage
     * @return
     */
    @PostMapping("/PageGoodsList")
    @ResponseBody
    public String PageGoodsList(@RequestParam("Page") Integer ccurrentPage) {
        Integer totalPage = null;

        GoodsPage goodsPage = (GoodsPage) session.getAttribute("goodsPage");
        //当当前页大于0小于等于总页数时才进行商品获取
        if (ccurrentPage <= goodsPage.getTotalPage() && ccurrentPage > 0) {
            //设置当前页
            goodsPage.setCurrentPage(ccurrentPage);
            List<Goods> goodsList = new ArrayList<Goods>();
            //分页查询
            goodsList = goodsImpl.getGoodListByCurrentPagAndGoodsNum((goodsPage.getCurrentPage() - 1) * Util.GOODSNUMINPAGE, Util.GOODSNUMINPAGE);
            List<Top> topList = topService.getTopList();
            //与tops标对比，设置当前页商品商品的setTopScroll（是否是条幅商品）、setTopLarge（是否是热销商品）、setTopSmall（是否是新品）属性
            goodsList = statusSet.goodsListSet(goodsList, topList);
            goodsPage.setGoodsList(goodsList);
            session.removeAttribute("goodsPage");
            session.setAttribute("goodsPage", goodsPage);
        }
        return new Gson().toJson(goodsPage);
    }

    /**
     * 后台商品管理页面点击条幅、热销、新品对应的商品获取映射
     *
     * @param status 1表示条幅商品，2表示热销商品，3表示新品
     * @return
     */
    @PostMapping("/toTopLists")
    @ResponseBody
    public String getTopGoods(@RequestParam("status") Integer status) {
        System.out.println(status);
        List<Goods> goodsList = null;
        try {
            List<Top> topList = topService.getTopListByTypeId(status);
            goodsList = new ArrayList<Goods>();
            for (Top top : topList) {
                if (status == top.getTypeId()) {
                    System.out.println(3);
                    goodsList.add(goodsImpl.getGoodByGoodId(top.getGoodId()));
                    System.out.println(4);
                }
            }
            List<Top> topListNew = topService.getTopList();
            goodsList = statusSet.goodsListSet(goodsList, topListNew);
            System.out.println(goodsList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Gson().toJson(goodsList);
    }

    /**
     * 实现商品管理移入条幅，移入热销，移入新品等功能的映射
     *
     * @param goodId
     * @param typeId
     * @return
     */
    @PostMapping("/topSave")
    @ResponseBody
    public String topSave(@RequestParam("goodId") Integer goodId, @RequestParam("typeId") Integer typeId) {

        Integer num = null;
        try {
            num = topService.insertTop(goodId, typeId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Gson().toJson(num);
    }

    /**
     * 实现商品管理移出条幅，移出热销，移出新品等功能的映射
     *
     * @param goodId
     * @param typeId
     * @return
     */
    @PostMapping("/topDelete")
    @ResponseBody
    public String topDelete(@RequestParam("goodId") Integer goodId, @RequestParam("typeId") Integer typeId) {

        Integer num = null;
        try {
            num = topService.deleteTopByGoodIdAndType(goodId, typeId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Gson().toJson(num);
    }

    /**
     * 后台所有商品管理页面商品删除功能的映射
     *
     * @param goodId
     * @return
     */
    @PostMapping("/adminGoodDelete")
    @ResponseBody
    public String GoodDelete(@RequestParam("goodId") Integer goodId) {
        Integer num = goodsImpl.deleteGoodById(goodId);

        return new Gson().toJson(num);
    }

    /**
     * 后台推荐、热销、新品商品删除功能的映射
     *
     * @param goodId
     * @return
     */
    @PostMapping("/topGoodDelete")
    @ResponseBody
    public String topGoodDelete(@RequestParam("goodId") Integer goodId, @RequestParam("typeId") Integer typeId) {
        Integer num = topService.deleteTopByGoodIdAndType(goodId, typeId);

        return new Gson().toJson(num);
    }

    /**
     * 跳到增加商品页面
     *
     * @return
     */
    @GetMapping("/goodAdd")
    public String goodAdd() {

        List<Types> typesList = goodsTypes.getGoodTypeLIst();
        session.setAttribute("typesList", typesList);
        return "adminGoodAdd";
    }

    /**
     * 增加新的商品页面表单获取与数据库存入功能的映射
     * @param request
     * @param goodname
     * @param goodprice
     * @param goodintro
     * @param goodstock
     * @param goodtypeid
     * @param cover
     * @param image1
     * @param image2
     * @return
     */
    @PostMapping("/goodAddAction")
    public String goodAddAction(HttpServletRequest request,
                                @RequestParam("goodname") String goodname,
                                @RequestParam("goodprice") Integer goodprice,
                                @RequestParam("goodintro") String goodintro,
                                @RequestParam("goodstock") Integer goodstock,
                                @RequestParam("goodtypeid") Integer goodtypeid,
                                @RequestParam("cover") MultipartFile cover,
                                @RequestParam("image1") MultipartFile image1,
                                @RequestParam("image2") MultipartFile image2) {


        //如果文件不为空，写入上传路径
        String path = servletContext.getRealPath(Util.goodsPicturePath);
        try {
            //上传商品图片并获取图片路径名
            FileUtils.copyInputStreamToFile(cover.getInputStream(), new File(path,
                    System.currentTimeMillis() + cover.getOriginalFilename()));
            String path1 = Util.goodsPicturePath + System.currentTimeMillis() + cover.getOriginalFilename();
            FileUtils.copyInputStreamToFile(image1.getInputStream(), new File(path,
                    System.currentTimeMillis() + image1.getOriginalFilename()));
            String path2 = Util.goodsPicturePath + System.currentTimeMillis() + image1.getOriginalFilename();
            FileUtils.copyInputStreamToFile(image2.getInputStream(), new File(path,
                    System.currentTimeMillis() + image2.getOriginalFilename()));
            String path3 = Util.goodsPicturePath + System.currentTimeMillis() + image2.getOriginalFilename();
            //  将商品信息插入数据库
            Goods goods=new Goods();
            goods.setGoodCover(path1);
            goods.setGoodImage1(path2);
            goods.setGoodImage2(path3);
            goods.setGoodName(goodname);
            goods.setGoodPrice(goodprice);
            goods.setGoodIntro(goodintro);
            goods.setTypeId(goodtypeid);
            goods.setGoodStock(goodstock);
            if (goodsImpl.insertGood(goods)>0){
            return "adminGoodsList";}else {
                return "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }

    /**
     * 跳到修改商品信息页面
     *
     * @return
     */
    @GetMapping("/goodEdit")
    public String goodEdit(@RequestParam("goodId") Integer goodId) {

       Goods goods=goodsImpl.getGoodByGoodId(goodId);
        session.setAttribute("goodForEdit", goods);
        List<Types> typesList = goodsTypes.getGoodTypeLIst();
        session.setAttribute("typesList", typesList);
        return "adminGoodEdit";
    }
    /**
     * 修改商品信息页面表单获取与对应数据库内容修改功能的映射
     * @param request
     * @param goodname
     * @param goodprice
     * @param goodintro
     * @param goodstock
     * @param goodtypeid
     * @param cover
     * @param image1
     * @param image2
     * @return
     */
    @PostMapping("/goodEditAction")
    public String goodEditAction(HttpServletRequest request,
                                 @RequestParam("goodid") Integer goodid,
                                 @RequestParam("goodname") String goodname,
                                @RequestParam("goodprice") Integer goodprice,
                                @RequestParam("goodintro") String goodintro,
                                @RequestParam("goodstock") Integer goodstock,
                                @RequestParam("goodtypeid") Integer goodtypeid,
                                @RequestParam("cover") MultipartFile cover,
                                @RequestParam("image1") MultipartFile image1,
                                @RequestParam("image2") MultipartFile image2) {


        //如果文件不为空，写入上传路径
        String path = servletContext.getRealPath(Util.goodsPicturePath);
        try {
            //上传商品图片并获取图片路径名
            FileUtils.copyInputStreamToFile(cover.getInputStream(), new File(path,
                    System.currentTimeMillis() + cover.getOriginalFilename()));
            String path1 = Util.goodsPicturePath + System.currentTimeMillis() + cover.getOriginalFilename();
            FileUtils.copyInputStreamToFile(image1.getInputStream(), new File(path,
                    System.currentTimeMillis() + image1.getOriginalFilename()));
            String path2 = Util.goodsPicturePath + System.currentTimeMillis() + image1.getOriginalFilename();
            FileUtils.copyInputStreamToFile(image2.getInputStream(), new File(path,
                    System.currentTimeMillis() + image2.getOriginalFilename()));
            String path3 = Util.goodsPicturePath + System.currentTimeMillis() + image2.getOriginalFilename();
            //  将商品信息插入数据库
            Goods goods=new Goods();
            goods.setGoodId(goodid);
            goods.setGoodCover(path1);
            goods.setGoodImage1(path2);
            goods.setGoodImage2(path3);
            goods.setGoodName(goodname);
            goods.setGoodPrice(goodprice);
            goods.setGoodIntro(goodintro);
            goods.setTypeId(goodtypeid);
            goods.setGoodStock(goodstock);
            if (goodsImpl.updateGood(goods)>0){
                return "adminGoodsList";}else {
                return "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }
}

