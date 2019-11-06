package com.ulatina.testers;

//import java.util.List;

import javax.persistence.*;

import com.ulatina.controllers.Controller;
import com.ulatina.controllers.FormController;
import com.ulatina.controllers.QuestionController;
import com.ulatina.controllers.TypeController;
import com.ulatina.entity.Form;
import com.ulatina.entity.Question;
import com.ulatina.entity.Type;


public class SantiTester {
	
	public static void main(String[] args) {
	

		Controller typeController = new TypeController();
	    Controller questionController = new QuestionController();
	    Controller formController = new FormController();
	    
	    Form testForm = (Form)formController.selectRegister("2");
	
		Type type = (Type)typeController.selectRegister("1");
	    Question newQuestion = new Question();
	    
	    newQuestion.setType(type);
	    newQuestion.setForm(testForm);
	    testForm.getQuestionList().add(newQuestion);
	    type.getQuestionList().add(newQuestion);
	    
	    questionController.insert(newQuestion);
	}
	
}
