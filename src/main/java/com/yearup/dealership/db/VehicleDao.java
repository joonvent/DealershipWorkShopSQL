package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;
import jdk.jshell.spi.SPIResolutionException;

import javax.sql.DataSource;
import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        // TODO: Implement the logic to add a vehicle

        String query = "INSERT into Vehicles(VIN , make , model , year , sold , color ,vehicleType , odometer , price) Values (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setBoolean(5, vehicle.isSold());
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setString(7, vehicle.getVehicleType());
            preparedStatement.setInt(8, vehicle.getOdometer());
            preparedStatement.setDouble(9, vehicle.getPrice());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + "vehicle added");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void removeVehicle(String VIN) {
        // TODO: Implement the logic to remove a vehicle
        String query = "DELETE FROM Vehicles WHERE VIN = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, VIN);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + "Car Removed");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM Vehicles WHERE price >= ? AND price <= ? ";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);


            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));


                vehicles.add(vehicle);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<Vehicle>();
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        // TODO: Implement the logic to search vehicles by make and model
        List<Vehicle> makemodel = new ArrayList<>();

        String query = "SELECT * FROM Vehicles WHERE make = ? and model = ? ";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));

                makemodel.add(vehicle);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return makemodel;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        // TODO: Implement the logic to search vehicles by year range
        List<Vehicle> yearResult = new ArrayList<>();

        String query = "SELECT * FROM Vehicles WHERE year >= ? AND year <= ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, minYear);
            preparedStatement.setInt(2, maxYear);


            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));

                yearResult.add(vehicle);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return yearResult;
    }

    public List<Vehicle> searchByColor(String color) {
        // TODO: Implement the logic to search vehicles by color
        List<Vehicle> colorSearch = new ArrayList<>();

        String query = "SELECT * FROM Vehicles WHERE color = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, color);


            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));

                colorSearch.add(vehicle);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


        return colorSearch;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        // TODO: Implement the logic to search vehicles by mileage range

        List<Vehicle> mileageSearch = new ArrayList<>();

        String query = "SELECT * FROM Vehicles WHERE odometer <= ? AND odometer >= ?";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, minMileage);
            preparedStatement.setInt(2, maxMileage);


            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));

                mileageSearch.add(vehicle);

            }


        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return mileageSearch;
    }

    public List<Vehicle> searchByType(String type) {
        // TODO: Implement the logic to search vehicles by type
        List<Vehicle> typeSearch = new ArrayList<>();

        String query = "SELECT * FROM Vehicles WHERE VehicleType = ? ";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, type);


            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));

                typeSearch.add(vehicle);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


        return typeSearch;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
