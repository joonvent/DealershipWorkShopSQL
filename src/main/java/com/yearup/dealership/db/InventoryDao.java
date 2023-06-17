package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;
import org.apache.commons.dbcp2.datasources.PerUserPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        // TODO: Implement the logic to add a vehicle to the inventory
        String query = "INSERT into Inventory (vin , dealership) VALUES (?,?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, vin);
            preparedStatement.setInt(2, dealershipId);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + "Added to Inventory");

        }catch (Exception ex){
            ex.printStackTrace();
        }



    }

        public void removeVehicleFromInventory(String vin){
            // TODO: Implement the logic to remove a vehicle from the inventory

            String query = "DELETE FROM INVENTORY WHERE VIN = ?";

            try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, vin);

                int rows = preparedStatement.executeUpdate();
                System.out.println(rows + "Changes have been made:");
            }catch (Exception ex ){
                ex.printStackTrace();

        }
    }
}
