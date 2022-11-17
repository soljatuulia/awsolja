/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.virkkunen.weather2pricetests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Solja
 */
public class Weather2PriceTests {

    
    public static void main(String[] args) {
        System.out.println("Etsi sähkön hinta vuodelle ja kuukaudelle (2021M12)");
        try {
            //httpClientPost("2021M12");
        } catch (Exception ex) {
            Logger.getLogger(Weather2PriceTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static List<Movie> jsonToObjectList(String json) {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Movie[] movieArray = mapper.readValue(json, Movie[].class);
            List<Movie> movieList = Arrays.asList(movieArray);
            return movieList;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
    
//    private Connection getConnection() throws SQLException {
//        try {    
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
//            return con;
//       
//        } catch (SQLException ex) {    
//            ex.printStackTrace();
//        } return null;
//    }    


//    static String httpClientPost(String ym) throws Exception {
//        String url = "https://pxdata.stat.fi:443/PxWeb/api/v1/fi/StatFin/ehi/statfin_ehi_pxt_12gc.px";
//        String json = "{\n" +
//"  \"query\": [\n" +
//"    {\n" +
//"      \"code\": \"Kuukausi\",\n" +
//"      \"selection\": {\n" +
//"        \"filter\": \"item\",\n" +
//"        \"values\": [\n" +
//"          \""+ym+"\"\n" +
//"        ]\n" +
//"      }\n" +
//"    },\n" +
//"    {\n" +
//"      \"code\": \"Nord Pool -alue\",\n" +
//"      \"selection\": {\n" +
//"        \"filter\": \"item\",\n" +
//"        \"values\": [\n" +
//"          \"G\"\n" +
//"        ]\n" +
//"      }\n" +
//"    },\n" +
//"    {\n" +
//"      \"code\": \"Tiedot\",\n" +
//"      \"selection\": {\n" +
//"        \"filter\": \"item\",\n" +
//"        \"values\": [\n" +
//"          \"hinta_sahko_eur_mwh\"\n" +
//"        ]\n" +
//"      }\n" +
//"    }\n" +
//"  ],\n" +
//"  \"response\": {\n" +
//"    \"format\": \"json-stat2\"\n" +
//"  }\n" +
//"}";
//        System.out.println(json);
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI(url))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(json))
//                .build();
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        json = response.body();
////        Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(json);
////        while (m.find()) {
////            double d = Double.parseDouble(m.group(1));
////            System.out.println(d);
////        }
//        System.out.println(json);
//        String price = json.substring(755,761);
//        System.out.println(price);
//        //System.out.println(json.substring(755,760));
////        Scanner sc = new Scanner(json);
////        double price1 = sc.nextDouble();
////        System.out.println(price1);
//        return price;
//    }
}

