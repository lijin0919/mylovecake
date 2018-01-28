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

    @GetMapping("/GoodsList")
    public String GoodsList() {
        Integer totalPage = null;
        GoodsPage goodsPage = new GoodsPage();
        goodsPage.setCurrentPage(1);
        if ((goodsImpl.getGoodsTotalNum() % Util.GOODSNUMINPAGE) == 0) {
            totalPage = goodsImpl.getGoodsTotalNum() / Util.GOODSNUMINPAGE;
        } else {
            totalPage = goodsImpl.getGoodsTotalNum() / Util.GOODSNUMINPAGE + 1;
        }
        goodsPage.setGoodsNumInPage(Util.GOODSNUMINPAGE);
        goodsPage.setTotalPage(totalPage);
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList = goodsImpl.getGoodListByCurrentPagAndGoodsNum(0, Util.GOODSNUMINPAGE);
        List<Top> topList = topService.getTopList();
        goodsList = statusSet.goodsListSet(goodsList, topList);
        goodsPage.setGoodsList(goodsList);
        session.setAttribute("goodsPage", goodsPage);
        return "adminGoodsList";
    }

    @PostMapping("/PageGoodsList")
    @ResponseBody
    public String PageGoodsList(@RequestParam("Page") Integer ccurrentPage) {
        Integer totalPage = null;

        GoodsPage goodsPage = (GoodsPage) session.getAttribute("goodsPage");
        if (ccurrentPage <= goodsPage.getTotalPage() && ccurrentPage > 0) {
            goodsPage.setCurrentPage(ccurrentPage);
            List<Goods> goodsList = new ArrayList<Goods>();
            goodsList = goodsImpl.getGoodListByCurrentPagAndGoodsNum((goodsPage.getCurrentPage() - 1) * Util.GOODSNUMINPAGE, Util.GOODSNUMINPAGE);
            List<Top> topList = topService.getTopList();
            goodsList = statusSet.goodsListSet(goodsList, topList);
            goodsPage.setGoodsList(goodsList);
            session.removeAttribute("goodsPage");
            session.setAttribute("goodsPage", goodsPage);
        }
        return new Gson().toJson(goodsPage);
    }

    /**
     * 后台条幅热销新品商品的管理
     *
     * @param status
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
     * 实现商品管理移入条幅等功能
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
     * 实现商品管理移出条幅等功能
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
     * 后台商品删除
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
     * 推荐热销新品商品删除
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
     * 增加新的商品
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
     * 修改商品信息
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

