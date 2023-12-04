import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.56.101:4567/music_db",
                    "root", "1234");
            Statement stmt = con.createStatement();


            // scanner 선언
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------------\n");
            System.out.println("1. 노래 검색                       2. 가수 검색\n");
            System.out.println("3. 최신순으로 앨범보기               4. 인기순으로 앨범보기\n");
            System.out.println("5. 프로그램 종료\n");
            System.out.println("-----------------------------------------------------------------------\n");
            System.out.println("원하는 기능을 선택하시오(1: 노래 검색, 2: 가수 검색, 3: 최신순으로 앨범보기, 4: 인기순으로 앨범보기, 5: 프로그램 종료): ");


            int catalog = scanner.nextInt(); // 원하는 기능 번호 변수
            scanner.nextLine();

            while(catalog != 5) {

                if(catalog == 1) {
                    System.out.println("노래 검색: ");
                    String search_song = scanner.nextLine();
                    ResultSet rs = stmt.executeQuery("SELECT GROUP_CONCAT(DISTINCT si.siname SEPARATOR ', '), so.soname FROM singer si, song so, song_singer ss " +
                            "WHERE ss.soin = so.soin AND ss.siin = si.siin AND so.soname LIKE '%"+search_song+"%'");
                    while(rs.next()) {
                            System.out.println(rs.getString(2)+" "+rs.getString(1));

                    }
                }

                if(catalog == 2) {
                    System.out.println("가수 검색: ");
                    String search_singer = scanner.nextLine();
                    ResultSet rs = stmt.executeQuery("SELECT si.siname, so.soname FROM singer si, song so, song_singer ss " +
                            "WHERE ss.soin = so.soin AND ss.siin = si.siin AND si.siname LIKE '%"+search_singer+"%'");
                    while(rs.next()) {
                        System.out.println(rs.getString(1)+" "+rs.getString(2));
                    }

                }

                if(catalog == 3) {
                    ResultSet rs = stmt.executeQuery("SELECT aname FROM album ORDER BY release_date DESC;");
                    while(rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                }

                if(catalog == 4) {
                    ResultSet rs = stmt.executeQuery("SELECT aname FROM album ORDER BY heart_num DESC;");
                    while(rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                }


                con.close();

                System.out.println("원하는 기능을 선택하시오(1: 노래 검색, 2: 가수 검색, 3: 최신순으로 앨범보기, 4: 인기순으로 앨범보기, 5: 프로그램 종료): ");
                con = DriverManager.getConnection("jdbc:mysql://192.168.56.101:4567/music_db",
                        "root", "1234");
                stmt = con.createStatement();

                catalog = scanner.nextInt(); // 원하는 기능 번호 변수
                scanner.nextLine();
            }

            System.out.println("시스템이 종료되었습니다.");
        } catch(Exception e) { System.out.println(e);}
    }
}