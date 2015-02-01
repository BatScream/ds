package com.infy.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.infy.forms.AddPatchForm;

public class TestClass {
public static void main(String[] args) throws ParseException {
	
	
	
	AddPatchForm a = new AddPatchForm();
	if(a.getDefectNumber() == null){
		System.out.println("A");
	}
	else if(a.getDefectNumber().trim() == "")
	{
		System.out.println("B");
	}
	else{
		System.out.println("C");
	}
}
}
