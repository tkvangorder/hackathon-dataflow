package com.build.source.charge.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.build.analytics.event.order.ChargeType;

@MappedTypes(ChargeType.class)
public class ChargeTypeTypeHandler extends BaseTypeHandler<ChargeType> {

	private static final Map<String, ChargeType> CHARGE_TYPE_MAP = new HashMap<>();
	static {
		CHARGE_TYPE_MAP.put("credit", ChargeType.CRED);
		CHARGE_TYPE_MAP.put("credit-change", ChargeType.CRCH);
		CHARGE_TYPE_MAP.put("debit", ChargeType.DEBT);
		CHARGE_TYPE_MAP.put("debit-change", ChargeType.DECH);
	}
	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, ChargeType parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(index, parameter.getDescription().toLowerCase());		
	}

	@Override
	public ChargeType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String value = rs.getString(columnName);
		if (rs.wasNull()) {
			return null;
		}
		return valueToEnum(value);
	}

	@Override
	public ChargeType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String value = rs.getString(columnIndex);
		if (rs.wasNull()) {
			return null;
		}
		return valueToEnum(value);
	}

	@Override
	public ChargeType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String value = cs.getString(columnIndex);
	    if (cs.wasNull()) {
	    	return null;
	    }
	    return valueToEnum(value);
	}
	
	private ChargeType valueToEnum(String value) {
		return CHARGE_TYPE_MAP.get(value.toLowerCase());
	}
	

}
