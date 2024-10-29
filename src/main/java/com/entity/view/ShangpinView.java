package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpin")
public class ShangpinView extends ShangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 商品类型的值
	*/
	@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
	private String shangpinValue;
	/**
	* 二级类型的值
	*/
	@ColumnInfo(comment="二级类型的字典表值",type="varchar(200)")
	private String shangpinErjiValue;
	/**
	* 帮扶产品的值
	*/
	@ColumnInfo(comment="帮扶产品的字典表值",type="varchar(200)")
	private String bangfuValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

	//级联表 农户
		/**
		* 农户编号
		*/

		@ColumnInfo(comment="农户编号",type="varchar(200)")
		private String nonghuUuidNumber;
		/**
		* 农户姓名
		*/

		@ColumnInfo(comment="农户姓名",type="varchar(200)")
		private String nonghuName;
		/**
		* 农户手机号
		*/

		@ColumnInfo(comment="农户手机号",type="varchar(200)")
		private String nonghuPhone;
		/**
		* 农户身份证号
		*/

		@ColumnInfo(comment="农户身份证号",type="varchar(200)")
		private String nonghuIdNumber;
		/**
		* 农户照片
		*/

		@ColumnInfo(comment="农户照片",type="varchar(200)")
		private String nonghuPhoto;
		/**
		* 农户邮箱
		*/

		@ColumnInfo(comment="农户邮箱",type="varchar(200)")
		private String nonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public ShangpinView() {

	}

	public ShangpinView(ShangpinEntity shangpinEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 商品类型的值
	*/
	public String getShangpinValue() {
		return shangpinValue;
	}
	/**
	* 设置： 商品类型的值
	*/
	public void setShangpinValue(String shangpinValue) {
		this.shangpinValue = shangpinValue;
	}
	//当前表的
	/**
	* 获取： 二级类型的值
	*/
	public String getShangpinErjiValue() {
		return shangpinErjiValue;
	}
	/**
	* 设置： 二级类型的值
	*/
	public void setShangpinErjiValue(String shangpinErjiValue) {
		this.shangpinErjiValue = shangpinErjiValue;
	}
	//当前表的
	/**
	* 获取： 帮扶产品的值
	*/
	public String getBangfuValue() {
		return bangfuValue;
	}
	/**
	* 设置： 帮扶产品的值
	*/
	public void setBangfuValue(String bangfuValue) {
		this.bangfuValue = bangfuValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}


	//级联表的get和set 农户

		/**
		* 获取： 农户编号
		*/
		public String getNonghuUuidNumber() {
			return nonghuUuidNumber;
		}
		/**
		* 设置： 农户编号
		*/
		public void setNonghuUuidNumber(String nonghuUuidNumber) {
			this.nonghuUuidNumber = nonghuUuidNumber;
		}

		/**
		* 获取： 农户姓名
		*/
		public String getNonghuName() {
			return nonghuName;
		}
		/**
		* 设置： 农户姓名
		*/
		public void setNonghuName(String nonghuName) {
			this.nonghuName = nonghuName;
		}

		/**
		* 获取： 农户手机号
		*/
		public String getNonghuPhone() {
			return nonghuPhone;
		}
		/**
		* 设置： 农户手机号
		*/
		public void setNonghuPhone(String nonghuPhone) {
			this.nonghuPhone = nonghuPhone;
		}

		/**
		* 获取： 农户身份证号
		*/
		public String getNonghuIdNumber() {
			return nonghuIdNumber;
		}
		/**
		* 设置： 农户身份证号
		*/
		public void setNonghuIdNumber(String nonghuIdNumber) {
			this.nonghuIdNumber = nonghuIdNumber;
		}

		/**
		* 获取： 农户照片
		*/
		public String getNonghuPhoto() {
			return nonghuPhoto;
		}
		/**
		* 设置： 农户照片
		*/
		public void setNonghuPhoto(String nonghuPhoto) {
			this.nonghuPhoto = nonghuPhoto;
		}

		/**
		* 获取： 农户邮箱
		*/
		public String getNonghuEmail() {
			return nonghuEmail;
		}
		/**
		* 设置： 农户邮箱
		*/
		public void setNonghuEmail(String nonghuEmail) {
			this.nonghuEmail = nonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "ShangpinView{" +
			", shangpinValue=" + shangpinValue +
			", shangpinErjiValue=" + shangpinErjiValue +
			", bangfuValue=" + bangfuValue +
			", shangxiaValue=" + shangxiaValue +
			", nonghuUuidNumber=" + nonghuUuidNumber +
			", nonghuName=" + nonghuName +
			", nonghuPhone=" + nonghuPhone +
			", nonghuIdNumber=" + nonghuIdNumber +
			", nonghuPhoto=" + nonghuPhoto +
			", nonghuEmail=" + nonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
