package com.bdcourtyard.business.user.dao;

import com.bdcourtyard.business.user.model.UserFeedback;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  UserFeedbackDao 用户意见反馈
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@Repository
public interface UserFeedbackDao {
	
	int insertUserFeedback(UserFeedback userFeedback);
	
	int insertUserFeedbackBatch(List<UserFeedback> list);
	
	int updateUserFeedbackById(UserFeedback userFeedback);
	
	int deleteUserFeedbackById(@Param("feedbackId") String feedbackId);

 	UserFeedback getUserFeedbackById(@Param("feedbackId") String feedbackId);

 	List<UserFeedback> getUserFeedbacks(@Param("userFeedback") UserFeedback userFeedback);
 	
 	List<UserFeedback> getUserFeedbacksByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<UserFeedback> findAllFeedback(String empId);
}
