package com.example.partsUnlimited.dao;


import java.util.List;
import java.util.Optional;

import com.example.partsUnlimited.model.Brand;
import com.example.partsUnlimited.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.partsUnlimited.model.Part;

@Repository("mysql")
public class PartDataAccessService implements PartDao{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PartDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertPart(Part part) {
		String sql = "" +
				"INSERT INTO part(" +
				"serialNumber," +
				"manufacturingDate)" +
				"VALUES (?, ?)";
		return jdbcTemplate.update(
				sql,
				part.getSerial_id(),
				part.getDate());
	}

	@Override
	public List<Part> selectAllParts() {
		String sql = "SELECT serialNumber, manufacturingDate FROM part";
		List <Part> parts = jdbcTemplate.query(sql, (resultSet, i) -> {
			String id = resultSet.getString("serialnumber");
			String date = resultSet.getString("manufacturingDate");
			return new Part(id, date);
		});
		return parts;
	}

	@Override
	public Optional<Part> selectPartById(String serial_id) {
		String sql = "SELECT serialNumber, manufacturingDate FROM part WHERE serialNumber = ?";
		Part part = jdbcTemplate.queryForObject(
				sql,
				new Object[]{serial_id},
				(resultSet, i) -> {
					String PartId = resultSet.getString("serialnumber");
					String date = resultSet.getString("manufacturingDate");
					return new Part(PartId, date);
				});
		return Optional.ofNullable(part);
	}

	@Override
	public Optional<Part> selectPartByDate(String manufacturingDate) {
		String sql = "SELECT serialNumber, manufacturingDate FROM part WHERE manufacturingDate = ?";
		Part part = jdbcTemplate.queryForObject(
				sql,
				new Object[]{manufacturingDate},
				(resultSet, i) -> {
					String partId = resultSet.getString("serialnumber");
					String date = resultSet.getString("manufacturingDate");
					return new Part(partId, date);
				});
		return Optional.ofNullable(part);
	}

	@Override
	public int deletePart(String serial_id) {
			String sql = "" +
					"DELETE FROM part " +
					"WHERE serialNumber = ?";
		return jdbcTemplate.update(sql, serial_id);
	}

	/*@Override
	public Optional List<Part> selectPartByBrandAndCarName(String BrandAndCarName) {
		String [] words = BrandAndCarName.split("\\s");
		String BrandName = words[0];
		String CarName = words[1];
		String sql ="" +
				"SELECT brand.name, car.name, COUNT(part.id) FROM part" +
				"INNER JOIN car ON car.id = part.idCar" +
				"INNER JOIN brand ON brand.id = car.idBrand" +
				"GROUP BY brand.name, car.name"+
				"WHERE brand.name = ? AND car.name = ?";
		List <com.example.partsUnlimited.model.Part> parts = jdbcTemplate.query(sql, (resultSet, i) -> {
			String id = resultSet.getString("id");
			String date = resultSet.getString("manufacturingDate");
			return new com.example.partsUnlimited.model.Part(id, date);
		});
		return parts;
	}*/

	/*@Override
	public List<Car> selectCountPartsForCarModel() {
			String sql = "" +
					"SELECT brand.name, car.name, COUNT(part.id) FROM part" +
					"INNER JOIN car ON car.id = part.idCar" +
					"INNER JOIN brand ON brand.id = car.idBrand" +
					"GROUP BY brand.name, car.name;";
		return null;
	}*/

}
