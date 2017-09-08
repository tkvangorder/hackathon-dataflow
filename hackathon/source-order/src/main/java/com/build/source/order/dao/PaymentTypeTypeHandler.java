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

import com.build.analytics.event.order.PaymentType;

@MappedTypes(PaymentType.class)
public class PaymentTypeTypeHandler extends BaseTypeHandler<PaymentType> {

	private static final Map<Integer, PaymentType> PAYMENT_TYPE_MAP = new HashMap<>();
	static {
		//Setup mapping from the "old" domain into event enumerations.		
		PAYMENT_TYPE_MAP.put(1, PaymentType.CREDIT_CARD);
		PAYMENT_TYPE_MAP.put(2, PaymentType.PAYPAL);
		PAYMENT_TYPE_MAP.put(3, PaymentType.GOOGLE_CHECKOUT);
		PAYMENT_TYPE_MAP.put(4, PaymentType.FORCESHIP);
		PAYMENT_TYPE_MAP.put(5, PaymentType.CHECK);
		PAYMENT_TYPE_MAP.put(6, PaymentType.WIRE_TRANSFER);
		PAYMENT_TYPE_MAP.put(7, PaymentType.AMAZON_MARKETPLACE);
		PAYMENT_TYPE_MAP.put(8, PaymentType.AMAZON_PAYMENTS);
		PAYMENT_TYPE_MAP.put(9, PaymentType.CHANNEL_ADVISOR);
		PAYMENT_TYPE_MAP.put(10, PaymentType.GOOGLE_WALLET);
		PAYMENT_TYPE_MAP.put(11, PaymentType.VME);
		PAYMENT_TYPE_MAP.put(12, PaymentType.MASTER_PASS);
		PAYMENT_TYPE_MAP.put(13, PaymentType.BLUE_TARP);
		PAYMENT_TYPE_MAP.put(14, PaymentType.PENDING_CREDIT_CARD);
		PAYMENT_TYPE_MAP.put(15, PaymentType.STORE_CREDIT);
	}
	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, PaymentType parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(index, parameter.getIntValue());		
	}

	@Override
	public PaymentType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int intValue = rs.getInt(columnName);
		if (rs.wasNull()) {
			return null;
		}
		return intValueToEnum(intValue);
	}

	@Override
	public PaymentType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int intValue = rs.getInt(columnIndex);
		if (rs.wasNull()) {
			return null;
		}
		return intValueToEnum(intValue);
	}

	@Override
	public PaymentType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int intValue = cs.getInt(columnIndex);
	    if (cs.wasNull()) {
	    	return null;
	    }
	    return intValueToEnum(intValue);
	}

	private PaymentType intValueToEnum(int value) {
		return PAYMENT_TYPE_MAP.get(value);
	}
	
	

}
