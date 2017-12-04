package com.xjm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjm.entity.Bill;

public interface BillDao {
	
	/**
	 * 新增订单
	 * @param bill
	 * @return
	 */
	public int addBill(Bill bill);
	
	/**
	 * 修改订单
	 * @param bill
	 * @return
	 */
	public int updateBill(Bill bill);
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	public int deleteBill(Integer id);
	
	/**
	 * 根据Id查询订单
	 * @param id
	 * @return
	 */
	public Bill findBillById(Integer id);
	
	/**
	 * 模糊查询 分页
	 * @param queryProductName
	 * @param queryProviderId
	 * @param queryIsPayment
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Bill> getBillList(@Param("queryProductName")String queryProductName,
				@Param("queryProviderId")Integer queryProviderId,
				@Param("queryIsPayment")Integer queryIsPayment,
			@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
	/**
	 * 模糊查询总行数
	 * @param queryProductName
	 * @param queryProviderId
	 * @param queryIsPayment
	 * @return
	 */
	public Integer getBillCount(@Param("queryProductName")String queryProductName,
			@Param("queryProviderId")Integer queryProviderId,
			@Param("queryIsPayment")Integer queryIsPayment);

}
