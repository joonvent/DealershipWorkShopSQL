package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
        // TODO: Implement the logic to add a sales contract

        String query = "INSERT INTO sales_contract (contract_id, VIN, sale_date , price) Values (?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, salesContract.getContractId());
            preparedStatement.setString(2, salesContract.getVin());
            preparedStatement.setDate(3, Date.valueOf(salesContract.getSaleDate()));
            preparedStatement.setDouble(4, salesContract.getPrice());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " Sale Added");

        } catch (Exception ex) {
            ex.printStackTrace();


        }
    }
}
