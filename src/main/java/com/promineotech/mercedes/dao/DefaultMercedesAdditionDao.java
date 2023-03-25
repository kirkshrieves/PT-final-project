package com.promineotech.mercedes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.mercedes.controller.Mercedes;
import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.Chassis;
import com.promineotech.mercedes.entity.Engine;
import com.promineotech.mercedes.entity.MercedesName;
import com.promineotech.mercedes.entity.Vin;

import io.swagger.v3.core.jackson.TypeNameResolver.Options;

@Component
public class DefaultMercedesAdditionDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//@Override
	public Addition saveAddition(Vin vin, Chassis chassis, Mercedes mercedes) {
		SqlParams params = generateInsertSql(vin, chassis, mercedes);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		Long chassisPK = keyHolder.getKey().longValue();
		
		// @formatter:off
		return Addition.builder()
				.chassisPK(chassisPK)
				.vinId(vin)
				.chassisId(chassis)
				.vehicleName(chassis)
				.build();
		// @formatter:on
	}
		
	private SqlParams generateInsertSql(Vin vin, Chassis chassis, Mercedes mercedes) {
		SqlParams params = new SqlParams();
		
		// @formatter:off
		params.sql = ""
				+ "INSERT INTO chassis ("
				+ "chassis_id, vehicle_name, vin_id"
				+ ") VALUES ("
				+ ":chassis_id, :vehicle_name, :vin_id"
				+ ")";
		// @formatter:on
		
		params.source.addValue("chassis_id", chassis.getChassisId());
		params.source.addValue("vehicle_name", chassis.getVehicleName());
		params.source.addValue("vin_id", chassis.getVinId());
		
		return params;
	}
	
	public Optional<Vin> fetchVin(String vinId){
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM vin "
				+ "WHERE vin_id = :vin_id";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("vin_id", vinId);
		return Optional.ofNullable(
				jdbcTemplate.query(sql, params, new VinResultSetExtractor()));
	}
	
	public Optional<Chassis> fetchChassis(String chassisId){
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM chassis "
				+ "WHERE chassis_id = :chassis_id";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("chassis_id", chassisId);
		return Optional.ofNullable(
				jdbcTemplate.query(sql,  params, new ChassisResultSetExtractor()));
	}
	
	public Optional<Engine> fetchEngine(String engineId){
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM engine "
				+ "WHERE engine_id = :engine_id";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("engine_id", engineId);
		return Optional.ofNullable(
				jdbcTemplate.query(sql, params, new EngineResultSetExtractor()));
	}
	
	class VinResultSetExtractor implements ResultSetExtractor<Vin>{
		@Override
		public Vin extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		
		// @formatter:off
		return Vin.builder()
				.vinId(rs.getString("vin_id"))
				.vinPK(rs.getLong("vin_pk"))
				.vinOneThree(rs.getString("vin_one_three"))
				.wheelTorque(rs.getInt("wheel_torque"))
				.build();

				
		// @formatter:on
		}
	}
	
	class ChassisResultSetExtractor implements ResultSetExtractor<Chassis>{
		@Override
		public Chassis extractData(ResultSet rs) throws SQLException {
			rs.next();		
		
		// @formatter:off
		return Chassis.builder()
				.chassisId(rs.getString("chassis_id"))
				.chassisPK(rs.getLong("chassis_pk"))
				.vinId(rs.getString("vin_id"))
				.vehicleName(rs.getString("vehicle_name"))
				.build();
		// @formatter:on
		}
	}
	
	class EngineResultSetExtractor implements ResultSetExtractor<Engine>{
		@Override
		public Engine extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		// @formatter:off
			return Engine.builder()
					.engineId(rs.getFloat("engine_id"))
					.enginePK(rs.getLong("engine_pk"))
					.oilCapacity(rs.getFloat("oil_capacity"))
					.engineSize(rs.getFloat("engine_size"))
					.build();
		// @formatter:on
		}
	}

	class SqlParams {
		String sql;//this is used in the saveAddition method
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
}
