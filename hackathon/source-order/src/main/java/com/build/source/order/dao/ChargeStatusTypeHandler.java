package com.build.source.order.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.build.analytics.event.order.ChargeStatus;

@MappedTypes(ChargeStatus.class)
public class ChargeStatusTypeHandler extends BaseTypeHandler<ChargeStatus> {

	private static final Map<String, ChargeStatus> CHARGE_STATUS_MAP = new HashMap<>();

	static {
		CHARGE_STATUS_MAP.put("approved", ChargeStatus.A);
		CHARGE_STATUS_MAP.put("cancelled", ChargeStatus.C);
		CHARGE_STATUS_MAP.put("entered", ChargeStatus.E);
		CHARGE_STATUS_MAP.put("processed", ChargeStatus.P);
	}
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, ChargeStatus parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(index, parameter.getDescription().toLowerCase());				
	}

	@Override
	public ChargeStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String value = rs.getString(columnName);
		if (rs.wasNull()) {
			return null;
		}
		return valueToEnum(value);
	}

	@Override
	public ChargeStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String value = rs.getString(columnIndex);
		if (rs.wasNull()) {
			return null;
		}
		return valueToEnum(value);
	}

	@Override
	public ChargeStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String value = cs.getString(columnIndex);
	    if (cs.wasNull()) {
	    	return null;
	    }
	    return valueToEnum(value);
	}

	private ChargeStatus valueToEnum(String value) {
		return CHARGE_STATUS_MAP.get(value.toLowerCase());
	}
}
