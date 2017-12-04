package com.xjm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjm.dao.BillDao;
import com.xjm.entity.Bill;
import com.xjm.service.BillService;

@Service("billService")
public class BillServiceImpl implements BillService{
	
	@Autowired
	private BillDao billDao;
	
	@Override
	public int addBill(Bill bill) {
		// TODO Auto-generated method stub
		return billDao.addBill(bill);
	}

	@Override
	public int updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return billDao.updateBill(bill);
	}

	@Override
	public int deleteBill(Integer id) {
		// TODO Auto-generated method stub
		return billDao.deleteBill(id);
	}

	@Override
	public List<Bill> getBillList(
			 String queryProductName,
			 Integer queryProviderId,
			 Integer queryIsPayment,
			 Integer pageIndex,
			 Integer pageSize) {
		// TODO Auto-generated method stub
		return billDao.getBillList(queryProductName, queryProviderId, queryIsPayment, (pageIndex-1)*pageSize, pageSize);
	}

	@Override
	public Integer getBillCount( String queryProductName,
			Integer queryProviderId,Integer queryIsPayment) {
		// TODO Auto-generated method stub
		return billDao.getBillCount(queryProductName, queryProviderId, queryIsPayment);
	}

	@Override
	public Bill findBillById(Integer id) {
		// TODO Auto-generated method stub
		return billDao.findBillById(id);
	}

}
