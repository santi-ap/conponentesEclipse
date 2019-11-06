package com.ulatina.testers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import com.ulatina.controllers.*;
import com.ulatina.entity.*;

public class TomTest {

		public static void main(String[] args) {

			
			/*	TESTED : 	ac.insert(answer);
			 * 				ac.update(answer);
			 * 				ac.selectAll();
			 * 				ac.selectRegister("0");
			 * 
			 * 				Controller ac = new AnswerController ();
			 *				System.out.print(" EntityManager: Checks Completed.\nStarting...");
			 * 				Answer answer = new Answer ();
			 *				ac.insert(answer);

			*/
			
			Controller uc = new UserController();
			Controller fc = new FormController();
	        User usTest = new User();
	        usTest.setEmail("santiz@test.com");
	        Form ft = new Form();
	        usTest.setFormList(new HashSet<Form>());
	        usTest.getFormList().add(ft);
	        ft.setUser(usTest);
	        
	        
	        
	        uc.insert(usTest);
	        
	        fc.insert(ft);
	        System.out.println("----");
			
//			Form form = new Form ();
//			form.setUser((User)uc.selectRegister("santi@test.com"));
//			fc.insert(form);
			

	}
}

