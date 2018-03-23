/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rpgquest.Model.Player;

/**
 *
 * @author Student
 */
public class DBManager {

    private Connection connect;

    private void ConnectToDB() {
        if (this.connect == null) {
            try {
                this.connect = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mortalquestcw",
                        "root",
                        "");
            } catch (SQLException ex) {
                System.out.println("Cannot connect to DB");
                this.connect = null;
            }
        }
    }

    public void QueryDB() {
        ConnectToDB();
        try {
            Statement statement = connect.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Player");
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                System.out.println(id);
                System.out.println(name);
            }
        } catch (SQLException ex) {
            System.out.println("SQL error");
        }
    }

    public void AddPlayer(Player player) {
        ConnectToDB();
        try {
            Statement statement = connect.createStatement();
            String command = ("INSERT INTO Player (Name) VALUES ('" + player.GetName() + "')");
            statement.execute(command);
        } catch (SQLException ex) {
            System.out.println("SQL error");
        }

    }

    public Player RetrievePlayer(int id) {
        ConnectToDB();
        String query = "select name from player where id = ?";
        try {
            PreparedStatement command = connect.prepareStatement(query);
            command.setInt(1, id);
            ResultSet resultSet = command.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            Player player = new Player(name);
            return player;
        } catch (SQLException ex) {
            System.out.println("SQL Error");
        }
        return null;
    }
}
