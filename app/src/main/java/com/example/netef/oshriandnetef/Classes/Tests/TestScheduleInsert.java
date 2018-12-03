package com.example.netef.oshriandnetef.Classes.Tests;

//import org.junit.Test;
//import static org.junit.Assert.*;

import com.example.netef.oshriandnetef.Classes.AllCourses;
import com.example.netef.oshriandnetef.Classes.IDay;
import com.example.netef.oshriandnetef.Classes.Model;

public class TestScheduleInsert {


		//@Test
		public static void testSchedule(Model model) {
		
			AllCourses allCourses=model.getAllCoursesForTestingOnly();
			 try {
				allCourses.addCourse(1,"Algebra");
				allCourses.addCourse(2,"C#");
				allCourses.addCourse(3,"JAVA");
				allCourses.addCourse(4,"DATA BASE");
				allCourses.addCourse(5,"LINUX");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				allCourses.addShow(1, 0);
				allCourses.addShow(1, 1);
				allCourses.addShow(1, 2);
				allCourses.addShow(1, 3);
				allCourses.addShow(2, 0);
				allCourses.addShow(3, 0);
				allCourses.addShow(4, 0);
				allCourses.addShow(5, 0);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				allCourses.addSlot(1, 0, 0,IDay.Day.Sunday, 10, 15, 101, "Yossi");
				allCourses.addSlot(1, 0, 1,IDay.Day.Monday, 13, 18, 102, "Yossi");
				
				allCourses.addSlot(1, 1, 0,IDay.Day.Sunday, 15,20, 103, "Yoni");
				allCourses.addSlot(1, 1, 1,IDay.Day.Monday, 18,20, 104, "Yoni");
				
				allCourses.addSlot(1, 2, 0,IDay.Day.Sunday, 19,20, 1011, "yoyoyo");
				allCourses.addSlot(1, 2, 1,IDay.Day.Wednesday, 18,20, 1123, "yoyoyoyo");
				
				allCourses.addSlot(1, 3, 0,IDay.Day.Wednesday, 15,18, 103, "Yoni");
				allCourses.addSlot(1, 3, 1,IDay.Day.Friday, 18,20, 104, "Yoni");
				
				
				allCourses.addSlot(2, 0, 0,IDay.Day.Tuesday, 15, 18, 103, "momo");
				
				allCourses.addSlot(3, 0, 0,IDay.Day.Wednesday, 16, 18, 104, "GOGO");
				
				allCourses.addSlot(4, 0, 0,IDay.Day.Wednesday, 10, 17, 105, "NONO");
				
				allCourses.addSlot(5, 0, 0,IDay.Day.Wednesday, 14, 16, 106, "YOYO");
				allCourses.addSlot(5, 0, 1,IDay.Day.Tuesday, 12, 15, 107, "LOLO");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			/* Schedule2 loz=model.getScheduleForTestingOnly();
			 try {
				loz.addCourseToSchedule(allCourses.getCourseById(1), 0);
				loz.addCourseToSchedule(allCourses.getCourseById(1), 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//assertEquals();
			 * */
			 
		}

	}

