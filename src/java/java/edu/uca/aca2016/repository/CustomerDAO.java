/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.edu.uca.aca2016.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author awood
 */
public class CustomerDAO {
 JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public int save(Customer Customer){
        String sql = "INSERT INTO Customer (Name) values(?)";
        
        Object[] values = {Customer.getName()};

        return template.update(sql, values);
    }

    public int update(Customer Customer){
        String sql = "UPDATE Customer SET Name=? WHERE CustomerId = ?";
        
        Object[] values = {Customer.getName(), Customer.getId()};
        
        return template.update(sql, values);
    }

    public int delete(int id){
        String sql = "DELETE FROM Customer WHERE CustomerId = ?";
        
        Object[] values = {id};
        
        return template.update(sql, values);
    }

    public List<Customer> getCustomersList(){
        return template.query("SELECT * FROM Customer",new RowMapper<Customer>(){
            public Customer mapRow(ResultSet rs,int row) throws SQLException{
                Customer a = new Customer();
                a.setId(rs.getInt("CustomerId"));
                a.setName(rs.getString("Name"));
                return a;
            }
        });
    }

    public Customer getCustomerById(int id){
        String sql = "SELECT CustomerId AS id, Name FROM Customer WHERE CustomerId = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));
    }
}   

