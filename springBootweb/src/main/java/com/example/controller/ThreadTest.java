package com.example.controller;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;

import static org.asynchttpclient.Dsl.asyncHttpClient;

/**
 * @Author lihang 【962309372@qq.com】
 * @Description
 * @Date 2017/9/14 19:59
 */
public class ThreadTest extends Thread {
    @Override
    public void run(){
        String name="aa";
        AsyncHttpClient asyncHttpClient = asyncHttpClient();
        CompletableFuture<Response> promise = asyncHttpClient
                .prepareGet("http://127.0.0.1:8080/front/questions/find.json?name="+name)
                .execute()
                .toCompletableFuture()
                .exceptionally(t -> { return null; } )
                .thenApply(resp -> { /*  Do something with the Response */ return resp; });
        System.out.println(promise.join().getResponseBody());
    }
}
