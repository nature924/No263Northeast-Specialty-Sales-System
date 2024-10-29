package com.entity.vo;

import com.entity.NonghuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nonghu")
public class NonghuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 农户编号
     */

    @TableField(value = "nonghu_uuid_number")
    private String nonghuUuidNumber;


    /**
     * 农户姓名
     */

    @TableField(value = "nonghu_name")
    private String nonghuName;


    /**
     * 农户手机号
     */

    @TableField(value = "nonghu_phone")
    private String nonghuPhone;


    /**
     * 农户身份证号
     */

    @TableField(value = "nonghu_id_number")
    private String nonghuIdNumber;


    /**
     * 农户照片
     */

    @TableField(value = "nonghu_photo")
    private String nonghuPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 农户邮箱
     */

    @TableField(value = "nonghu_email")
    private String nonghuEmail;


    /**
     * 余额
     */

    @TableField(value = "new_money")
    private Double newMoney;


    /**
     * 账户状态
     */

    @TableField(value = "jinyong_types")
    private Integer jinyongTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：农户编号
	 */
    public String getNonghuUuidNumber() {
        return nonghuUuidNumber;
    }


    /**
	 * 获取：农户编号
	 */

    public void setNonghuUuidNumber(String nonghuUuidNumber) {
        this.nonghuUuidNumber = nonghuUuidNumber;
    }
    /**
	 * 设置：农户姓名
	 */
    public String getNonghuName() {
        return nonghuName;
    }


    /**
	 * 获取：农户姓名
	 */

    public void setNonghuName(String nonghuName) {
        this.nonghuName = nonghuName;
    }
    /**
	 * 设置：农户手机号
	 */
    public String getNonghuPhone() {
        return nonghuPhone;
    }


    /**
	 * 获取：农户手机号
	 */

    public void setNonghuPhone(String nonghuPhone) {
        this.nonghuPhone = nonghuPhone;
    }
    /**
	 * 设置：农户身份证号
	 */
    public String getNonghuIdNumber() {
        return nonghuIdNumber;
    }


    /**
	 * 获取：农户身份证号
	 */

    public void setNonghuIdNumber(String nonghuIdNumber) {
        this.nonghuIdNumber = nonghuIdNumber;
    }
    /**
	 * 设置：农户照片
	 */
    public String getNonghuPhoto() {
        return nonghuPhoto;
    }


    /**
	 * 获取：农户照片
	 */

    public void setNonghuPhoto(String nonghuPhoto) {
        this.nonghuPhoto = nonghuPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：农户邮箱
	 */
    public String getNonghuEmail() {
        return nonghuEmail;
    }


    /**
	 * 获取：农户邮箱
	 */

    public void setNonghuEmail(String nonghuEmail) {
        this.nonghuEmail = nonghuEmail;
    }
    /**
	 * 设置：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 获取：余额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 设置：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 获取：账户状态
	 */

    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
