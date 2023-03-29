package com.promineotech.mercedes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.promineotech.mercedes.entity.Chassis;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service
public class DefaultMercedesMaintenanceDao implements MercedesMaintenanceDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Chassis> fetchMercedes(Chassis name) {
		log.debug("DAO: name={}", name);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM chassis "
				+ "WHERE vehicle_name = :vehicle_name";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("vehicle_name", name.toString());
		
		return jdbcTemplate.query(sql, params,
				new org.springframework.jdbc.core.RowMapper<>() {

					@Override
					public Chassis mapRow(ResultSet rs, int rowNum) throws SQLException {
						// @formatter:off
						return Chassis.builder()
								.chassisPK(rs.getLong("chassis_pk"))
								.vinId(rs.getString("vin_id"))
								.chassisId(rs.getString("chassis_id"))
								.vehicleName(rs.getString("vehicle_name"))
								.build();
						// @formatter:on
					}
				}); 
	}
}
