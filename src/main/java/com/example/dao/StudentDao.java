package com.example.dao;

import org.apache.log4j.Logger;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Student;
@Component
public class StudentDao  {
	private static Logger logger=Logger.getLogger(StudentDao.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	 
	public void saveStudentData(Student student) {
		Session session=sessionFactory.openSession();
		try{
			if(null!=student){
				logger.debug("Saving student data .");
				session.save(student);
				session.close();
			}
		}catch(Exception e){
			logger.error("An Error Occurred while saving student data:",e);
		}finally{
			if(null!=session && session.isOpen()){
				session.close();
			}
		}

	}


	public Student getStudentData(Long studentId) {
		Session session=sessionFactory.openSession();
		try{
			if(null!=studentId){
				//logger.debug("Fetching aadhaar detail for application number:"+applicationNumber);
				@SuppressWarnings("unchecked")
				Query<Student> query=session.createQuery("from Student where id=:studentId");
				query.setParameter("studentId", studentId);
				Student stud=query.getSingleResult();
				session.close();
				if(null!=stud){
					return stud;
				}
				
			}
		}catch(Exception e){
			//logger.error("Unable to get aadhaar details for application Number:"+applicationNumber);
		}finally{
			if(null!=session && session.isOpen()){
				session.close();
			}
		}
		return null;
	}
	
	
	
//	@Override
//	public void updateAadhaarDetails(AadhaarDetails aadhaarDetails) {
//		Session session=sessionFactory.openSession();
//		try{
//			if(null!=aadhaarDetails){
//				logger.debug("updating aadhaar details.");
//				Transaction tx=session.beginTransaction();
//				session.update(aadhaarDetails);
//				tx.commit(); 
//				session.close();
//			}
//		}catch(Exception e){
//			logger.error("An Error Occurred while updating aadhaarDetails:",e);
//		}finally{
//			if(null!=session && session.isOpen()){
//				session.close();
//			}
//		}
//
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public AadhaarDetails getAadhaarDetails(String applicationNumber) {
//		Session session=sessionFactory.openSession();
//		try{
//			if(null!=applicationNumber && !applicationNumber.isEmpty()){
//				logger.debug("Fetching aadhaar detail for application number:"+applicationNumber);
//				Query<AadhaarDetails> query=session.createQuery("from AadhaarDetails where application_number=:applicationNumber");
//				query.setParameter("applicationNumber", applicationNumber);
//				AadhaarDetails aadhaarDetails=query.getSingleResult();
//				session.close();
//				if(null!=aadhaarDetails){
//					return aadhaarDetails;
//				}
//				
//			}
//		}catch(Exception e){
//			logger.error("Unable to get aadhaar details for application Number:"+applicationNumber);
//		}finally{
//			if(null!=session && session.isOpen()){
//				session.close();
//			}
//		}
//		return null;
//	}

}
