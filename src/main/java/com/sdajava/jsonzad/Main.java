package com.sdajava.jsonzad;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

                JSONParser parser = new JSONParser();

                List<Model> modelList = new ArrayList<>();

                try{
                    URL url = new URL("http://lukaszogan.com/data.json");
                    URLConnection connect = url.openConnection();
                    BufferedReader in =
                            new BufferedReader(new InputStreamReader(connect.getInputStream()));

                    String line;
                    String dateToString;
                    String [] substring;
                    String startDate = "2016-12-01";
                    String endDate = "2017-01-02";

                    while ((line = in.readLine()) != null){

                        JSONArray array = (JSONArray) parser.parse(line);

                        for(Object obj: array){

                            JSONObject json = (JSONObject) obj;

                            dateToString = json.get("post_date").toString();
                            substring = dateToString.split(" ");

                            modelList.add(new Model(json.get("ID"),
                                    json.get("post_author"),
                                    LocalDate.parse(substring[0]),
                                    json.get("post_content"),
                                    json.get("post_modified"),
                                    json.get("post_status")));
                            //System.out.println("ID posta " + json.get("ID"));

                            List<Object> modelsDate = modelList.stream()
                                    .limit(ChronoUnit.DAYS.between(LocalDate.parse(startDate), LocalDate.parse(endDate)))
                                    .map(p -> p.getPost_content())
                                    .collect(Collectors.toList());
                        }

                        modelList.forEach(System.out::println);

                    }


                }catch (ParseException | IOException err){

                }

            }
}
