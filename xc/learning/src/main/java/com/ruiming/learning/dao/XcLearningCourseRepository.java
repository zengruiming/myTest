package com.ruiming.learning.dao;

import com.ruiming.framework.domain.learning.XcLearningCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface XcLearningCourseRepository extends JpaRepository<XcLearningCourse,String> {
    //根据用户id和课程id查询
    XcLearningCourse findByUserIdAndCourseId(String userId, String courseId);
}
