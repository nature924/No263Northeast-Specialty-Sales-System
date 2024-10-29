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
 * 帮扶申请
 *
 * @author 
 * @email
 */
@TableName("shangpin_bangfushenqing")
public class ShangpinBangfushenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpinBangfushenqingEntity() {

	}

	public ShangpinBangfushenqingEntity(T t) {
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
     * 商品
     */
    @ColumnInfo(comment="商品",type="int(11)")
    @TableField(value = "shangpin_id")

    private Integer shangpinId;


    /**
     * 帮扶申请编号
     */
    @ColumnInfo(comment="帮扶申请编号",type="varchar(200)")
    @TableField(value = "shangpin_bangfushenqing_uuid_number")

    private String shangpinBangfushenqingUuidNumber;


    /**
     * 申请标题
     */
    @ColumnInfo(comment="申请标题",type="varchar(200)")
    @TableField(value = "shangpin_bangfushenqing_name")

    private String shangpinBangfushenqingName;


    /**
     * 帮扶申请类型
     */
    @ColumnInfo(comment="帮扶申请类型",type="int(11)")
    @TableField(value = "shangpin_bangfushenqing_types")

    private Integer shangpinBangfushenqingTypes;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "shangpin_bangfushenqing_file")

    private String shangpinBangfushenqingFile;


    /**
     * 申请缘由
     */
    @ColumnInfo(comment="申请缘由",type="longtext")
    @TableField(value = "shangpin_bangfushenqing_content")

    private String shangpinBangfushenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "shangpin_bangfushenqing_yesno_types")

    private Integer shangpinBangfushenqingYesnoTypes;


    /**
     * 审核附件
     */
    @ColumnInfo(comment="审核附件",type="longtext")
    @TableField(value = "shangpin_bangfushenqing_yesno_text")

    private String shangpinBangfushenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "shangpin_bangfushenqing_shenhe_time")

    private Date shangpinBangfushenqingShenheTime;


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
	 * 获取：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }
    /**
	 * 设置：商品
	 */

    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 获取：帮扶申请编号
	 */
    public String getShangpinBangfushenqingUuidNumber() {
        return shangpinBangfushenqingUuidNumber;
    }
    /**
	 * 设置：帮扶申请编号
	 */

    public void setShangpinBangfushenqingUuidNumber(String shangpinBangfushenqingUuidNumber) {
        this.shangpinBangfushenqingUuidNumber = shangpinBangfushenqingUuidNumber;
    }
    /**
	 * 获取：申请标题
	 */
    public String getShangpinBangfushenqingName() {
        return shangpinBangfushenqingName;
    }
    /**
	 * 设置：申请标题
	 */

    public void setShangpinBangfushenqingName(String shangpinBangfushenqingName) {
        this.shangpinBangfushenqingName = shangpinBangfushenqingName;
    }
    /**
	 * 获取：帮扶申请类型
	 */
    public Integer getShangpinBangfushenqingTypes() {
        return shangpinBangfushenqingTypes;
    }
    /**
	 * 设置：帮扶申请类型
	 */

    public void setShangpinBangfushenqingTypes(Integer shangpinBangfushenqingTypes) {
        this.shangpinBangfushenqingTypes = shangpinBangfushenqingTypes;
    }
    /**
	 * 获取：附件
	 */
    public String getShangpinBangfushenqingFile() {
        return shangpinBangfushenqingFile;
    }
    /**
	 * 设置：附件
	 */

    public void setShangpinBangfushenqingFile(String shangpinBangfushenqingFile) {
        this.shangpinBangfushenqingFile = shangpinBangfushenqingFile;
    }
    /**
	 * 获取：申请缘由
	 */
    public String getShangpinBangfushenqingContent() {
        return shangpinBangfushenqingContent;
    }
    /**
	 * 设置：申请缘由
	 */

    public void setShangpinBangfushenqingContent(String shangpinBangfushenqingContent) {
        this.shangpinBangfushenqingContent = shangpinBangfushenqingContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getShangpinBangfushenqingYesnoTypes() {
        return shangpinBangfushenqingYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setShangpinBangfushenqingYesnoTypes(Integer shangpinBangfushenqingYesnoTypes) {
        this.shangpinBangfushenqingYesnoTypes = shangpinBangfushenqingYesnoTypes;
    }
    /**
	 * 获取：审核附件
	 */
    public String getShangpinBangfushenqingYesnoText() {
        return shangpinBangfushenqingYesnoText;
    }
    /**
	 * 设置：审核附件
	 */

    public void setShangpinBangfushenqingYesnoText(String shangpinBangfushenqingYesnoText) {
        this.shangpinBangfushenqingYesnoText = shangpinBangfushenqingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShangpinBangfushenqingShenheTime() {
        return shangpinBangfushenqingShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setShangpinBangfushenqingShenheTime(Date shangpinBangfushenqingShenheTime) {
        this.shangpinBangfushenqingShenheTime = shangpinBangfushenqingShenheTime;
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
        return "ShangpinBangfushenqing{" +
            ", id=" + id +
            ", shangpinId=" + shangpinId +
            ", shangpinBangfushenqingUuidNumber=" + shangpinBangfushenqingUuidNumber +
            ", shangpinBangfushenqingName=" + shangpinBangfushenqingName +
            ", shangpinBangfushenqingTypes=" + shangpinBangfushenqingTypes +
            ", shangpinBangfushenqingFile=" + shangpinBangfushenqingFile +
            ", shangpinBangfushenqingContent=" + shangpinBangfushenqingContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", shangpinBangfushenqingYesnoTypes=" + shangpinBangfushenqingYesnoTypes +
            ", shangpinBangfushenqingYesnoText=" + shangpinBangfushenqingYesnoText +
            ", shangpinBangfushenqingShenheTime=" + DateUtil.convertString(shangpinBangfushenqingShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
