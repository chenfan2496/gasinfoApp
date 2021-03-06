package com.manageTeaching.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.manageTeaching.util.Course;
import com.manageTeaching.util.DaoFactory;
import com.manageTeaching.util.Student;
import com.manageTeaching.util.StudentsDao;

public class QueryTableAction implements Action, ServletRequestAware{
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String queryTableAction() {
		HttpSession session = request.getSession();
		Student student= (Student) session.getAttribute("curStudent");
		int sid=student.getSid();
		StudentsDao studentDao=DaoFactory.getInstance().getStudentsdao();
		ArrayList<Course> courses =studentDao.getStudentClassTable(sid);
		request.setAttribute("courses", courses);
		for(int i=0;i<courses.size();i++){
			System.out.println(courses.get(i).getDay());
		}
		return SUCCESS;
	}
}
