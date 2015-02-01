package com.infy.forms;

import org.apache.struts.action.ActionForm;

public class SearchForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private String searchString;

		public String getSearchString() {
			return searchString;
		}

		public void setSearchString(String searchString) {
			this.searchString = searchString;
		}
			
}
