package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpinBangfushenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 帮扶申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpin_bangfushenqing")
public class ShangpinBangfushenqingView extends ShangpinBangfushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帮扶申请类型的值
	*/
	@ColumnInfo(comment="帮扶申请类型的字典表值",type="varchar(200)")
	private String shangpinBangfushenqingValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String shangpinBangfushenqingYesnoValue;

	//级联表 商品
					 
		/**
		* 商品 的 农户
		*/
		@ColumnInfo(comment="农户",type="int(11)")
		private Integer shangpinNonghuId;
		/**
		* 商品名称
		*/

		@ColumnInfo(comment="商品名称",type="varchar(200)")
		private String shangpinName;
		/**
		* 商品编号
		*/

		@ColumnInfo(comment="商品编号",type="varchar(200)")
		private String shangpinUuidNumber;
		/**
		* 商品照片
		*/

		@ColumnInfo(comment="商品照片",type="varchar(200)")
		private String shangpinPhoto;
		/**
		* 原产地
		*/

		@ColumnInfo(comment="原产地",type="varchar(200)")
		private String shangpinAddress;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 商品类型
		*/
		@ColumnInfo(comment="商品类型",type="int(11)")
		private Integer shangpinTypes;
			/**
			* 商品类型的值
			*/
			@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
			private String shangpinValue;
		/**
		* 二级类型
		*/
		@ColumnInfo(comment="二级类型",type="int(11)")
		private Integer shangpinErjiTypes;
			/**
			* 二级类型的值
			*/
			@ColumnInfo(comment="二级类型的字典表值",type="varchar(200)")
			private String shangpinErjiValue;
		/**
		* 帮扶产品
		*/
		@ColumnInfo(comment="帮扶产品",type="int(11)")
		private Integer bangfuTypes;
			/**
			* 帮扶产品的值
			*/
			@ColumnInfo(comment="帮扶产品的字典表值",type="varchar(200)")
			private String bangfuValue;
		/**
		* 商品库存
		*/

		@ColumnInfo(comment="商品库存",type="int(11)")
		private Integer shangpinKucunNumber;
		/**
		* 购买获得积分
		*/

		@ColumnInfo(comment="购买获得积分",type="int(11)")
		private Integer shangpinPrice;
		/**
		* 商品原价
		*/
		@ColumnInfo(comment="商品原价",type="decimal(10,2)")
		private Double shangpinOldMoney;
		/**
		* 现价/积分
		*/
		@ColumnInfo(comment="现价/积分",type="decimal(10,2)")
		private Double shangpinNewMoney;
		/**
		* 所属仓库
		*/

		@ColumnInfo(comment="所属仓库",type="varchar(200)")
		private String shangpinCangku;
		/**
		* 商品热度
		*/

		@ColumnInfo(comment="商品热度",type="int(11)")
		private Integer shangpinClicknum;
		/**
		* 商品介绍
		*/

		@ColumnInfo(comment="商品介绍",type="longtext")
		private String shangpinContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shangpinDelete;



	public ShangpinBangfushenqingView() {

	}

	public ShangpinBangfushenqingView(ShangpinBangfushenqingEntity shangpinBangfushenqingEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinBangfushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帮扶申请类型的值
	*/
	public String getShangpinBangfushenqingValue() {
		return shangpinBangfushenqingValue;
	}
	/**
	* 设置： 帮扶申请类型的值
	*/
	public void setShangpinBangfushenqingValue(String shangpinBangfushenqingValue) {
		this.shangpinBangfushenqingValue = shangpinBangfushenqingValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getShangpinBangfushenqingYesnoValue() {
		return shangpinBangfushenqingYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setShangpinBangfushenqingYesnoValue(String shangpinBangfushenqingYesnoValue) {
		this.shangpinBangfushenqingYesnoValue = shangpinBangfushenqingYesnoValue;
	}


	//级联表的get和set 商品
		/**
		* 获取：商品 的 农户
		*/
		public Integer getShangpinNonghuId() {
			return shangpinNonghuId;
		}
		/**
		* 设置：商品 的 农户
		*/
		public void setShangpinNonghuId(Integer shangpinNonghuId) {
			this.shangpinNonghuId = shangpinNonghuId;
		}

		/**
		* 获取： 商品名称
		*/
		public String getShangpinName() {
			return shangpinName;
		}
		/**
		* 设置： 商品名称
		*/
		public void setShangpinName(String shangpinName) {
			this.shangpinName = shangpinName;
		}

		/**
		* 获取： 商品编号
		*/
		public String getShangpinUuidNumber() {
			return shangpinUuidNumber;
		}
		/**
		* 设置： 商品编号
		*/
		public void setShangpinUuidNumber(String shangpinUuidNumber) {
			this.shangpinUuidNumber = shangpinUuidNumber;
		}

		/**
		* 获取： 商品照片
		*/
		public String getShangpinPhoto() {
			return shangpinPhoto;
		}
		/**
		* 设置： 商品照片
		*/
		public void setShangpinPhoto(String shangpinPhoto) {
			this.shangpinPhoto = shangpinPhoto;
		}

		/**
		* 获取： 原产地
		*/
		public String getShangpinAddress() {
			return shangpinAddress;
		}
		/**
		* 设置： 原产地
		*/
		public void setShangpinAddress(String shangpinAddress) {
			this.shangpinAddress = shangpinAddress;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 商品类型
		*/
		public Integer getShangpinTypes() {
			return shangpinTypes;
		}
		/**
		* 设置： 商品类型
		*/
		public void setShangpinTypes(Integer shangpinTypes) {
			this.shangpinTypes = shangpinTypes;
		}


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
		/**
		* 获取： 二级类型
		*/
		public Integer getShangpinErjiTypes() {
			return shangpinErjiTypes;
		}
		/**
		* 设置： 二级类型
		*/
		public void setShangpinErjiTypes(Integer shangpinErjiTypes) {
			this.shangpinErjiTypes = shangpinErjiTypes;
		}


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
		/**
		* 获取： 帮扶产品
		*/
		public Integer getBangfuTypes() {
			return bangfuTypes;
		}
		/**
		* 设置： 帮扶产品
		*/
		public void setBangfuTypes(Integer bangfuTypes) {
			this.bangfuTypes = bangfuTypes;
		}


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

		/**
		* 获取： 商品库存
		*/
		public Integer getShangpinKucunNumber() {
			return shangpinKucunNumber;
		}
		/**
		* 设置： 商品库存
		*/
		public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
			this.shangpinKucunNumber = shangpinKucunNumber;
		}

		/**
		* 获取： 购买获得积分
		*/
		public Integer getShangpinPrice() {
			return shangpinPrice;
		}
		/**
		* 设置： 购买获得积分
		*/
		public void setShangpinPrice(Integer shangpinPrice) {
			this.shangpinPrice = shangpinPrice;
		}

		/**
		* 获取： 商品原价
		*/
		public Double getShangpinOldMoney() {
			return shangpinOldMoney;
		}
		/**
		* 设置： 商品原价
		*/
		public void setShangpinOldMoney(Double shangpinOldMoney) {
			this.shangpinOldMoney = shangpinOldMoney;
		}

		/**
		* 获取： 现价/积分
		*/
		public Double getShangpinNewMoney() {
			return shangpinNewMoney;
		}
		/**
		* 设置： 现价/积分
		*/
		public void setShangpinNewMoney(Double shangpinNewMoney) {
			this.shangpinNewMoney = shangpinNewMoney;
		}

		/**
		* 获取： 所属仓库
		*/
		public String getShangpinCangku() {
			return shangpinCangku;
		}
		/**
		* 设置： 所属仓库
		*/
		public void setShangpinCangku(String shangpinCangku) {
			this.shangpinCangku = shangpinCangku;
		}

		/**
		* 获取： 商品热度
		*/
		public Integer getShangpinClicknum() {
			return shangpinClicknum;
		}
		/**
		* 设置： 商品热度
		*/
		public void setShangpinClicknum(Integer shangpinClicknum) {
			this.shangpinClicknum = shangpinClicknum;
		}

		/**
		* 获取： 商品介绍
		*/
		public String getShangpinContent() {
			return shangpinContent;
		}
		/**
		* 设置： 商品介绍
		*/
		public void setShangpinContent(String shangpinContent) {
			this.shangpinContent = shangpinContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShangpinDelete() {
			return shangpinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShangpinDelete(Integer shangpinDelete) {
			this.shangpinDelete = shangpinDelete;
		}


	@Override
	public String toString() {
		return "ShangpinBangfushenqingView{" +
			", shangpinBangfushenqingValue=" + shangpinBangfushenqingValue +
			", shangpinBangfushenqingYesnoValue=" + shangpinBangfushenqingYesnoValue +
			", shangpinName=" + shangpinName +
			", shangpinUuidNumber=" + shangpinUuidNumber +
			", shangpinPhoto=" + shangpinPhoto +
			", shangpinAddress=" + shangpinAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", shangpinKucunNumber=" + shangpinKucunNumber +
			", shangpinPrice=" + shangpinPrice +
			", shangpinOldMoney=" + shangpinOldMoney +
			", shangpinNewMoney=" + shangpinNewMoney +
			", shangpinCangku=" + shangpinCangku +
			", shangpinClicknum=" + shangpinClicknum +
			", shangpinContent=" + shangpinContent +
			", shangpinDelete=" + shangpinDelete +
			"} " + super.toString();
	}
}
