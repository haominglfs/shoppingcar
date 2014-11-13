package cn.lut.shopping.test;

import static org.junit.Assert.*;
import cn.lut.shopping.util.JDBCUtil;

public class Test {

	@org.junit.Test
	public void testGetConnection() {
		JDBCUtil.getConnection();
	}

}
