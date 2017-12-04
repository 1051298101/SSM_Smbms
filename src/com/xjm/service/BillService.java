package com.xjm.service;

import java.util.List;

import com.xjm.entity.Bill;

public interface BillService {
	
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
	public List<Bill> getBillList(String queryProductName,
				Integer queryProviderId,Integer queryIsPayment,
			Integer pageIndex,Integer pageSize);
	
	/**
	 * 模糊查询总行数
	 * @param queryProductName
	 * @param queryProviderId
	 * @param queryIsPayment
	 * @return
	 */
	public Integer getBillCount(String queryProductName,
			Integer queryProviderId,Integer queryIsPayment);
	
}
