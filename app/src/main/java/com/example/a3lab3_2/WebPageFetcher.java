package com.example.a3lab3_2;

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.Objects;
import java.util.Scanner;


public class WebPageFetcher extends Thread {

  String urlString;
  String content;


  public interface MyInterface {
    void returnContent(String content);
  }

  public WebPageFetcher(MyInterface myInterface, String u) {
    callBackInterface = myInterface;
    urlString = u;
  }

  MyInterface callBackInterface = null;

  public void run() {
    try {
      URL url = new URL(urlString);
      URLConnection urlConnection = url.openConnection();
      InputStream inputStream = urlConnection.getInputStream();
      Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
      content = scanner.hasNext() ? scanner.next() : "";

      callBackInterface.returnContent(content);
    }catch (Exception e) {
      e.printStackTrace();
    }

  }

}
