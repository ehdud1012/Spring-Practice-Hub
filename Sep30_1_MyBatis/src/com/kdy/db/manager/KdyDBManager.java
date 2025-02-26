package com.kdy.db.manager;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class KdyDBManager {
	private SqlSessionFactory ssf;
	private static final KdyDBManager KDBM = new KdyDBManager();
	
	public static KdyDBManager getKdbm() {
		return KDBM;
	}

	public SqlSessionFactory getSsf() {
		return ssf;
	}
	
	// 처음 한번만 (공장을 계속 새로 지을 순 없으니)
	public void newSSF(String cfgFile) throws IOException  {
		InputStream is = Resources.getResourceAsStream(cfgFile);
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		ssf = ssfb.build(is);
	}
}
