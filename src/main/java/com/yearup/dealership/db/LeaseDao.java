package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;
import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        // TODO: Implement the logic to add a lease contract

        String query = "INSERT INTO lease_contracts (vin , leaseStart , leaseEnd , monthyPayment)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, leaseContract.getVin());
            preparedStatement.setDate(2, leaseContract.getLeaseStart());
            preparedStatement.setDate(3, leaseContract.getLeaseEnd());
            preparedStatement.setDouble(4, leaseContract.getMonthlyPayment());

            int rows = preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();

        }

    }
}
