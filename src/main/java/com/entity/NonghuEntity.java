package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 农户
 *
 * @author 
 * @email
 */
@TableName("nonghu")
public class NonghuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NonghuEntity() {

	}

	public NonghuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 农户编号
     */
    @ColumnInfo(comment="农户编号",type="varchar(200)")
    @TableField(value = "nonghu_uuid_number")

    private String nonghuUuidNumber;


    /**
     * 农户姓名
     */
    @ColumnInfo(comment="农户姓名",type="varchar(200)")
    @TableField(value = "nonghu_name")

    private String nonghuName;


    /**
     * 农户手机号
     */
    @ColumnInfo(comment="农户手机号",type="varchar(200)")
    @TableField(value = "nonghu_phone")

    private String nonghuPhone;


    /**
     * 农户身份证号
     */
    @ColumnInfo(comment="农户身份证号",type="varchar(200)")
    @TableField(value = "nonghu_id_number")

    private String nonghuIdNumber;


    /**
     * 农户照片
     */
    @ColumnInfo(comment="农户照片",type="varchar(200)")
    @TableField(value = "nonghu_photo")

    private String nonghuPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 农户邮箱
     */
    @ColumnInfo(comment="农户邮箱",type="varchar(200)")
    @TableField(value = "nonghu_email")

    private String nonghuEmail;


    /**
     * 余额
     */
    @ColumnInfo(comment="余额",type="decimal(10,2)")
    @TableField(value = "new_money")

    private Double newMoney;


    /**
     * 账户状态
     */
    @ColumnInfo(comment="账户状态",type="int(11)")
    @TableField(value = "jinyong_types")

    private Integer jinyongTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Nonghu{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", nonghuUuidNumber=" + nonghuUuidNumber +
            ", nonghuName=" + nonghuName +
            ", nonghuPhone=" + nonghuPhone +
            ", nonghuIdNumber=" + nonghuIdNumber +
            ", nonghuPhoto=" + nonghuPhoto +
            ", sexTypes=" + sexTypes +
            ", nonghuEmail=" + nonghuEmail +
            ", newMoney=" + newMoney +
            ", jinyongTypes=" + jinyongTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
