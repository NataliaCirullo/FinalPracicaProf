package com.company;

import com.company.controller.ControllerLoguin;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        ControllerLoguin servlet = new ControllerLoguin();
        try {
            servlet.Loguin();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
