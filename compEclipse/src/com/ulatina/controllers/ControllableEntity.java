package com.ulatina.controllers;

import java.util.ArrayList;

public interface ControllableEntity {
	/**
	 * This method will return a list of all the registers in a table. Each item in the list will be saved as an object
	 * @return a list of all the registers in a table. Each item in the list will be saved as an object
	 */
	public ArrayList<Object> selectAll();
	
	/**
	 * This method is used to select everything from one register, specified by the primary key
	 * @param id primary key
	 * @return an object which contains all the attributes(columns) of the chosen register
	 */
	public Object selectRegister(String id);
	
	/**
	 * This method is used to update a register
	 * @param whichColumn This is the column we want to update
	 * @param newValue This is the new value that we want to be inserted
	 * @param primaryColumn This is the column we're using as a reference to find the register
	 * @param certainValue This is the value we want the primaryColumn to match
	 */
	public void update(String whichColumn, String newValue, String primaryColumn, String certainValue);
	
	/**
	 * This method is used to delete a register
	 * @param primaryColumn This is the column we're using as a reference to find the register
	 * @param certanValue This is the value we want the primaryColumn to match
	 */
	public void delete(String primaryColumn, String certanValue);
}
