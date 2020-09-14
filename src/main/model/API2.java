package model;


import com.google.inject.internal.asm.$Type;
import javafx.util.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;


public class API2 {

    public static Match match;
    public static MatchScore matchScore;
    private static HttpURLConnection connection;
    public static ArrayList<Match> matches = new ArrayList();
    public static ArrayList<MatchScore> matchScores = new ArrayList();

    public static void mainCaller() {
        main(null);
    }

    @SuppressWarnings("checkstyle:MethodLength")
    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -318);
        Date date = calendar.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String inActiveDate = null;
        inActiveDate = format1.format(date);

        BufferedReader reader;
        java.lang.String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("https://www.balldontlie.io/api/v1/games?dates[]=" + inActiveDate);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();

            System.out.println(responseContent.toString());
            parse(responseContent.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

    }

    public static String parse(String responseBody) {
        JSONObject dataSet = new JSONObject(responseBody);
        JSONArray games = dataSet.getJSONArray("data");
        for (int i = 0; i < games.length(); i++) {
            JSONObject game = games.getJSONObject(i);
            JSONObject homeNames = game.getJSONObject("home_team");
            JSONObject visitorNames = game.getJSONObject("visitor_team");
            String homeTeam = homeNames.getString("full_name");
            String visitorTeam = visitorNames.getString("full_name");
            Integer homeTeamScore = game.getInt("home_team_score");
            Integer visitorTeamScore = game.getInt("visitor_team_score");
            match = new Match(homeTeam, visitorTeam);
            matchScore = new MatchScore(homeTeamScore, visitorTeamScore);
            matches.add(match);
            matchScores.add(matchScore);
        }
        return null;
    }

}
