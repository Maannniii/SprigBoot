package com.example.session.dbauth.customauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import jcifs.smb.NtlmPasswordAuthentication;

public class PasswordUpgrader implements PasswordEncoder {

	private final static BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	private final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public String encode(CharSequence rawPassword) {
		byte[] bytes = NtlmPasswordAuthentication.nTOWFv1(rawPassword.toString());
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars).toLowerCase();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (encodedPassword == null || encodedPassword.length() == 0) {
			return false;
		}
		if (encodedPassword.equals(encode(rawPassword))) {
			String sql = "update user_data set password=? where password=?";
			jdbc.update(sql, new Object[] { bcrypt.encode(rawPassword), encode(rawPassword) });
			return true;
		} else {
			return bcrypt.matches(rawPassword, encodedPassword);
		}
	}

}
