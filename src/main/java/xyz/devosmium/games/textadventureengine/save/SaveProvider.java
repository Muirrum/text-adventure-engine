package xyz.devosmium.games.textadventureengine.save;

import xyz.devosmium.games.textadventureengine.mobiles.Player;
import xyz.devosmium.games.textadventureengine.mobiles.Stats;

import java.sql.*;

/**
 * SaveProvider
 *
 * SaveProvider base class allows for a user to select the type of save they would like to use. The SaveProvider
 * has two options for saving, SQLite and JSON format.
 *
 * @author Jessie Vela
 * @version 1.0
 * @since 21 OCT 2019
 */
public class SaveProvider {

    private Connection connection = null;
    private Statement statement;
    private Player player;

    /**
     * SQLite will instantiate a database called game.db. This database will hold all object information of the world
     * to be stored in the database.
     *
     * @param player player will allow access to methods used for retrieving stats for saving
     */
    public void SQLiteSave(Player player) {

        this.player = player;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:game.db");
            createTable();
            saveData();

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checks for the existence of the tables and creates them if not present.
     *
     *
     * @throws SQLException Query issues returns exception.
     */
    private void createTable() throws SQLException {
        statement = connection.createStatement();
        statement.setQueryTimeout(30);

        String sql = "CREATE TABLE IF NOT EXISTS PLAYER " +
                "(PLAYER_ID      TEXT PRIMARY KEY  NOT NULL, " +
                " NAME           TEXT    NOT NULL, " +
                " MAX_HEALTH     INT     NOT NULL, " +
                " HEALTH         INT     NOT NULL, " +
                " LEVEL          INT     NOT NULL, " +
                " GOLD           INT     NOT NULL )";
        statement.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS PLAYER_STATS " +
                "(PLAYER_ID      TEXT   NOT NULL, " +
                " STRENGTH       INT    NOT NULL, " +
                " DEXTERITY      INT    NOT NULL, " +
                " INTELLIGENCE   INT    NOT NULL, " +
                " LUCK           INT    NOT NULL, " +
                " WISDOM         INT    NOT NULL,  " +
                " FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER(PLAYER_ID))";
        statement.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS MOBILES " +
                "(MOBILE_ID     TEXT PRIMARY KEY NOT NULL," +
                " NAME          TEXT    NOT NULL," +
                " MAX_HEALTH    INT     NOT NULL," +
                " HEALTH        INT     NOT NULL," +
                " LEVEL         INT     NOT NULL )";
        statement.close();
    }

    /**
     * Takes game such as Player and Mobiles information and saves it to the database.
     *
     * @throws SQLException Query issues returns exception.
     */
    private void saveData() throws SQLException {

        //Prepare sql statement to insert player details into the Player Table in Game.db
        PreparedStatement stm = connection.prepareStatement("INSERT INTO PLAYER VALUES (?,?,?,?,?,?)");
        stm.setString(1, player.getPlayerID());
        stm.setString(2, player.getName());
        stm.setInt(3, player.getMaxHealth());
        stm.setInt(4, player.getHealth());
        stm.setInt(5, player.getLevel());
        stm.setInt(6, player.getGold());
        //Execute the SQL statement.
        stm.executeUpdate();

        /** Prepare sql statement to insert player stats into PLAYER_STATS Table in Game.db. PLAYER_STATS references
        *   PLAYER Table via foreign key using the Unique Player ID
        */
        stm = connection.prepareStatement("INSERT INTO PLAYER_STATS VALUES (?,?,?,?,?,?)");
        stm.setString(1, player.getPlayerID());
        stm.setInt(2, player.getStat(Stats.STRENGTH));
        stm.setInt(3, player.getStat(Stats.DEXTERITY));
        stm.setInt(4, player.getStat(Stats.INTELLIGENCE));
        stm.setInt(5, player.getStat(Stats.LUCK));
        stm.setInt(6, player.getStat(Stats.WISDOM));
        stm.executeUpdate();

    }

}