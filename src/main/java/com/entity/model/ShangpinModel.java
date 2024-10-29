package com.entity.model;

import com.entity.ShangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 农户
     */
    private Integer nonghuId;


    /**
     * 商品名称
     */
    private String shangpinName;


    /**
     * 商品编号
     */
    private String shangpinUuidNumber;


    /**
     * 商品照片
     */
    private String shangpinPhoto;


    /**
     * 原产地
     */
    private String shangpinAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 商品类型
     */
    private Integer shangpinTypes;


    /**
     * 二级类型
     */
    private Integer shangpinErjiTypes;


    /**
     * 帮扶产品
     */
    private Integer bangfuTypes;


    /**
     * 商品库存
     */
    private Integer shangpinKucunNumber;


    /**
     * 购买获得积分
     */
    private Integer shangpinPrice;


    /**
     * 商品原价
     */
    private Double shangpinOldMoney;


    /**
     * 现价/积分
     */
    private Double shangpinNewMoney;


    /**
     * 所属仓库
     */
    private String shangpinCangku;


    /**
     * 商品热度
     */
    private Integer shangpinClicknum;


    /**
     * 商品介绍
     */
    private String shangpinContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer shangpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：农户
	 */
    public Integer getNonghuId() {
        return nonghuId;
    }


    /**
	 * 设置：农户
	 */
    public void setNonghuId(Integer nonghuId) {
        this.nonghuId = nonghuId;
    }
    /**
	 * 获取：商品名称
	 */
    public String getShangpinName() {
        return shangpinName;
    }


    /**
	 * 设置：商品名称
	 */
    public void setShangpinName(String shangpinName) {
        this.shangpinName = shangpinName;
    }
    /**
	 * 获取：商品编号
	 */
    public String getShangpinUuidNumber() {
        return shangpinUuidNumber;
    }


    /**
	 * 设置：商品编号
	 */
    public void setShangpinUuidNumber(String shangpinUuidNumber) {
        this.shangpinUuidNumber = shangpinUuidNumber;
    }
    /**
	 * 获取：商品照片
	 */
    public String getShangpinPhoto() {
        return shangpinPhoto;
    }


    /**
	 * 设置：商品照片
	 */
    public void setShangpinPhoto(String shangpinPhoto) {
        this.shangpinPhoto = shangpinPhoto;
    }
    /**
	 * 获取：原产地
	 */
    public String getShangpinAddress() {
        return shangpinAddress;
    }


    /**
	 * 设置：原产地
	 */
    public void setShangpinAddress(String shangpinAddress) {
        this.shangpinAddress = shangpinAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：商品类型
	 */
    public Integer getShangpinTypes() {
        return shangpinTypes;
    }


    /**
	 * 设置：商品类型
	 */
    public void setShangpinTypes(Integer shangpinTypes) {
        this.shangpinTypes = shangpinTypes;
    }
    /**
	 * 获取：二级类型
	 */
    public Integer getShangpinErjiTypes() {
        return shangpinErjiTypes;
    }


    /**
	 * 设置：二级类型
	 */
    public void setShangpinErjiTypes(Integer shangpinErjiTypes) {
        this.shangpinErjiTypes = shangpinErjiTypes;
    }
    /**
	 * 获取：帮扶产品
	 */
    public Integer getBangfuTypes() {
        return bangfuTypes;
    }


    /**
	 * 设置：帮扶产品
	 */
    public void setBangfuTypes(Integer bangfuTypes) {
        this.bangfuTypes = bangfuTypes;
    }
    /**
	 * 获取：商品库存
	 */
    public Integer getShangpinKucunNumber() {
        return shangpinKucunNumber;
    }


    /**
	 * 设置：商品库存
	 */
    public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
        this.shangpinKucunNumber = shangpinKucunNumber;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getShangpinPrice() {
        return shangpinPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setShangpinPrice(Integer shangpinPrice) {
        this.shangpinPrice = shangpinPrice;
    }
    /**
	 * 获取：商品原价
	 */
    public Double getShangpinOldMoney() {
        return shangpinOldMoney;
    }


    /**
	 * 设置：商品原价
	 */
    public void setShangpinOldMoney(Double shangpinOldMoney) {
        this.shangpinOldMoney = shangpinOldMoney;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getShangpinNewMoney() {
        return shangpinNewMoney;
    }


    /**
	 * 设置：现价/积分
	 */
    public void setShangpinNewMoney(Double shangpinNewMoney) {
        this.shangpinNewMoney = shangpinNewMoney;
    }
    /**
	 * 获取：所属仓库
	 */
    public String getShangpinCangku() {
        return shangpinCangku;
    }


    /**
	 * 设置：所属仓库
	 */
    public void setShangpinCangku(String shangpinCangku) {
        this.shangpinCangku = shangpinCangku;
    }
    /**
	 * 获取：商品热度
	 */
    public Integer getShangpinClicknum() {
        return shangpinClicknum;
    }


    /**
	 * 设置：商品热度
	 */
    public void setShangpinClicknum(Integer shangpinClicknum) {
        this.shangpinClicknum = shangpinClicknum;
    }
    /**
	 * 获取：商品介绍
	 */
    public String getShangpinContent() {
        return shangpinContent;
    }


    /**
	 * 设置：商品介绍
	 */
    public void setShangpinContent(String shangpinContent) {
        this.shangpinContent = shangpinContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShangpinDelete() {
        return shangpinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShangpinDelete(Integer shangpinDelete) {
        this.shangpinDelete = shangpinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
