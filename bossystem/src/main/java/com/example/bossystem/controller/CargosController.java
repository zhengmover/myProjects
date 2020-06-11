package com.example.bossystem.controller;


import com.example.bossystem.pojo.GoodsInfo;
import com.example.bossystem.pojo.PurchaseInfo;
import com.example.bossystem.pojo.Supplier;
import com.example.bossystem.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller//进出货管理
public class CargosController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/admin/CargosManage")
    public String toCargosManage(Model model){
        return "admin/showStock";
    }

    //展示货物情况
    @RequestMapping("/admin/showCargos")
    @ResponseBody
    public List<GoodsInfo> showCargos(){

        List<GoodsInfo> goodsInfos = goodsService.getAllGoodsInfo();
        return goodsInfos;
    }

    //展示供应商页面
    @RequestMapping("/admin/showSupplier")
    public String showSupplier(Model model){
        List<Supplier> suppliers = goodsService.getAllSuppliers();
        model.addAttribute("infos",suppliers);
        return "admin/supplier";
    }

    @RequestMapping("/admin/purchase")
    public String purchase(Model model){
        List<GoodsInfo> goodsInfos = goodsService.getAllGoodsInfo();
        List<Supplier> suppliers = goodsService.getAllSuppliers();
        model.addAttribute("goodsInfos",goodsInfos);
        model.addAttribute("suppliers",suppliers);
        return "admin/purchase";
    }

    //处理入库商品信息
    @RequestMapping("/admin/checkIn")
    @ResponseBody
    public String handlePurchase(PurchaseInfo info){
        int flag = goodsService.addPurchaseInfo(info);
        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }

    @RequestMapping("/admin/purchaseInfo")
    public String showPurchaseInfo(Model model){
        List<PurchaseInfo> infos = goodsService.getAllPurchaseInfo();
        model.addAttribute("infos",infos);
        return "admin/showPurchaseInfo";
    }
}
