package org.j2os.project.repository;

import org.j2os.project.common.database.JDBC;
import org.j2os.project.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.10   Mahsa.h
 */
public class PersonDA implements AutoCloseable {

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public PersonDA() throws SQLException {
        connection = JDBC.getConnection();
    }

    public void insert(Person person) throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("select seq_person.nextval id from dual");
        ResultSet resultSet = preparedStatement1.executeQuery();
        resultSet.next();
        person.setId(resultSet.getInt("id"));
        preparedStatement = connection.prepareStatement("insert into person(id,name,family) values(?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws SQLException {
        preparedStatement = connection.prepareStatement("update person set name=?,family=? where id=?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setLong(3, person.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws SQLException {
        preparedStatement = connection.prepareStatement("delete person where id=?");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
    }

    public List<Person> selectAll() throws SQLException {
        preparedStatement = connection.prepareStatement("select * from Person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            personList.add(
                    new Person(resultSet.getInt("id")
                            , resultSet.getString("name")
                            , resultSet.getString("family")));

        }
        return personList;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
