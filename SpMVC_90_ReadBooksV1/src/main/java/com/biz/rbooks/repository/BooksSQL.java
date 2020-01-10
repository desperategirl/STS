package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

public class BooksSQL {
	
	public String booksInsert_sql() {
		
		return new SQL() {{
		
			INSERT_INTO("tbl_books");
			
			INTO_COLUMNS("b_code");
			INTO_COLUMNS("b_name");
			INTO_COLUMNS("b_auther");
			INTO_COLUMNS("b_comp");
			INTO_COLUMNS("b_year");
			INTO_COLUMNS("b_iprice");

			INTO_VALUES("#{b_code,jdbcType=VARCHAR}");
			INTO_VALUES("#{b_name,jdbcType=VARCHAR}");
			INTO_VALUES("#{b_auther,jdbcType=VARCHAR}");
			INTO_VALUES("#{b_comp,jdbcType=VARCHAR}");
			INTO_VALUES("#{b_year,jdbcType=VARCHAR}");
			INTO_VALUES("#{b_iprice,jdbcType=VARCHAR}");

		}}.toString();
		
	}

}
