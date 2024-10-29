package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpinChatEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 用户咨询
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpin_chat")
public class ShangpinChatView extends ShangpinChatEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 状态的值
	*/
	@ColumnInfo(comment="状态的字典表值",type="varchar(200)")
	private String zhuangtaiValue;
	/**
	* 数据类型的值
	*/
	@ColumnInfo(comment="数据类型的字典表值",type="varchar(200)")
	private String shangpinChatValue;

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
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 总积分
		*/
		@ColumnInfo(comment="总积分",type="decimal(10,2)")
		private Double yonghuSumJifen;
		/**
		* 现积分
		*/
		@ColumnInfo(comment="现积分",type="decimal(10,2)")
		private Double yonghuNewJifen;
		/**
		* 会员等级
		*/
		@ColumnInfo(comment="会员等级",type="int(11)")
		private Integer huiyuandengjiTypes;
			/**
			* 会员等级的值
			*/
			@ColumnInfo(comment="会员等级的字典表值",type="varchar(200)")
			private String huiyuandengjiValue;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public ShangpinChatView() {

	}

	public ShangpinChatView(ShangpinChatEntity shangpinChatEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinChatEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 状态的值
	*/
	public String getZhuangtaiValue() {
		return zhuangtaiValue;
	}
	/**
	* 设置： 状态的值
	*/
	public void setZhuangtaiValue(String zhuangtaiValue) {
		this.zhuangtaiValue = zhuangtaiValue;
	}
	//当前表的
	/**
	* 获取： 数据类型的值
	*/
	public String getShangpinChatValue() {
		return shangpinChatValue;
	}
	/**
	* 设置： 数据类型的值
	*/
	public void setShangpinChatValue(String shangpinChatValue) {
		this.shangpinChatValue = shangpinChatValue;
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
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
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
		* 获取： 总积分
		*/
		public Double getYonghuSumJifen() {
			return yonghuSumJifen;
		}
		/**
		* 设置： 总积分
		*/
		public void setYonghuSumJifen(Double yonghuSumJifen) {
			this.yonghuSumJifen = yonghuSumJifen;
		}

		/**
		* 获取： 现积分
		*/
		public Double getYonghuNewJifen() {
			return yonghuNewJifen;
		}
		/**
		* 设置： 现积分
		*/
		public void setYonghuNewJifen(Double yonghuNewJifen) {
			this.yonghuNewJifen = yonghuNewJifen;
		}
		/**
		* 获取： 会员等级
		*/
		public Integer getHuiyuandengjiTypes() {
			return huiyuandengjiTypes;
		}
		/**
		* 设置： 会员等级
		*/
		public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
			this.huiyuandengjiTypes = huiyuandengjiTypes;
		}


			/**
			* 获取： 会员等级的值
			*/
			public String getHuiyuandengjiValue() {
				return huiyuandengjiValue;
			}
			/**
			* 设置： 会员等级的值
			*/
			public void setHuiyuandengjiValue(String huiyuandengjiValue) {
				this.huiyuandengjiValue = huiyuandengjiValue;
			}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getJinyongTypes() {
			return jinyongTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
			}
				public String getJinyongValue() {
				return jinyongValue;
				}
				public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
				}

	@Override
	public String toString() {
		return "ShangpinChatView{" +
			", zhuangtaiValue=" + zhuangtaiValue +
			", shangpinChatValue=" + shangpinChatValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuSumJifen=" + yonghuSumJifen +
			", yonghuNewJifen=" + yonghuNewJifen +
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
