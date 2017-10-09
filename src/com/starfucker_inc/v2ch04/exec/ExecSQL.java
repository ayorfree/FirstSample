package com.starfucker_inc.v2ch04.exec;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-10-09-上午10:29
 */

public class ExecSQL {
    public static void main(String[] args) throws IOException {
        try {
            Scanner in = args.length == 0 ? new Scanner(System.in) : new Scanner(Paths.get(args[0]));

            try (Connection conn = getConnection()) {
                Statement stat = conn.createStatement();

                while (true) {
                    if (args.length == 0) System.out.println("Enter command or Exit to exit: ");

                    if (!in.hasNextLine()) return;

                    String line = in.nextLine();
                    if (line.equalsIgnoreCase("EXIT")) return;
                    if (line.trim().endsWith(";")) {
                        line = line.trim();
                        line = line.substring(0, line.length() - 1);
                    }
                    try {
                        boolean isResult = stat.execute(line);
                        if (isResult) {
                            ResultSet rs = stat.getResultSet();
                            showResultSet(rs);
                        }
                        else {
                            int updateCount = stat.getUpdateCount();
                            System.out.println(updateCount + " rows updated");
                        }
                    }
                    catch (SQLException ex) {
                        for (Throwable e :
                                ex) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        catch (SQLException ex) {
            for (Throwable e :
                    ex) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("datebase.properties"))) {
            props.load(in);
        }

        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }

    public static void showResultSet(ResultSet result) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 0; i <= columnCount; i++) {
            if (i > 1) System.out.println(", ");
            System.out.println(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (result.next()) {
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) System.out.println(", ");
                System.out.println(result.getString(1));
            }
            System.out.println();
        }
    }
}
