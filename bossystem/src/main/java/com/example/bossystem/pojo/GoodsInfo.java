package com.example.bossystem.pojo;


public class GoodsInfo {
    private Integer id;//水果类别id
    private String gname;//水果名
    private double gprice;//水果单价（箱）
    private Integer gstock;//库存
    private String gpath;//图片存储路径


    public GoodsInfo(Integer id, String gname, double gprice, Integer gstock, String gpath) {
        this.id = id;
        this.gname = gname;
        this.gprice = gprice;
        this.gstock = gstock;
        this.gpath = gpath;
    }

    public String getGpath() {
        return gpath;
    }

    public void setGpath(String gpath) {
        this.gpath = gpath;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gstock=" + gstock +
                ", gpath='" + gpath + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }
}
