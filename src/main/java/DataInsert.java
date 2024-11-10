import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class DataInsert {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String filePath = "C:\\dev\\eclipse-workspace\\Mission1\\wifi.json";
        String xSwifiMgrNo;
        String xSwifiWrdofc;
        String xSwifiMainNm;
        String xSwifiAdres1;
        String xSwifiAdres2;
        String xSwifiInstlFloor;
        String xSwifiInstlTy;
        String xSwifiInstlMby;
        String xSwifiSvcSe;
        String xSwifiCmcwr;
        String xSwifiCnstcYear;
        String xSwifiInoutDoor;
        String xSwifiRemars3;
        String lat;
        String lnt;
        String workDttm;
        try {
            String driverClassName = "org.mariadb.jdbc.Driver";
            String url = "jdbc:mariadb://localhost:3306/wifi";
            String user = "wifiuser";
            String password = "wifi";
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
            System.out.println("** Driver:" + driverClassName + ", Connection:" + connection);
            statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("드라이버 로딩 실패");
            ex.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql 오류 : 이미 생성");
        } finally {
            CloseUtil.close(null, statement, connection);
        }
        try {
            String driverClassName = "org.mariadb.jdbc.Driver";
            String url = "jdbc:mariadb://localhost:3306/wifi";
            String user = "wifiuser";
            String password = "wifi";
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
            System.out.println("** Driver:" + driverClassName + ", Connection:" + connection);
            Reader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArr = (JSONArray) jsonObject.get("DATA");
            String SQL = " insert into public_wifi "
                    + " ( x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_main_nm, x_swifi_adres1, x_swifi_adres2, "
                    + " x_swifi_instl_floor, x_swifi_instl_ty, x_swifi_instl_mby, x_swifi_svc_se, x_swifi_cmcwr, "
                    + " x_swifi_cnstc_year, x_swifi_inout_door, x_swifi_remars3, lat, lnt, work_dttm) "
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
            preparedStatement = connection.prepareStatement(SQL);
            if (jsonArr.size() > 0) {
                for (int i = 0; i < jsonArr.size(); i++) {
                    JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                    System.out.println((String) jsonObj.get("x_swifi_mgr_no"));
                    System.out.println((String) jsonObj.get("x_swifi_wrdofc"));
                    System.out.println((String) jsonObj.get("x_swifi_main_nm"));
                    System.out.println((String) jsonObj.get("x_swifi_adres1"));
                    System.out.println((String) jsonObj.get("x_swifi_adres2"));
                    System.out.println((String) jsonObj.get("x_swifi_instl_floor"));
                    System.out.println((String) jsonObj.get("x_swifi_instl_ty"));
                    System.out.println((String) jsonObj.get("x_swifi_instl_mby"));
                    System.out.println((String) jsonObj.get("x_swifi_svc_se"));
                    System.out.println((String) jsonObj.get("x_swifi_cmcwr"));
                    System.out.println((String) jsonObj.get("x_swifi_cnstc_year"));
                    System.out.println((String) jsonObj.get("x_swifi_inout_door"));
                    System.out.println((String) jsonObj.get("x_swifi_remars3"));
                    System.out.println((String) jsonObj.get("lat"));
                    System.out.println((String) jsonObj.get("lnt"));
                    System.out.println(String.valueOf(jsonObj.get("work_dttm")));
                    xSwifiMgrNo = (String) jsonObj.get("x_swifi_mgr_no");
                    xSwifiWrdofc = (String) jsonObj.get("x_swifi_wrdofc");
                    xSwifiMainNm = (String) jsonObj.get("x_swifi_main_nm");
                    xSwifiAdres1 = (String) jsonObj.get("x_swifi_adres1");
                    xSwifiAdres2 = (String) jsonObj.get("x_swifi_adres2");
                    xSwifiInstlFloor = (String) jsonObj.get("x_swifi_instl_floor");
                    xSwifiInstlTy = (String) jsonObj.get("x_swifi_instl_ty");
                    xSwifiInstlMby = (String) jsonObj.get("x_swifi_instl_mby");
                    xSwifiSvcSe = (String) jsonObj.get("x_swifi_svc_se");
                    xSwifiCmcwr = (String) jsonObj.get("x_swifi_cmcwr");
                    xSwifiCnstcYear = (String) jsonObj.get("x_swifi_cnstc_year");
                    xSwifiInoutDoor = (String) jsonObj.get("x_swifi_inout_door");
                    xSwifiRemars3 = (String) jsonObj.get("x_swifi_remars3");
                    lat = (String) jsonObj.get("lat");
                    lnt = (String) jsonObj.get("lnt");
                    workDttm = String.valueOf(jsonObj.get("work_dttm"));
                    preparedStatement.setString(1, xSwifiMgrNo);
                    preparedStatement.setString(2, xSwifiWrdofc);
                    preparedStatement.setString(3, xSwifiMainNm);
                    preparedStatement.setString(4, xSwifiAdres1);
                    preparedStatement.setString(5, xSwifiAdres2);
                    preparedStatement.setString(6, xSwifiInstlFloor);
                    preparedStatement.setString(7, xSwifiInstlTy);
                    preparedStatement.setString(8, xSwifiInstlMby);
                    preparedStatement.setString(9, xSwifiSvcSe);
                    preparedStatement.setString(10, xSwifiCmcwr);
                    preparedStatement.setString(11, xSwifiCnstcYear);
                    preparedStatement.setString(12, xSwifiInoutDoor);
                    preparedStatement.setString(13, xSwifiRemars3);
                    preparedStatement.setString(14, lat);
                    preparedStatement.setString(15, lnt);
                    preparedStatement.setString(16, workDttm);
                    int r = preparedStatement.executeUpdate();
                    System.out.println("SQL 실행 : " + r + "개의 row 삽입");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(null, statement, connection);
        }
    }
}