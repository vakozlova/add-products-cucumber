package com.autotest.steps;

import com.autotest.utils.DatabaseConnectionTest;
import io.cucumber.java.ru.*;
import io.qameta.allure.Step;

import java.sql.*;

public class StepsDatabaseTest {

    @Дано("подключение к БД")
    @Step("Подключиться к базе данных")
    public void test() throws SQLException {
        Connection connection = DatabaseConnectionTest.getConnection();
        Statement statement = connection.createStatement();
    }

    @И("проверен список БД")
    @Step("Проверить текущий список товаров в базе данных")
    public void исходная_БД () throws SQLException {
        Connection connection = DatabaseConnectionTest.getConnection();
        Statement statement = connection.createStatement();

        System.out.println("Исходная БД:");
        String all = "Select * FROM FOOD";
        ResultSet rs = statement.executeQuery(all);
        while (rs.next()) {
            int FOOD_ID = rs.getInt("FOOD_ID");
            String FOOD_NAME = rs.getString("FOOD_NAME");
            String FOOD_TYPE = rs.getString("FOOD_TYPE");
            int FOOD_EXOTIC = rs.getInt("FOOD_EXOTIC");
            System.out.printf("%d, %s, %s, %d%n", FOOD_ID, FOOD_NAME, FOOD_TYPE, FOOD_EXOTIC);
        }
        System.out.println("*********************");
    }

    @Тогда("добавляем новый товар в список БД")
    @Step("Добавить новый товар в базу данных")
    public void добавить_товар() throws SQLException {
        Connection connection = DatabaseConnectionTest.getConnection();
        Statement statement = connection.createStatement();

        System.out.println("БД после добавления товара:");

        statement.executeUpdate("INSERT INTO FOOD VALUES ('5', 'Баклажан', 'VEGETABLE', '0')");

        String all1 = "Select * FROM FOOD";
        ResultSet rs1 = statement.executeQuery(all1);
        while (rs1.next()) {
            int FOOD_ID1 = rs1.getInt("FOOD_ID");
            String FOOD_NAME1 = rs1.getString("FOOD_NAME");
            String FOOD_TYPE1 = rs1.getString("FOOD_TYPE");
            int FOOD_EXOTIC1 = rs1.getInt("FOOD_EXOTIC");
            System.out.printf("%d, %s, %s, %d%n", FOOD_ID1, FOOD_NAME1, FOOD_TYPE1, FOOD_EXOTIC1);
        }
        System.out.println("*********************");
    }
    @Тогда("добавляем существующий товар в список БД")
    @Step("Добавить уже существующий товар в базу данных")
    public void добавить_уже_существующий_товар() throws SQLException {
        Connection connection = DatabaseConnectionTest.getConnection();
        Statement statement = connection.createStatement();

        System.out.println("БД после добавления товара:");

        statement.executeUpdate("INSERT INTO FOOD VALUES ('5', 'Баклажан', 'VEGETABLE', '0')");

        String all1 = "Select * FROM FOOD";
        ResultSet rs1 = statement.executeQuery(all1);
        while (rs1.next()) {
            int FOOD_ID1 = rs1.getInt("FOOD_ID");
            String FOOD_NAME1 = rs1.getString("FOOD_NAME");
            String FOOD_TYPE1 = rs1.getString("FOOD_TYPE");
            int FOOD_EXOTIC1 = rs1.getInt("FOOD_EXOTIC");
            System.out.printf("%d, %s, %s, %d%n", FOOD_ID1, FOOD_NAME1, FOOD_TYPE1, FOOD_EXOTIC1);
        }
        System.out.println("*********************");
    }

    @И("удаляем товар из списка в БД")
    @Step("Удалить товар из базы данных")
    public void удалить_товар() throws SQLException {
        Connection connection = DatabaseConnectionTest.getConnection();
        Statement statement = connection.createStatement();

        System.out.println("БД после удаления товара:");
        statement.executeUpdate("DELETE FROM FOOD WHERE FOOD_NAME = 'Баклажан'");

        String all2 = "Select * FROM FOOD";
        ResultSet rs2 = statement.executeQuery(all2);
        while (rs2.next()) {
            int FOOD_ID2 = rs2.getInt("FOOD_ID");
            String FOOD_NAME2 = rs2.getString("FOOD_NAME");
            String FOOD_TYPE2 = rs2.getString("FOOD_TYPE");
            int FOOD_EXOTIC2 = rs2.getInt("FOOD_EXOTIC");
            System.out.printf("%d, %s, %s, %d%n", FOOD_ID2, FOOD_NAME2, FOOD_TYPE2, FOOD_EXOTIC2);
        }
    }
}
