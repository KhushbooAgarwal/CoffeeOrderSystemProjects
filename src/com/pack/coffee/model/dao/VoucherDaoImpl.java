package com.pack.coffee.model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.coffee.model.bean.Vouchers;

@Repository("VoucherDao")
public class VoucherDaoImpl implements VoucherDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
	
	@Override
	public ArrayList<Vouchers> getAllVouchers() {
		//For every Transaction one Session object
		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		Query<Vouchers> query=session.createQuery("from Vouchers");
		List<Vouchers> voucherList=query.getResultList();
		transaction.commit();
		session.close();
		//factory.close();
		return (ArrayList<Vouchers>) voucherList;
	}

	@Override
	public Vouchers getVoucherByVoucherName(String voucherName) {
		Vouchers vouchers = null;
         Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		  Query query2=session.createQuery("from Vouchers where Voucher_Name=:voucherName");
		  query2.setParameter("voucherName", voucherName); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  vouchers = (Vouchers) iterator.next();
		  }
		  transaction.commit();
			session.close();
			//factory.close();
		return vouchers;
	}

}
