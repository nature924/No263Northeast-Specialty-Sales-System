package com.entity.model;

import com.entity.NonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NonghuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 农户编号
     */
    private String nonghuUuidNumber;


    /**
     * 农户姓名
     */
    private String nonghuName;


    /**
     * 农户手机号
     */
    private String nonghuPhone;


    /**
     * 农户身份证号
     */
    private String nonghuIdNumber;


    /**
     * 农户照片
     */
    private String nonghuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 农户邮箱
     */
    private String nonghuEmail;


    /**
     * 余额
     */
    private Double newMoney;


    /**
     * 账户状态
     */
    private Integer jinyongTypes;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：农户编号
	 */
    public String getNonghuUuidNumber() {
        return nonghuUuidNumber;
    }


    /**
	 * 设置：农户编号
	 */
    public void setNonghuUuidNumber(String nonghuUuidNumber) {
        this.nonghuUuidNumber = nonghuUuidNumber;
    }
    /**
	 * 获取：农户姓名
	 */
    public String getNonghuName() {
        return nonghuName;
    }


    /**
	 * 设置：农户姓名
	 */
    public void setNonghuName(String nonghuName) {
        this.nonghuName = nonghuName;
    }
    /**
	 * 获取：农户手机号
	 */
    public String getNonghuPhone() {
        return nonghuPhone;
    }


    /**
	 * 设置：农户手机号
	 */
    public void setNonghuPhone(String nonghuPhone) {
        this.nonghuPhone = nonghuPhone;
    }
    /**
	 * 获取：农户身份证号
	 */
    public String getNonghuIdNumber() {
        return nonghuIdNumber;
    }


    /**
	 * 设置：农户身份证号
	 */
    public void setNonghuIdNumber(String nonghuIdNumber) {
        this.nonghuIdNumber = nonghuIdNumber;
    }
    /**
	 * 获取：农户照片
	 */
    public String getNonghuPhoto() {
        return nonghuPhoto;
    }


    /**
	 * 设置：农户照片
	 */
    public void setNonghuPhoto(String nonghuPhoto) {
        this.nonghuPhoto = nonghuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：农户邮箱
	 */
    public String getNonghuEmail() {
        return nonghuEmail;
    }


    /**
	 * 设置：农户邮箱
	 */
    public void setNonghuEmail(String nonghuEmail) {
        this.nonghuEmail = nonghuEmail;
    }
    /**
	 * 获取：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：余额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 设置：账户状态
	 */
    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
